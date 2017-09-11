package com.beyondsoft.fruit.ui.home.page;

import android.support.v7.widget.LinearLayoutManager;

import com.android_mobile.core.utiles.Lg;
import com.beyondsoft.fruit.NFragment;
import com.beyondsoft.fruit.R;
import com.beyondsoft.fruit.module.TabBean;
import com.beyondsoft.fruit.net.ApiFactory;
import com.beyondsoft.fruit.net.OnProgressRequestCallback;
import com.beyondsoft.fruit.net.response.ArticleListResponse;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;

import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by picher on 2017/9/11.
 * Describe：image-text article page
 */

public class ArticleFragment extends TabFragment {

    private LRecyclerView mLrv;

    private int start = 0;
    private int offset = 10;

    @Override
    protected int create() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initComp() {
        mLrv = (LRecyclerView) findViewById(R.id.m_list_lrv);
        mLrv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initListener() {
        mLrv.setOnRefreshListener(() -> {

        });
    }

    @Override
    protected void initData() {

        ApiFactory.getNewsApi().getArticleList(start,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OnProgressRequestCallback<Response<ArticleListResponse>>(mView) {
                    @Override
                    public void onResponse(Response<ArticleListResponse> response) {
                        Lg.print("picher","列表數據:"+response.body().getContent().size());
                    }
                });
    }
}
