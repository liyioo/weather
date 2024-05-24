package com.example.weather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.weather.audio.AudioPlayActivity;
import com.example.weather.cityManager.CityManagerActivity;
import com.example.weather.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener {
    ImageView addCity_iv,more_iv,location_iv,music_iv;
    LinearLayout pointLayout;
    private static final int AUDIO_PERMISSION_REQUEST_CODE = 100;
    RelativeLayout layout;
    ViewPager mainVp;
    private CityFragmentPagerAdapter adapter;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 101;
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
        music_iv = findViewById(R.id.main_iv_music);
        music_iv.setOnClickListener(this);
        // 检查并请求位置权限
        checkAndRequestLocationPermissions();

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
            Log.i("city888",city==null?"yes":city);
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

    // 检查并请求音频权限
    private void checkAndRequestAudioPermission() {
        // 检查是否已经授予 READ_MEDIA_AUDIO 权限
        int audioPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO);

        // 如果未授予该权限，则请求权限
        if (audioPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_AUDIO}, AUDIO_PERMISSION_REQUEST_CODE);
        }
    }

    // 检查并请求位置权限
    private void checkAndRequestLocationPermissions() {
        // 检查是否已经授予 ACCESS_FINE_LOCATION 和 ACCESS_COARSE_LOCATION 权限
        int fineLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int coarseLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

        // 如果未授予这两个权限中的任意一个，则请求权限
        if (fineLocationPermission != PackageManager.PERMISSION_GRANTED || coarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        }
    }


    // 处理权限请求结果
    @Override
    public void onRequestPermissionsResult(int requestCode, @android.support.annotation.NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == AUDIO_PERMISSION_REQUEST_CODE) {
            // 检查用户是否授予了请求的权限
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授予权限，可以开始使用相关功能
                Toast.makeText(this, "已授予音频文件权限", Toast.LENGTH_SHORT).show();
                // 在这里可以执行读取音频文件的操作
            } else {
                // 用户拒绝了权限请求，可能需要提供一些解释或处理
                Toast.makeText(this, "已拒绝授予音频文件权限", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            // 检查用户是否授予了请求的权限
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                // 用户授予权限，可以开始使用位置功能
                Toast.makeText(this, "已授予定位权限", Toast.LENGTH_SHORT).show();
                // 在这里可以执行获取位置信息的操作
            } else {
                // 用户拒绝了权限请求，可能需要提供一些解释或处理
                Toast.makeText(this, "已拒绝授予定位权限", Toast.LENGTH_SHORT).show();
            }
            // 检查并请求音频权限
            checkAndRequestAudioPermission();
        }
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
            Log.i("city999",cityList.get(i));
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
        }else if (v.getId() == R.id.main_iv_music){
            intent.setClass(this, AudioPlayActivity.class);
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