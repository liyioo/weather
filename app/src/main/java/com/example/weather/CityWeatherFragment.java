package com.example.weather;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.weather.base.BaseFragment;
import com.example.weather.bean.CityInfoBean;
import com.example.weather.bean.weatherBean;
import com.example.weather.bean.weatherNowBean;
import com.example.weather.db.DBManager;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class CityWeatherFragment extends BaseFragment implements View.OnClickListener {



    TextView tempTv,cityTv,conditionTv,windTv,tempRangeTv,dateTv,clothIndexTv,washCarTv,coldIndexTv,raysIndexTV,sportIndexTv;
    ImageView dayIv;
    ScrollView layout;
    private SharedPreferences pref;
    private int bgNum;
    LinearLayout futureLayout;
    private boolean cnt = false;
    String city;
    String url1 = "https://api.caiyunapp.com/v2/place?query=";
    String url2 = "&token={Pc7FiRrbxSK03cOp}&lang=zh_CN";

    private weatherBean.DataBean.ForecastBean todayBean;
    private weatherNowBean.ResultBean.DailyBean resultBean;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_city_weather, container, false);
        initView(view);
        changebg();
        Bundle bundle = getArguments();
        city = bundle.getString("city");

        String urlInfo = url1 + city + url2;
        String token = "Pc7FiRrbxSK03cOp";
        //实时天气情况

        loadData(urlInfo);

        return view;
    }
    public void changebg(){
        pref = getActivity().getSharedPreferences("bg_pref",MODE_PRIVATE);
        bgNum = pref.getInt("bg",2);
        if(bgNum == 0){
            layout.setBackgroundResource(R.mipmap.bg);
        }else if(bgNum == 1){
            layout.setBackgroundResource(R.mipmap.bg2);
        }else if(bgNum == 2){
            layout.setBackgroundResource(R.mipmap.bg3);
        }
    }

    @Override
    public void onSuccess(String result) {
        //解析数据并展示
        Log.i("shuaxin" , result);
        cnt = !cnt;
        if(cnt){
            parseShowData1(result);
        }else{
            parseShowData(result);
            int i = DBManager.updateInfoByCity(city,result);
            Log.i("res",i+"");
            //如果找到了对应的城市记录就更新记录
            if(i <= 0 ){//如果没找到就添加到数据库里面
                DBManager.addCityInfo(city,result);
                Log.i("res",result);
            }
        }


    }


    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
       String s = DBManager.queryInfoByCity(city);
       if(!TextUtils.isEmpty(s)){
           parseShowData1(s);
       }
    }

    public void parseShowData1(String result){
        CityInfoBean bean = new Gson().fromJson(result,CityInfoBean.class);

        cityTv.setText(bean.getQuery());

        CityInfoBean.PlacesBean placesBean =  bean.getPlaces().get(0);
//      https://api.caiyunapp.com/v2.5/Pc7FiRrbxSK03cOp/116.378517,39.865246/daily.json
        String url3 = "https://api.caiyunapp.com/v2.5/Pc7FiRrbxSK03cOp/";
        String lng = placesBean.getLocation().getLng() + "";
        String lat = placesBean.getLocation().getLat() + "";
        String url4 = "/daily.json";
        String urlNow = url3 + lng + "," +lat +url4;

        loadData(urlNow);
    }

    public void parseShowData(String result){


        weatherNowBean nowBean = new Gson().fromJson(result,weatherNowBean.class);
        resultBean = nowBean.getResult().getDaily();

        windTv.setText("风速:"+(int)Double.parseDouble(resultBean.getWind().get(0).getMin().getSpeed() + "") + "~"+(int) Double.parseDouble(resultBean.getWind().get(0).getMax().getSpeed() + "")  );
        conditionTv.setText(toChinese(resultBean.getSkycon().get(0).getValue()));
        tempTv.setText(resultBean.getTemperature().get(0).getAvg() + "℃");
        dateTv.setText(resultBean.getAstro().get(0).getDate().substring(0,10));
        tempRangeTv.setText(resultBean.getTemperature().get(0).getMin() + "~" + resultBean.getTemperature().get(0).getMax() + "℃" );
        //设置显示天气情况的图片
        HashMap<String,Integer> map = new HashMap<>();
        map.put("PARTLY_CLOUDY_DAY",R.mipmap.icon);
        map.put()
        dateTv.setBackgroundResource(map.get(resultBean.getSkycon().get(0).getValue()));
//        Picasso.get().load("www.acwing.com").into(dayIv);

        for(int i = 1;i <= 4;i++){

            View itemView = LayoutInflater.from(getActivity()).inflate(R.layout.item_main_center,null);
            itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT) );
            futureLayout.addView(itemView);
            TextView idateTv = itemView.findViewById(R.id.item_center_tv_date);
            TextView iconTv = itemView.findViewById(R.id.item_center_tv_con);
            TextView itempTv = itemView.findViewById(R.id.item_center_tv_temp);
            ImageView iTv = itemView.findViewById(R.id.item_center_iv_temp);


//            Picasso.get().load("").into(iTv);

            idateTv.setText(resultBean.getAstro().get(i).getDate().substring(0,10));

            iconTv.setText(toChinese(resultBean.getSkycon().get(i).getValue()));
            itempTv.setText(resultBean.getTemperature().get(i).getAvg() + "℃");
        }


    }



public static String toChinese(String weather){
        if(weather.equals("PARTLY_CLOUDY_DAY")){
            return "少云天";
        }
        else if(weather.equals("PARTLY_CLOUDY_NIGHT")){
            return "少云夜";
        } else if (weather.equals("CLEAR_DAY")) {
            return "晴";
        }else if(weather.equals("CLOUDY")){
            return "多云";
        }else if(weather.equals("LIGHT_RAIN")){
            return "小雨";
        }else if(weather.equals("RAIN")){
            return  "雨";
        }else if(weather.equals("MODERATE_RAIN")){
            return "中雨";
        }else if(weather.equals("MODERATE_HAZE")){
            return "中度雾霾";
        }else if(weather.equals("CLEAR_NIGHT")){
            return "晴夜";
        }
    return weather ;
}

    private void initView(View view) {
        tempTv = view.findViewById(R.id.frag_tv_currnettemp);
        cityTv = view.findViewById(R.id.frag_tv_city);
        conditionTv = view.findViewById(R.id.frag_tv_codition);
        windTv = view.findViewById(R.id.frag_tv_wind);
        tempRangeTv = view.findViewById(R.id.frag_tv_temrange);
        dateTv = view.findViewById(R.id.frag_tv_date);
        clothIndexTv = view.findViewById(R.id.frag_index_tv_dress);
        washCarTv = view.findViewById(R.id.frag_index_tv_washcar);
        coldIndexTv = view.findViewById(R.id.frag_index_tv_cold);
        sportIndexTv = view.findViewById(R.id.frag_index_tv_sport);
        raysIndexTV = view.findViewById(R.id.frag_index_tv_rays);
        layout = view.findViewById(R.id.sc_layout);

        dayIv = view.findViewById(R.id.frag_iv_today);

        futureLayout = view.findViewById(R.id.frag_center_layout);
        clothIndexTv.setOnClickListener(this);
        coldIndexTv.setOnClickListener(this);
        sportIndexTv.setOnClickListener(this);
        raysIndexTV.setOnClickListener(this);
        washCarTv.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        weatherNowBean.ResultBean.DailyBean.LifeIndexBean lifeIndexBean = resultBean.getLife_index();

        if(v.getId() == R.id.frag_index_tv_dress){
        builder.setTitle("穿衣指数");

        String msg = "穿衣" + lifeIndexBean.getDressing().get(0).getDesc();
        builder.setMessage(msg);
        builder.setPositiveButton("确认",null);

        }else if(v.getId() == R.id.frag_index_tv_washcar){
            builder.setTitle("洗车指数");

            String msg = "洗车" + lifeIndexBean.getCarWashing().get(0).getDesc();
            builder.setMessage(msg);
            builder.setPositiveButton("确认",null);
        }
        else if(v.getId() == R.id.frag_index_tv_cold){
            builder.setTitle("感冒指数");

            String msg = "感冒" + lifeIndexBean.getColdRisk().get(0).getDesc();
            builder.setMessage(msg);
            builder.setPositiveButton("确认",null);
        }else if(v.getId() == R.id.frag_index_tv_sport){
            builder.setTitle("运动指数");

            String msg = "运动"+ lifeIndexBean.getComfort().get(0).getDesc();
            builder.setMessage(msg);
            builder.setPositiveButton("确认",null);
        }
        else if(v.getId() == R.id.frag_index_tv_rays){
            builder.setTitle("紫外线指数");

            String msg = "紫外线" + lifeIndexBean.getUltraviolet().get(0).getDesc();
            builder.setMessage(msg);
            builder.setPositiveButton("确认",null);
        }
        builder.create().show();
    }




}