package com.example.weather;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.Manifest;
import androidx.core.app.ActivityCompat;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.weather.base.BaseActivity;
import com.example.weather.cityManager.CityManagerActivity;
import com.example.weather.db.DBManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener {
    ImageView addCity_iv,more_iv,location_iv;
    LinearLayout pointLayout;
    RelativeLayout layout;
    ViewPager mainVp;
    private CityFragmentPagerAdapter adapter;
    //viewPager的数据源
    List<Fragment> fragmentList;
    //想要显示的城市集合
    List<String> cityList;
    //表示ViewPager指示器的集合
    List<ImageView>imgList;

    CityWeatherFragment cwFragment;
    private SharedPreferences pref;

    private int bgNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.main);
        addCity_iv = findViewById(R.id.main_iv_add);
        location_iv = findViewById(R.id.main_iv_location);
        more_iv = findViewById(R.id.main_iv_more);
        pointLayout = findViewById(R.id.main_bottom_layout_middle);
        mainVp = findViewById(R.id.main_vp);
        addCity_iv.setOnClickListener(this);
        more_iv.setOnClickListener(this);
        location_iv.setOnClickListener(this);

        fragmentList = new ArrayList<>();
        cityList = DBManager.queryAllCityName();//获取数据库的城市列表

        imgList = new ArrayList<>();

        changebg();
        if(cityList.size() == 0){
            cityList.add("北京");
            cityList.add("上海");

        }
        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        Log.i("city",city==null?"yes":city);
        if(!cityList.contains(city) && !TextUtils.isEmpty(city)){
            cityList.add(city);
        }

        //初始化ViewPager
        initPager();

        adapter = new CityFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        mainVp.setAdapter(adapter);
        initPoint();
        mainVp.setCurrentItem(fragmentList.size() - 1);
//设置ViewPager的页面监听器
        setPagerListener();


    }



    /*换壁纸的函数*/
    public void changebg(){
        pref =getSharedPreferences("bg_pref",MODE_PRIVATE);
        bgNum = pref.getInt("bg",2);
        if(bgNum == 0){
            layout.setBackgroundResource(R.mipmap.bg);
        }else if(bgNum == 1){
            layout.setBackgroundResource(R.mipmap.bg2);
        }else if(bgNum == 2){
            layout.setBackgroundResource(R.mipmap.bg3);
        }
    }


    private void setPagerListener() {
//设置监听事件
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0;i < imgList.size();i ++){
                    imgList.get(i).setImageResource(R.mipmap.a1);
                }
                imgList.get(position).setImageResource(R.mipmap.a2);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    private void initPoint() {
        //小圆点指示器的函数
        for(int i = 0;i < fragmentList.size();i ++){
            ImageView pIv = new ImageView(this);
            pIv.setImageResource(R.mipmap.a1);
            pIv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams)pIv.getLayoutParams();
            lp.setMargins(0,0,20,0);
            imgList.add(pIv);
            pointLayout.addView(pIv);
        }
            //显示最近添加的一个城市
            imgList.get(imgList.size() - 1).setImageResource(R.mipmap.a2);
    }

    private void initPager() {
        //创建Fragment对象，添加到数据源里面
        for(int i = 0 ;i < cityList.size();i++){
            cwFragment = new CityWeatherFragment();
            Bundle bundle = new Bundle();
            bundle.putString("city",cityList.get(i));
            cwFragment.setArguments(bundle);
            fragmentList.add(cwFragment);
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();

        if(v.getId() == R.id.main_iv_add){
            intent.setClass(this, CityManagerActivity.class);
        }else if(v.getId() == R.id.main_iv_more){
            intent.setClass(this, MoreActivity.class);
        }else if(v.getId() == R.id.main_iv_location){
            intent.setClass(this, LocationActivity.class);
        }

        startActivity(intent);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("restart","restart");
        /*获取数据库当前的城市集合*/
        List<String> list = DBManager.queryAllCityName();
        if(list.size() == 0){
            cityList.add("北京");

        }
        cityList.clear();//重写之前，清空当前数据源
        cityList.addAll(list);
        //剩余城市也要创建fragment
        fragmentList.clear();
        initPager();
        adapter.notifyDataSetChanged();
        //页面发生变化，指示器也会发生变化
        imgList.clear();
        pointLayout.removeAllViews();//把布局里的所有元素清除
        initPoint();
        mainVp.setCurrentItem(fragmentList.size() - 1);

    }
}