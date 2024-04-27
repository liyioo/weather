package com.example.weather.cityManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weather.CityFragmentPagerAdapter;
import com.example.weather.R;
import com.example.weather.db.DBManager;
import com.example.weather.db.dataBaseBean;

import java.util.ArrayList;
import java.util.List;

public class CityManagerActivity extends AppCompatActivity implements View.OnClickListener {
ImageView addIv,backIv,deleteIv;
ListView cityLv;
List<dataBaseBean> mDatas;
private CityManagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_city_manager);

        addIv = findViewById(R.id.city_iv_add);
        backIv = findViewById(R.id.city_iv_back);
        deleteIv = findViewById(R.id.city_iv_delte);
        cityLv = findViewById(R.id.city_lv);
        mDatas = new ArrayList<>();
        addIv.setOnClickListener(this);
        backIv.setOnClickListener(this);
        deleteIv.setOnClickListener(this);

        //设置适配器
        adapter = new CityManagerAdapter(this,mDatas);
        cityLv.setAdapter(adapter);
    }

    /*  获取数据库当中真实数据源，添加到原有数据源当中，提示适配器更新*/
    @Override
    protected void onResume() {
        super.onResume();
        List<dataBaseBean> list = DBManager.queryAllInfo();
        mDatas.clear();

        mDatas.addAll(list);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.city_iv_add){
            int cityCount = DBManager.getCityCount();
            if(cityCount < 5 ){
                Intent intent = new Intent(this, SearchCityActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(this,"城市数量已达上限，请删除后再添加",Toast.LENGTH_SHORT).show();
            }

        }else if(v.getId() == R.id.city_iv_back){
            finish();
        }else if(v.getId() == R.id.city_iv_delte){
            Intent intent = new Intent(this, DeleteCityActivity.class);
            startActivity(intent);
        }

    }
}