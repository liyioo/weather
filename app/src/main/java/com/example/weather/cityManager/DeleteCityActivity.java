package com.example.weather.cityManager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weather.R;
import com.example.weather.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class DeleteCityActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView errorIv,rightIv;
    ListView deleteLv;
    List<String> mDatas;   //listview的数据源
    List<String>deleteCitys;
    private DeleteCityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete_city);

        errorIv = findViewById(R.id.delete_iv_error);
        rightIv = findViewById(R.id.delete_iv_right);
        deleteLv = findViewById(R.id.delete_lv);
        mDatas = DBManager.queryAllCityName();
        deleteCitys = new ArrayList<>();
        errorIv.setOnClickListener(this);
        rightIv.setOnClickListener(this);

        /*设置适配器*/
        adapter = new DeleteCityAdapter(this,mDatas,deleteCitys);
        deleteLv.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.delete_iv_error){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示信息").setMessage("您确认要舍弃更改吗").setPositiveButton("舍弃更改", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();//关闭当前页面
                }
            });
            builder.setNegativeButton("取消",null);
            builder.create().show();
        }else if(v.getId() == R.id.delete_iv_right){
                for(int i = 0;i < deleteCitys.size();i ++){
                    String city = deleteCitys.get(i);
                    DBManager.deleteInfoByCity(city);
                }
                finish();
        }
    }
}