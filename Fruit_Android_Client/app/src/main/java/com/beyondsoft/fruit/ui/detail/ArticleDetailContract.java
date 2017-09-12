package com.beyondsoft.fruit.ui.detail;

import android.support.annotation.NonNull;

import com.android_mobile.core.base.BasePresenter;
import com.android_mobile.core.base.BaseView;
import com.beyondsoft.fruit.module.ArticleDetailBean;

/**
 * Created by mxh on 2017/9/12.
 * Describe：
 */

public interface ArticleDetailContract {
    interface View extends BaseView {
        void showDetail(ArticleDetailBean detail);
    }

    abstract class Presenter extends BasePresenter<View> {
        /**
         * Acquire Article Detail
         *
         * @param articleId id
         */
        public abstract void getArticleDetail(@NonNull String articleId);
    }

}
