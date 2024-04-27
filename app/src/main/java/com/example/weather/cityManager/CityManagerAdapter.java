package com.example.weather.cityManager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weather.R;
import com.example.weather.bean.weatherNowBean;
import com.example.weather.db.dataBaseBean;
import com.google.gson.Gson;

import java.util.List;

public class CityManagerAdapter extends BaseAdapter {
    Context context;
    List<dataBaseBean> mDatas;

    public CityManagerAdapter(Context context, List<dataBaseBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_city_manager,null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        dataBaseBean bean = mDatas.get(position);
        holder.cityTv.setText(bean.getCity());

        weatherNowBean weatherBean = new Gson().fromJson(bean.getContent(), weatherNowBean.class);

        weatherNowBean.ResultBean.DailyBean resultBean = weatherBean.getResult().getDaily();
        holder.conTv.setText("天气："+toChinese(resultBean.getSkycon().get(0).getValue()) );
        holder.currentTempTv.setText(resultBean.getTemperature().get(0).getAvg() + "℃");
        holder.windTv.setText("风速:"+(int)Double.parseDouble(resultBean.getWind().get(0).getMin().getSpeed() + "") + "~"+(int) Double.parseDouble(resultBean.getWind().get(0).getMax().getSpeed() + "")  );
        holder.tempRangeTv.setText(resultBean.getTemperature().get(0).getMin() + "~" + resultBean.getTemperature().get(0).getMax() + "℃");

        return convertView;
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
        }else if(weather.equals("MODERATE_HAZE")){
            return "中度雾霾";
        }else if(weather.equals("MODERATE_RAIN")){
            return "中雨";
        }else if(weather.equals("CLEAR_NIGHT")){
            return "晴夜";
        }
        return weather ;
    }

    class ViewHolder{
        TextView cityTv,conTv,currentTempTv,windTv,tempRangeTv;
        public ViewHolder(View itemView){
            cityTv = itemView.findViewById(R.id.item_city_tv_city);
            conTv = itemView.findViewById(R.id.item_city_tv_conditon);
            currentTempTv = itemView.findViewById(R.id.item_city_tv_temp);
            windTv = itemView.findViewById(R.id.item_city_tv_wind);
            tempRangeTv = itemView.findViewById(R.id.item_city_tv_tempRange);

        }
    }

}
