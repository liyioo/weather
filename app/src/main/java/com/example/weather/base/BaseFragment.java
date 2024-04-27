package com.example.weather.base;

import android.app.DownloadManager;

import androidx.fragment.app.Fragment;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/*
* Xutils怎么加载网络数据
* 1.声明整体模块
* 2.执行网络请求
* */
public class BaseFragment extends Fragment implements Callback.CommonCallback<String> {
 public void loadData(String url){
     RequestParams params = new RequestParams(url);
     x.http().get(params,this);
 }

//获取数据成功时会调用的接口
    @Override
    public void onSuccess(String result) {

    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {

    }
//取消请求时
    @Override
    public void onCancelled(CancelledException cex) {

    }
//请求完成时
    @Override
    public void onFinished() {

    }

}
