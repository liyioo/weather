package com.example.weather.cityManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weather.MainActivity;
import com.example.weather.R;
import com.example.weather.base.BaseActivity;
import com.example.weather.bean.CityInfoBean;
import com.google.gson.Gson;

public class SearchCityActivity extends BaseActivity implements View.OnClickListener {

    String city;
    EditText searchEt;
    ImageView submitIv;
    GridView searchGv;
    private ArrayAdapter <String> stringArrayAdapter;
    String url1 = "https://api.caiyunapp.com/v2/place?query=";
    String url2 = "&token={Pc7FiRrbxSK03cOp}&lang=zh_CN";
    String[]hotCitys = {"北京","上海","广州","深圳","珠海","佛山","南京","苏州","厦门","长沙","成都","福州",
            "杭州","武汉","青岛","西安","太原","沈阳","重庆","天津","南宁"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_city);
        searchEt = findViewById(R.id.search_et);
        submitIv = findViewById(R.id.search_iv_submit);
        searchGv = findViewById(R.id.search_gv);
        submitIv.setOnClickListener(this);

        /*设置适配器*/
        stringArrayAdapter = new ArrayAdapter<>(this,R.layout.item_hotcity,hotCitys);
        searchGv.setAdapter(stringArrayAdapter);
        setListener();
    }

    /*设置Gradview的监听器*/
    private void setListener() {
        searchGv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                city =hotCitys[position];
                String url = url1 + city + url2;
                loadData(url);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.search_iv_submit){
            city =  searchEt.getText().toString();
            if(!TextUtils.isEmpty(city)){
                String url = url1 + city + url2;
                loadData(url);
            }else{
                Toast.makeText(this, "输入内容不能为空", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onSuccess(String result) {
        CityInfoBean bean = new Gson().fromJson(result,CityInfoBean.class);
        if(bean.getStatus().equals("ok")){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("city",city);
            startActivity(intent);
        }else{
            Toast.makeText(this, "暂时未收录该城市", Toast.LENGTH_SHORT).show();
        }
    }
}