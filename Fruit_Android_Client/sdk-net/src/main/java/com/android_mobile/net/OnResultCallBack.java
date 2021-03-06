package com.android_mobile.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android_mobile.net.response.BaseResponse;

import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by mxh on 2016/11/22.
 * Describe：回调结果封装类
 */

public abstract class OnResultCallBack<T extends Response> extends Subscriber<T> {

    public abstract void onFailed(int code, String message);

    public abstract void onException(String message);

    public abstract void onResponse(T response);

    public abstract void onFinish();

    @Override
    public void onStart() {
        super.onStart();
        /*if (!isNetworkAvailable(mContext)) {
            onFailed(ApiConstants.ERROR_NO_INTERNET,"網絡鏈接不可用");
            onFinish();
            unsubscribe();
        }*/
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        onFailed(0,"請求失敗");
        onFinish();
    }

    @Override
    public void onNext(T response) {
        if (response.isSuccessful() && isOk(response)) {
            onResponse(response);
            onFinish();
        } else {
            if (response.body() instanceof BaseResponse) {
                onFailed(response.code(), ((BaseResponse) response.body()).getMessage());//response.message());
            } else {
                onFailed(response.code(), "請求失敗");//response.message());
            }
        }
    }

    /**
     * 自定义响应数据拦截
     *
     * @param response 响应结果
     * @return true pass false not
     */
    private boolean isOk(T response) {
        if (response.body() instanceof BaseResponse) {
            return "success".equals(((BaseResponse) response.body()).getMessage());
        } else {
            return true;
        }
    }

    /**
     * 检测网络连接是否可用
     *
     * @return true 可用; false 不可用
     */
    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        }
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        if (netInfo == null) {
            return false;
        }
        for (NetworkInfo aNetInfo : netInfo) {
            if (aNetInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

}
