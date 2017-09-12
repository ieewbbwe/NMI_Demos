package com.beyondsoft.fruit.ui.home.article;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.R;
import com.beyondsoft.fruit.adapter.ArticleAdapter;
import com.beyondsoft.fruit.module.ArticleListBean;
import com.beyondsoft.fruit.net.ApiFactory;
import com.beyondsoft.fruit.net.OnProgressRequestCallback;
import com.beyondsoft.fruit.net.response.ArticleListResponse;
import com.beyondsoft.fruit.ui.detail.ArticleDetailActivity;
import com.github.jdsjlzx.ItemDecoration.DividerDecoration;
import com.github.jdsjlzx.interfaces.OnItemClickListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

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
    private List<ArticleListBean> mArticleList = new ArrayList<>();
    private ArticleAdapter mInnerAdapter;
    private int mTotal;
    private LRecyclerViewAdapter mAdapter;

    @Override
    protected int create() {
        return R.layout.fragment_article;
    }

    @Override
    protected void initComp() {
        mLrv = (LRecyclerView) findViewById(R.id.m_list_lrv);
        mLrv.setLayoutManager(new LinearLayoutManager(getBActivity()));
        mInnerAdapter = new ArticleAdapter(getBActivity());
        mAdapter = new LRecyclerViewAdapter(mInnerAdapter);
        mInnerAdapter.setDataList(mArticleList);
        mLrv.setAdapter(mAdapter);
        // add list divider between item
        DividerDecoration divider = new DividerDecoration.Builder(getBActivity())
                .setHeight(R.dimen.default_divider_height)
                .setPadding(R.dimen.default_divider_padding)
                .setColorResource(R.color.divide_line)
                .build();
        mLrv.addItemDecoration(divider);
    }

    @Override
    protected void initListener() {
        mLrv.setOnRefreshListener(() -> {
            start = 0;
            mInnerAdapter.getDataList().clear();
            requestData(start, offset);
        });
        mLrv.setOnLoadMoreListener(() -> {
            if (hasMore()) {
                start += offset;
                requestData(start, offset);
            } else {
                mLrv.setNoMore(true);
            }
        });
        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getBActivity(), ArticleDetailActivity.class);
                intent.putExtra(Constants.ARTICLE_LIST, mInnerAdapter.getDataList().get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        //mLrv.refresh();
        /*-----測試數據-----*/
        for (int i = 0; i < 10; i++) {
            mArticleList.add(new ArticleListBean("" + i));
        }
        mInnerAdapter.addAll(mArticleList);
    }

    private void requestData(int start, int offset) {
        ApiFactory.getArticleApi().getArticleList(start, offset, "LANDING", "IPHONE")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OnProgressRequestCallback<Response<ArticleListResponse>>(this) {
                    @Override
                    public void onResponse(Response<ArticleListResponse> response) {
                        mTotal = response.body().getTotal();
                        showArticleList(response.body().getContent());
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        mLrv.refreshComplete(offset);
                        mLrv.setNoMore(hasMore());
                    }
                });
    }

    private boolean hasMore() {
        return mInnerAdapter.getDataList().size() < mTotal;
    }

    public void showArticleList(List<ArticleListBean> listBeen) {
        mInnerAdapter.addAll(listBeen);
    }
}
