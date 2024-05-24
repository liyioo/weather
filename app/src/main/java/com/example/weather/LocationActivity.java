package com.example.weather;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.weather.base.BaseActivity;
import com.example.weather.bean.CityInfoBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationActivity extends BaseActivity implements View.OnClickListener {


    private LocationManager mLocationManager;//定位管理器对象
    private Handler mHandler = new Handler();//处理器对象
    private boolean isLocationEnable = false;//定位服务是否可用
    String url1 = "https://api.caiyunapp.com/v2/place?query=";
    String url2 = "&token={Pc7FiRrbxSK03cOp}&lang=zh_CN";
    TextView tv_city;
    TextView tv_ensure ;
    String city = "";
    private Intent intent;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 104;
    private AlertDialog locationPermissionDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loction);
        tv_ensure = findViewById(R.id.location_tv_ensure);
        tv_ensure.setOnClickListener(this);


    }


    @Override
    protected void onResume() {
        Log.i("resume","resume");
        super.onResume();

        mHandler.removeCallbacks(mRefrsh);
        initLocation();
        mHandler.postDelayed(mRefrsh,100);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mLocationManager.removeUpdates(mLocationListener);
    }

    private Runnable mRefrsh = new Runnable() {
        @Override
        public void run() {

            if(!isLocationEnable){
                initLocation();
                mHandler.postDelayed(this,1000);
            }
        }
    };

    /*初始化定位服务*/
    private void initLocation() {
        mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();//创建一个定位准则对象
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setBearingRequired(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String bestProvider = mLocationManager.getBestProvider(criteria,true);

        if (bestProvider != null) {
            if (mLocationManager.isProviderEnabled(bestProvider)) {
                beginLocation(bestProvider);
                isLocationEnable = true;
            } else {
                isLocationEnable = false;
            }
        } else {
            Log.e("Location", "No provider found");
            // 处理找不到位置提供程序的情况
        }

    }

    private String getCurrentCity(Location location){
        if(location != null){

            Log.i("location",location.getLongitude() +"," + location.getLatitude());

//            String url3 = "https://api.caiyunapp.com/v2.5/Pc7FiRrbxSK03cOp/";
            String lng = String.valueOf(location.getLongitude()) ;
            String lat = String.valueOf(location.getLatitude());
            /*String url4 = "/daily.json";
            String urlNow = url3 + lng + "," +lat +url4;*/
            Geocoder ge = new Geocoder(this, Locale.getDefault());
            List<Address> list = null;
            try {
                list = ge.getFromLocation(Double.parseDouble(lat),Double.parseDouble(lng),1);

                if(list != null && list.size() > 0){

                    Address ad = list.get(0);

                    city = "" + ad.getSubLocality();
                    if(city != null){
                        tv_city = findViewById(R.id.location_tv_city);
                        tv_city.setText(city);
//                        Toast.makeText(this,city,Toast.LENGTH_SHORT).show();
                        return city;
                    }else{
                        Toast.makeText(this,city,Toast.LENGTH_SHORT).show();
                    }

//                        Toast.makeText(this,ad.getLocality(),Toast.LENGTH_SHORT).show();
                }
//                Log.i("location","no");

//                if(!cityList.contains(city) && !TextUtils.isEmpty(city)){
//                    cityList.add(city);
//                    reloadDataAndRefreshUI();
//                }else{
//                    Log.i("location","no");
//                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }else{
            Log.i("location","null");
        }

        return "";
    }

    private void reloadDataAndRefreshUI() {

    }


    private void beginLocation(String method){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this,"请授予定位权限并开启定位功能",Toast.LENGTH_SHORT).show();
            return;
        }
        mLocationManager.requestLocationUpdates(method,300,0,mLocationListener);
        Location location = mLocationManager.getLastKnownLocation(method);
        getCurrentCity(location);
    }

    private LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            getCurrentCity(location);
        }
    };

    @Override
    public void onSuccess(String result) {
        CityInfoBean bean = new Gson().fromJson(result,CityInfoBean.class);
        if(bean.getStatus().equals("ok")){
            intent = new Intent(this, MainActivity.class);
//            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            if(city != null){
                Log.i("city33","1111");
                intent.putExtra("city",city);
                startActivity(intent);
            }


        }else{
            Toast.makeText(this, "暂时未收录该城市", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.location_tv_ensure){
            if(city != null){
                String url = url1 + city + url2;
                Log.w("city22",url);
                loadData(url);

            }

        }

    }
}