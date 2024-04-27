package com.example.weather.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager {
    private static SQLiteDatabase database;

    public static void initDB(Context context){
        //初始化数据库信息
        DBHelper dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    public static List<String> queryAllCityName(){
        Cursor cursor = database.query("info",null,null,null,null,null,null);
        List<String> cityList = new ArrayList<>();
        while(cursor.moveToNext()){
            @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex("city"));
            cityList.add(city);
        }
        return cityList;
    }

    public static int updateInfoByCity(String city,String content){
        ContentValues values = new ContentValues();
        values.put("city",city);
        values.put("content",content);
        Log.i("content",""+database.update("info",values,"city=?",new String[]{city}));
        return database.update("info",values,"city=?",new String[]{city});
    }


    public static long addCityInfo(String city,String content){
        ContentValues values = new ContentValues();
        values.put("city",city);
        values.put("content",content);
        return database.insert("info",null,values);
   }

   //根据城市名来查找对应的城市信息
   public static String queryInfoByCity(String city){
        Cursor cursor = database.query("info",null,"city=?",new String[]{city},null,null,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
        return content;
        }
        return null;
   }

   //存储最多5个城市的信息,得到城市数量
    public static int getCityCount(){
        Cursor cursor = database.query("info",null,null,null,null,null,null);
        int count = cursor.getCount();
        return count;
    }

    /* 查询数据库当中的全部信息*/
    public static List<dataBaseBean>queryAllInfo(){
        Cursor cursor = database.query("info", null, null, null, null, null, null);
        List<dataBaseBean>list = new ArrayList<>();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("_id"));
            @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex("city"));
            @SuppressLint("Range") String content = cursor.getString(cursor.getColumnIndex("content"));
            dataBaseBean bean = new dataBaseBean(id, city, content);
            list.add(bean);
        }
        return list;
    }

    public static  int deleteInfoByCity(String city){
        return database.delete("info","city=?",new String[]{city});
    }


/*删除数据库里所有信息*/
    public static void deleteAllInfo(){
        String sql = "delete from info";
        database.execSQL(sql);
    }



}
