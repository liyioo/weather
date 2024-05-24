package com.example.weather.db;

public class dataBaseBean {
    private Integer _id;
    private String city;
    private String content;

    public dataBaseBean() {
    }

    public dataBaseBean(Integer _id, String city, String content) {
        this._id = _id;
        this.city = city;
        this.content = content;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
