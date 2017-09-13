package com.beyondsoft.fruit;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;

import com.android_mobile.core.base.BaseActivity;
import com.android_mobile.core.base.BasePresenter;
import com.android_mobile.core.base.BaseView;
import com.android_mobile.core.manager.SharedPrefManager;


/**
 * Created by mxh on 2017/9/11.
 * Describe：Activity基类
 */

public abstract class NActivity<P extends BasePresenter> extends BaseActivity implements BaseView {

    /*@Inject
    public P mPresenter;*/

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

    public void share() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
        intent.putExtra(Intent.EXTRA_TEXT, Constants.SHARE_INFO);
        try {
            startActivity(
                    Intent.createChooser(intent,
                            getResources().getString(R.string.label_chose_share_comp)));
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            toast(R.string.toast_share_fail);
        }
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
