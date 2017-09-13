package com.beyondsoft.fruit;

import android.support.v7.app.AppCompatDelegate;

import com.android_mobile.core.BasicApplication;
import com.android_mobile.core.app.UncaughtException;
import com.android_mobile.core.manager.SharedPrefManager;
import com.android_mobile.core.manager.image.ImageLoadFactory;

/**
 * Created by mxh on 2017/09/11.
 * Describe：
 */

public class NApplication extends BasicApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        SharedPrefManager.init(getApplicationContext());
        ImageLoadFactory.init(getApplicationContext());
        Thread.setDefaultUncaughtExceptionHandler(UncaughtException.getInstance(getApplicationContext()));
        AppCompatDelegate.setDefaultNightMode(SharedPrefManager.getBoolean(Constants.IS_NIGHT, false) ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
        //支持Https需要设置证书 不需要则第二个参数传空
        //OkHttpFactory.init(new File(getExternalCacheDir(), "response_cache"), (InputStream[]) null);
    }
}
