package com.example.weather;



import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public SharedPreferences pref2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pref2 = getSharedPreferences("theme_pref", MODE_PRIVATE);
        // 根据保存的主题模式设置当前的主题
        if (pref2.getBoolean("is_night_mode", true)) {
            setNightMode(true);
        } else {
            setNightMode(false);
        }
    }

    // 切换夜间模式和日间模式
    protected void toggleNightMode(boolean isNightMode) {
        SharedPreferences.Editor editor = pref2.edit();
        editor.putBoolean("is_night_mode", isNightMode);
        editor.apply();
        // 重新创建当前 Activity 以应用新的主题
        recreate();
    }

    // 设置夜间模式和日间模式
    protected void setNightMode(boolean isNightMode) {
        SharedPreferences.Editor editor = pref2.edit();
        editor.putBoolean("is_night_mode", isNightMode);
        editor.apply();
        if (isNightMode) {
            // 设置夜间模式主题
            setTheme(R.style.dark);
        } else {
            // 设置日间模式主题
            setTheme(R.style.comman);
        }
    }



    // 其他通用方法可以在此添加

}
