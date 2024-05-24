package com.example.weather.base;


import android.app.Application;

import com.example.weather.db.DBManager;
import com.example.weather.db.SchManager;

import org.xutils.x;

public class UniteApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        DBManager.initDB(this);
        SchManager.initDB(this);
    }
}
