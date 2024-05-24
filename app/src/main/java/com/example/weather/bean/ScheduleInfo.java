package com.example.weather.bean;

public class ScheduleInfo {
    private String title;
    private String place;
    private String date;
    private String time;
    private String desc;

    public ScheduleInfo() {
    }

    public ScheduleInfo(String title, String place, String date, String time, String desc) {
        this.title = title;
        this.place = place;
        this.date = date;
        this.time = time;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return  title  +",地点：" + place + ",时间："  + time +   ",备注：" + desc ;
    }
}
