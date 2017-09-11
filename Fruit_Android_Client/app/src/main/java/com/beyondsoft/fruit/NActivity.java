package com.beyondsoft.fruit;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;

import com.android_mobile.core.base.BaseActivity;
import com.android_mobile.core.manager.SharedPrefManager;

/**
 * Created by mxh on 2017/9/11.
 * Describe：Activity基类
 */

public abstract class NActivity extends BaseActivity {

    static {
        //矢量图兼容
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void reload() {
        AppCompatDelegate.setDefaultNightMode(SharedPrefManager.getBoolean(Constants.IS_NIGHT, false) ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
        recreate();
    }
}
