package com.beyondsoft.fruit.ui.home;


import com.android_mobile.core.base.BasePresenter;
import com.android_mobile.core.base.BaseView;
import com.beyondsoft.fruit.module.ArticleListBean;
import com.beyondsoft.fruit.module.TabBean;

import java.util.List;

/**
 * Created by mxh on 2017/9/11.
 * Describe：
 */
public interface HomeContract {
    interface View extends BaseView {
        void showTabList(List<TabBean> mTabs);
    }

   abstract class Presenter extends BasePresenter<View> {
       /**
        * the method for acquire tab list
        * @param start start item index
        * @param offset each page count
        * @param cateId tab id
        */
       public abstract void getArticleList(int start, int offset, String cateId);

       /**
        * for acquire home tab
        */
       public abstract void getTabList();
    }
}
