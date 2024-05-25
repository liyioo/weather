package com.example.weather.audio;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.R;
import com.example.weather.RecyclerExtras;
import com.example.weather.bean.AudioInfo;
import com.example.weather.util.FileUtil;
import android.Manifest;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AudioPlayActivity extends AppCompatActivity implements RecyclerExtras.OnItemClickListener, View.OnClickListener {
    private final static String TAG = "AudioPlayActivity";
    private int mCurrentPosition = 0;
    private RecyclerView rv_audio; // 音频列表的循环视图
    private List<AudioInfo> mAudioList = new ArrayList<AudioInfo>(); // 音频列表
    private Uri mAudioUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI; // 音频库的Uri
    private ImageView iv_pause,iv_prev,iv_next,iv_quick,iv_slow;
    private String[] mAudioColumn = new String[]{ // 媒体库的字段名称数组
            MediaStore.Audio.Media._ID, // 编号
            MediaStore.Audio.Media.TITLE, // 标题
            MediaStore.Audio.Media.DURATION, // 播放时长
            MediaStore.Audio.Media.SIZE, // 文件大小
            MediaStore.Audio.Media.DATA}; // 文件路径
    private AudioRecyclerAdapter mAdapter; // 音频列表的适配器
    private MediaPlayer mMediaPlayer = new MediaPlayer(); // 媒体播放器
    private static final int READ_EXTERNAL_STORAGE_PERMISSION_REQUEST_CODE = 103;
    private AlertDialog permissionDialog;
    private static final int AUDIO_PERMISSION_REQUEST_CODE = 102;
    private Timer mTimer = new Timer(); // 计时器
    private int mLastPosition = -1; // 上次播放的音频序号
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_audio_play);
        // 检查并请求音频权限
        checkAndRequestAudioPermission();

        rv_audio = findViewById(R.id.rv_audio);
        iv_pause = findViewById(R.id.iv_pause);
        iv_prev = findViewById(R.id.iv_prev);
        iv_next = findViewById(R.id.iv_next);
        iv_slow = findViewById(R.id.iv_slow);
        iv_quick = findViewById(R.id.iv_quick);
        loadAudioList(); // 加载音频列表
        showAudioList(); // 显示音频列表
        iv_pause.setOnClickListener(this);
        iv_prev.setOnClickListener(this);
        iv_next.setOnClickListener(this);
        iv_slow.setOnClickListener(this);
        iv_quick.setOnClickListener(this);
        // 在播放完成监听器中实现顺序播放逻辑
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // 播放完成后播放下一首音频
                playNextAudio();
            }
        });
    }



    private void playPreviousAudio() {
        // 隐藏当前歌曲的进度条
        if (mLastPosition != -1) {
            AudioInfo currentAudio = mAudioList.get(mLastPosition);
            currentAudio.setProgress(-1); // 将进度设置为-1，表示隐藏
            mAudioList.set(mLastPosition, currentAudio);
            mAdapter.notifyItemChanged(mLastPosition); // 刷新列表项
        }
        

        // 检查是否还有上一首音频可以播放
        if (mCurrentPosition > 0) {
            mCurrentPosition--; // 更新当前播放位置为上一首音频的位置
            mLastPosition --;
            // 获取上一首音频信息
            AudioInfo previousAudio = mAudioList.get(mCurrentPosition);
            try {
                // 重置MediaPlayer，设置数据源，准备播放
                mTimer.cancel(); // 取消计时器
                mMediaPlayer.reset();
                mMediaPlayer.setDataSource(previousAudio.getPath());
                mMediaPlayer.prepare();
                mMediaPlayer.start(); // 开始播放
                // 更新界面显示等操作...
                startTimerForProgressUpdate(mCurrentPosition); // 启动计时器更新进度条
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 如果已经是第一首音频，则停止播放或者根据需求进行其他处理
            mMediaPlayer.stop();
            // 可以在这里设置循环播放逻辑，如重新播放最后一首音频等
        }
    }


    // 检查并请求音频权限
    private void checkAndRequestAudioPermission() {
        // 检查是否已经授予 READ_MEDIA_AUDIO 权限
        int audioPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_AUDIO);

        // 如果未授予该权限，则请求权限
        if (audioPermission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_AUDIO}, AUDIO_PERMISSION_REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @android.support.annotation.NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == AUDIO_PERMISSION_REQUEST_CODE) {
            // 检查用户是否授予了请求的权限
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 用户授予权限，可以开始使用相关功能
                Toast.makeText(this, "已授予音频文件权限", Toast.LENGTH_SHORT).show();
                // 在这里可以执行读取音频文件的操作
            } else {
                // 用户拒绝了权限请求，可能需要提供一些解释或处理
                Toast.makeText(this, "已拒绝授予音频文件权限", Toast.LENGTH_SHORT).show();
            }

        }
    }


    private void playNextAudio() {
        // 隐藏上一首歌曲的进度条
        if (mLastPosition != -1) {
            AudioInfo lastAudio = mAudioList.get(mLastPosition);
            lastAudio.setProgress(-1); // 将进度设置为-1，表示隐藏
            mAudioList.set(mLastPosition, lastAudio);

            mAdapter.notifyItemChanged(mLastPosition); // 刷新列表项
        }

        // 检查是否还有下一首音频可以播放
        if (mCurrentPosition < mAudioList.size() - 1) {
            mCurrentPosition++; // 更新当前播放位置为下一首音频的位置
            mLastPosition ++;
            // 获取下一首音频信息
            AudioInfo nextAudio = mAudioList.get(mCurrentPosition);
            try {
                // 重置MediaPlayer，设置数据源，准备播放
                mTimer.cancel(); // 取消计时器
                mMediaPlayer.reset();
                mMediaPlayer.setDataSource(nextAudio.getPath());
                mMediaPlayer.prepare();
                mMediaPlayer.start(); // 开始播放
                // 更新界面显示等操作...
                startTimerForProgressUpdate(mCurrentPosition); // 启动计时器更新进度条
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 如果已经是最后一首音频，则停止播放或者根据需求进行其他处理
            mMediaPlayer.stop();
            // 可以在这里设置循环播放逻辑，如重新播放第一首音频等
        }
    }


    // 加载音频列表
    private void loadAudioList() {
        mAudioList.clear(); // 清空音频列表
        // 通过内容解析器查询音频库，并返回结果集的游标。记录结果按照修改时间降序返回
        Cursor cursor = getContentResolver().query(mAudioUri, mAudioColumn,
                null, null, "date_modified desc");
        if (cursor != null) {
            Log.d(TAG, "cursor is not null");
            // 下面遍历结果集，并逐个添加到音频列表。简单起见只挑选前十个音频
            for (int i=0; i<30 && cursor.moveToNext(); i++) {
                Log.d(TAG, "cursor i="+i);
                AudioInfo audio = new AudioInfo(); // 创建一个音频信息对象
                audio.setId(cursor.getLong(0)); // 设置音频编号
                audio.setTitle(cursor.getString(1)); // 设置音频标题
                audio.setDuration(cursor.getInt(2)); // 设置音频时长
                audio.setSize(cursor.getLong(3)); // 设置音频大小
                audio.setPath(cursor.getString(4)); // 设置音频路径
                Log.d(TAG, audio.getTitle() + " " + audio.getDuration() + " " + audio.getSize() + " " + audio.getPath());
                if (!FileUtil.checkFileUri(this, audio.getPath())) {
                    i--;
                    Log.i(TAG,"hello");
                    continue;

                }
                mAudioList.add(audio); // 添加至音频列表
            }
            cursor.close(); // 关闭数据库游标
        } else {
            Log.d(TAG, "cursor is null");
        }

    }

    // 显示音频列表
    private void showAudioList() {
        // 创建一个水平方向的线性布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        // 设置间隔大小，这里设置为0表示没有间隔
        rv_audio.setLayoutManager(manager); // 设置循环视图的布局管理器
        mAdapter = new AudioRecyclerAdapter(this, mAudioList,mMediaPlayer); // 创建音频列表的线性适配器
        rv_audio.setAdapter(mAdapter); // 设置循环视图的列表适配器
        mAdapter.setOnItemClickListener(this); // 设置线性列表的点击监听器


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel(); // 取消计时器
        if (mMediaPlayer.isPlaying()) { // 是否正在播放
            mMediaPlayer.stop(); // 结束播放
        }
        mMediaPlayer.release(); // 释放媒体播放器
    }

    @Override
    public void onItemClick(View view, final int position) {
        if (mLastPosition!=-1 && mLastPosition!=position) {
            AudioInfo last_audio = mAudioList.get(mLastPosition);
            last_audio.setProgress(-1); // 当前进度设为-1表示没在播放
            mAudioList.set(mLastPosition, last_audio);
            mAdapter.notifyItemChanged(mLastPosition); // 刷新此处的列表项
        }
        mLastPosition = position;
        mCurrentPosition = position;
//        mAdapter.notifyItemChanged(mLastPosition);


        final AudioInfo audio = mAudioList.get(position);
        Log.d(TAG, "onItemClick position="+position+",audio.getPath()="+audio.getPath());
        mTimer.cancel(); // 取消计时器
        mMediaPlayer.reset(); // 重置媒体播放器
//         mMediaPlayer.setVolume(0.5f, 0.5f); // 设置音量，可选
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); // 设置音频流的类型为音乐
        try {
            mMediaPlayer.setDataSource(audio.getPath()); // 设置媒体数据的文件路径
            mMediaPlayer.prepare(); // 媒体播放器准备就绪
            mMediaPlayer.start(); // 媒体播放器开始播放
            startTimerForProgressUpdate(position); // 启动计时器更新进度条
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 启动计时器更新进度条
    private void startTimerForProgressUpdate(final int position) {
        mTimer = new Timer(); // 创建一个计时器
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                AudioInfo audio = mAudioList.get(position);
                audio.setProgress(mMediaPlayer.getCurrentPosition()); // 设置进度条的当前进度
                mAudioList.set(position, audio);
                // 界面刷新操作需要在主线程执行，故而向处理器发送消息，由处理器在主线程更新界面
                mHandler.sendEmptyMessage(position);
                Log.d(TAG, "CurrentPosition="+mMediaPlayer.getCurrentPosition()+",position="+position);
            }
        }, 0, 500); // 计时器每隔一秒就更新进度条上的播放进度
    }



    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mAdapter.notifyItemChanged(msg.what); // 刷新此处的列表项
        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_pause) {
            if (mMediaPlayer.isPlaying()) {
                mMediaPlayer.pause();
                ((ImageView) v).setImageResource(R.mipmap.pause);
            } else {
                mMediaPlayer.start();
                ((ImageView) v).setImageResource(R.mipmap.running);
            }
        } else if (v.getId() == R.id.iv_prev) {
            playPreviousAudio();
        } else if (v.getId() == R.id.iv_next) {
            playNextAudio();
        } else if (v.getId() == R.id.iv_slow) {
            // 实现快退功能
            int currentPosition = mMediaPlayer.getCurrentPosition();
            int newPosition = currentPosition - 10000; // 快退10秒（10000毫秒）
            if (newPosition < 0) {
                newPosition = 0; // 确保不会小于0
            }
            mMediaPlayer.seekTo(newPosition); // 跳转到新位置
        } else if (v.getId() == R.id.iv_quick) {
            // 实现快进功能
            int currentPosition = mMediaPlayer.getCurrentPosition();
            int duration = mMediaPlayer.getDuration();
            int newPosition = currentPosition + 10000; // 快进10秒（10000毫秒）
            if (newPosition > duration) {
                newPosition = duration; // 确保不会超过总时长
            }
            mMediaPlayer.seekTo(newPosition); // 跳转到新位置
        }
    }


}