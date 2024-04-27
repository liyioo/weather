package com.example.weather.base;

import static com.example.weather.db.DBManager.initDB;

import android.app.Application;

import com.example.weather.db.DBManager;

import org.xutils.x;

public class UniteApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        DBManager.initDB(this);
    }
}
