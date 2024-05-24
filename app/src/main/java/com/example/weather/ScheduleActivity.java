package com.example.weather;

import android.content.DialogInterface;
import android.os.Bundle;
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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.weather.bean.ScheduleInfo;

import java.util.ArrayList;
import java.util.List;

public class ScheduleActivity extends AppCompatActivity {

    Button addButton;
    DatePicker datePicker;
    private String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_schedule);
        List<ScheduleInfo> list = new ArrayList<>();
        list.add(new ScheduleInfo("eat","school","2024-05-24","09:00","eat shit"));
        ListView listView = findViewById(R.id.schedule_lv);
        ScheduleAdapter adapter = new ScheduleAdapter(list,this);
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
                        Toast.makeText(getApplicationContext(), "选中日期：" + selectedDate, Toast.LENGTH_SHORT).show();
                    }
                });

        addButton = findViewById(R.id.schedule_btn_add);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAddScheduleDialog(date);
            }
        });


    }

    private void showAddScheduleDialog(String date) {
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
                ScheduleInfo info = new ScheduleInfo(title,place,date,time,description);

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
}