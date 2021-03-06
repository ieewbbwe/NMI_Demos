package com.beyondsoft.fruit.net;

import com.android_mobile.core.base.BaseView;
import com.android_mobile.net.OnSimpleRequestCallback;

import retrofit2.Response;

/**
 * Created by mxh on 17/09/11
 * Describe： 需要展示进度框的网络访问
 */

public abstract class OnProgressRequestCallback<T extends Response> extends OnSimpleRequestCallback<T> {

    private final BaseView mView;

    public OnProgressRequestCallback(BaseView v) {
        this.mView = v;
    }

    @Override
    public void onFailed(int code, String message) {
        super.onFailed(code, message);
        mView.showToast(message);
        //TODO 请求失败则从磁盘缓存中拿出数据
    }

    @Override
    public void onStart() {
        super.onStart();
        mView.onLoading();
    }

    @Override
    public void onFinish() {
        mView.onCompleteLoading();
    }
}
