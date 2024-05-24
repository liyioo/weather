package com.example.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.weather.bean.ScheduleInfo;

import java.util.List;

public class ScheduleAdapter extends BaseAdapter implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    private List<ScheduleInfo> mScheduleList ;
    private Context mContext;

    public ScheduleAdapter(List<ScheduleInfo> mScheduleList, Context mContext) {
        this.mScheduleList = mScheduleList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mScheduleList.size();
    }

    @Override
    public Object getItem(int position) {
        return mScheduleList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_schedule,null);
            holder.tv_schedule = convertView.findViewById(R.id.item_schedule_tv);
            convertView.setTag(holder); // 将ViewHolder对象保存到convertView的Tag中
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        ScheduleInfo info = mScheduleList.get(position);
        holder.tv_schedule.setText(info.toString());

        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    public final class ViewHolder{
        public TextView tv_schedule;


    }
}
