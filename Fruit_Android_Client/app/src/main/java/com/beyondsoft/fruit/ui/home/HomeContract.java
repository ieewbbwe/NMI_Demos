package com.beyondsoft.fruit.ui.home;


import com.android_mobile.core.base.BasePresenter;
import com.android_mobile.core.base.BaseView;

/**
 * Created by mxh on 2017/9/11.
 * Describe：
 */
public interface HomeContract {
    interface View extends BaseView {
        void showTabList(String[] mTabs);
    }

    interface Presenter extends BasePresenter {
         void getTabList();
    }
}
