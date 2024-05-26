package com.example.weather;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weather.db.DBManager;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {

    TextView bgTv, cacheTv, versionTv, shareTv, scheduleTv, themeTv;
    RadioGroup exbgRg;
    ImageView backIv;
    private SharedPreferences pref;
    private SharedPreferences pref2;

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

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_more);
        bgTv = findViewById(R.id.more_tv_changebg);
        cacheTv = findViewById(R.id.more_tv_cache);
        versionTv = findViewById(R.id.more_tv_version);
        shareTv = findViewById(R.id.more_tv_share);
        backIv = findViewById(R.id.more_iv_back);
        exbgRg = findViewById(R.id.more_rg);
        scheduleTv = findViewById(R.id.more_tv_schedule);
        themeTv = findViewById(R.id.more_tv_theme);
        bgTv.setOnClickListener(this);
        cacheTv.setOnClickListener(this);
        shareTv.setOnClickListener(this);
        backIv.setOnClickListener(this);
        scheduleTv.setOnClickListener(this);
        themeTv.setOnClickListener(this);
        pref = getSharedPreferences("bg_pref", MODE_PRIVATE);

        String versionName = getVersionName();
        versionTv.setText("当前版本：  v" + versionName);
        setRGListener();
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


    private void setRGListener() {
        exbgRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //获取目前的默认壁纸
                int bg = pref.getInt("bg", 0);
                SharedPreferences.Editor editor = pref.edit();
                Intent intent = new Intent(MoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                if (checkedId == R.id.more_rb_green) {
                    if (bg == 0) {
                        Toast.makeText(MoreActivity.this, "您选择的为当前背景，无需改变！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    editor.putInt("bg", 0);
                    editor.apply();
                } else if (checkedId == R.id.more_rb_pink) {
                    if (bg == 1) {
                        Toast.makeText(MoreActivity.this, "您选择的为当前背景，无需改变！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    editor.putInt("bg", 1);
                    editor.apply();
                } else if (checkedId == R.id.more_rb_blue) {
                    if (bg == 2) {
                        Toast.makeText(MoreActivity.this, "您选择的为当前背景，无需改变！", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    editor.putInt("bg", 2);
                    editor.apply();
                }
                startActivity(intent);
            }
        });
    }

    private String getVersionName() {
        /*获取应用版本号*/
        PackageManager manager = getPackageManager();
        String versionName = "";
        try {
            PackageInfo info = manager.getPackageInfo(getPackageName(), 0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }

        return versionName;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.more_tv_changebg) {
            if (exbgRg.getVisibility() == View.VISIBLE) {
                exbgRg.setVisibility(View.GONE);
            } else {
                exbgRg.setVisibility(View.VISIBLE);
            }
        } else if (v.getId() == R.id.more_tv_cache) {
            clearCache();
        } else if (v.getId() == R.id.more_tv_share) {
            shareSoftareMsg("weather是一款对用户友好，易上手的天气预报软件，画面简约，播报天气情况非常精准，快来下载吧！");
        } else if (v.getId() == R.id.more_iv_back) {
            finish();
        } else if (v.getId() == R.id.more_tv_schedule) {
            startActivity(new Intent(this, ScheduleActivity.class));
        } else if (v.getId() == R.id.more_tv_theme) {
            // 切换夜间模式和日间模式
            toggleNightMode(!pref2.getBoolean("is_night_mode", false));
        }
    }

    private void shareSoftareMsg(String s) {
        /*分享软件的函数*/
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, s);
        startActivity(Intent.createChooser(intent, "说天气"));
    }

    public void clearCache() {
        /*清除缓存的函数*/
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示信息").setMessage("确认要删除所有的缓存吗？");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DBManager.deleteAllInfo();
                Toast.makeText(MoreActivity.this, "已清除所有缓存", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MoreActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }).setNegativeButton("取消", null);
        AlertDialog dialog = builder.create();
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                // 获取到对应的 TextView
                TextView messageTextView = dialog.findViewById(android.R.id.message);
                Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                if (positiveButton != null) {
                    positiveButton.setTextColor(Color.BLACK); // 设置确认按钮文本颜色为黑色
                }

                // 获取取消按钮
                Button negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
                if (negativeButton != null) {
                    negativeButton.setTextColor(Color.BLACK); // 设置取消按钮文本颜色为黑色
                }
            }
        });

        dialog.show();
    }
}
