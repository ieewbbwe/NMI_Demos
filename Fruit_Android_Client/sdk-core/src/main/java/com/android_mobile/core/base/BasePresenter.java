package com.android_mobile.core.base;

/**
 * Created by mxh on 2017/7/7.
 * Describe：MVP-P
 */
public abstract class BasePresenter<V> {
    protected V mView;

    public void setView(V v) {
        this.mView = v;
    }

}
