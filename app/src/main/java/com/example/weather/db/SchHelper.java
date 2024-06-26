package com.example.weather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SchHelper extends SQLiteOpenHelper {

    public SchHelper( Context context) {
        super(context, "SchInfo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建表的操作
        String sql = "create table schInfo(_id integer primary key autoincrement,title varchar(50) not null," +
                "place varchar(50) not null,date varchar(50) not null,time varchar(50) not null,description varchar(50) )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
