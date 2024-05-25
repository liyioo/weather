package com.example.weather;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weather.db.SchDataBase;
import com.example.weather.db.SchManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    Button addButton;
    DatePicker datePicker;
    private String date;
    private List<SchDataBase> list ;
    private ScheduleAdapter adapter;
    private static final int REQUEST_CODE = 1001; // 用于标识权限请求的请求码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_schedule);
        date = getCurrentDate();
        list = SchManager.querySchInfoByDate(date);
        requestNotificationPermission();
        // 创建通知渠道
        createNotificationChannel();
        ListView listView = findViewById(R.id.schedule_lv);
        adapter = new ScheduleAdapter(list,this);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(adapter);
        listView.setOnItemClickListener(adapter);
        datePicker = findViewById(R.id.schedule_dp);
        datePicker.init(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // 在这里处理用户选择的日期
                        String selectedDate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        date = selectedDate;
                        list = SchManager.querySchInfoByDate(date);
                        adapter.setScheduleList(list);
                        adapter.notifyDataSetChanged();
                    }
                });

        addButton = findViewById(R.id.schedule_btn_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAddScheduleDialog();
            }
        });


    }

    // 创建通知渠道
    private void createNotificationChannel() {
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default_channel", "Default Channel", NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private String getCurrentDate() {
        // 获取当前年月日
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // 月份从0开始计数，所以要加1
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return year + "-" + month + "-" + day;
    }

    private void showAddScheduleDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_schedule, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextTitle = dialogView.findViewById(R.id.edit_text_title);
        final EditText editTextDescription = dialogView.findViewById(R.id.edit_text_description);
        final EditText editTextTime = dialogView.findViewById(R.id.edit_text_time);
        final EditText editTextPlace = dialogView.findViewById(R.id.edit_text_place);

        dialogBuilder.setTitle("添加日程");
        dialogBuilder.setPositiveButton("添加", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = editTextTitle.getText().toString().trim();
                String description = editTextDescription.getText().toString().trim();
                String time = editTextTime.getText().toString().trim();
                String place = editTextPlace.getText().toString().trim();
                // 在这里执行添加日程的逻辑，可以将日程信息保存到数据库或其他地方
                SchDataBase info = new SchDataBase(null,title,place,date,time,description);
                SchManager.addSchInfo(info);
                list.add(info);
                list = SchManager.querySchInfoByDate(date);
                adapter.setScheduleList(list);
                adapter.notifyDataSetChanged();

                // 发送通知
                sendNotification(title,info.toString());
            }
        });
        dialogBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }

    private void requestNotificationPermission() {
        // 检查权限是否已授予
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            // 权限未授予，请求权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, REQUEST_CODE);
        } else {
            // 权限已授予，继续创建通知

        }
    }

    // 处理权限请求结果
    @Override
    public void onRequestPermissionsResult(int requestCode, @android.support.annotation.NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

       if (requestCode == REQUEST_CODE) {
            // 检查权限是否已授予
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 权限已授予，继续创建通知
                Toast.makeText(this, "已授予通知权限", Toast.LENGTH_SHORT).show();
            } else {
                // 权限被拒绝，处理用户拒绝权限的情况
                // 您可以告知用户权限对于创建通知的必要性
                // 或提供替代方案
                Toast.makeText(this, "请授予通知权限以继续使用该功能", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void sendNotification(String title, String description) {
        // 获取NotificationManager实例
        NotificationManager notificationManager = getSystemService(NotificationManager.class);

        // 创建通知
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default_channel")
                .setSmallIcon(R.mipmap.inform) // 设置通知小图标
                .setContentTitle(title) // 设置通知标题
                .setContentText(description) // 设置通知内容
                .setPriority(NotificationCompat.PRIORITY_DEFAULT); // 设置通知优先级

        // 发送通知
        notificationManager.notify(0, builder.build());
    }

}