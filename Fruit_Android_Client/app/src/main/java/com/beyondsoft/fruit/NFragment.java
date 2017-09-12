package com.beyondsoft.fruit;

import android.os.Bundle;

import com.android_mobile.core.base.BaseFragment;
import com.android_mobile.core.base.BaseView;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public abstract class NFragment extends BaseFragment implements BaseView{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onCompleteLoading() {

    }

    @Override
    public void showToast(String msg) {
        toast(msg);
    }
}
