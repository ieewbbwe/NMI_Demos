package com.beyondsoft.fruit.ui.detail;

import android.support.annotation.NonNull;

import com.beyondsoft.fruit.net.ApiFactory;
import com.beyondsoft.fruit.net.OnProgressRequestCallback;
import com.beyondsoft.fruit.net.response.ArticleDetailResponse;

import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mxh on 2017/9/12.
 * Describe：Method of Article
 */

public class ActivityDetailPresenter extends ArticleDetailContract.Presenter {

    @Override
    public void getArticleDetail(@NonNull String articleId) {
        ApiFactory.getArticleApi().getArticleDetail(articleId, "10001", "IPHONE")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OnProgressRequestCallback<Response<ArticleDetailResponse>>(mView) {
                    @Override
                    public void onResponse(Response<ArticleDetailResponse> response) {
                        mView.showDetail(response.body().getContent());
                    }
                });
    }
}
