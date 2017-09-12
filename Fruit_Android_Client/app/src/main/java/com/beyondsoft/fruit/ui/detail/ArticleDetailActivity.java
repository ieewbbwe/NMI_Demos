package com.beyondsoft.fruit.ui.detail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.android_mobile.core.utiles.TimerUtils;
import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.NActivity;
import com.beyondsoft.fruit.R;
import com.beyondsoft.fruit.module.ArticleDetailBean;
import com.beyondsoft.fruit.module.ArticleListBean;
import com.beyondsoft.fruit.module.inter.IDetailEntity;
import com.beyondsoft.fruit.ui.view.CustomerWebView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mxh on 2017/9/11.
 * Describe：文章详情页
 */
public class ArticleDetailActivity extends NActivity<ActivityDetailPresenter> implements ArticleDetailContract.View {

    @Bind(R.id.m_tool_tb)
    Toolbar mToolBar;
    @Bind(R.id.m_title_tv)
    TextView mTitleTv;
    @Bind(R.id.m_label_tv)
    TextView mLabelTv;
    @Bind(R.id.m_time_tv)
    TextView mTimeTv;
    @Bind(R.id.m_view_count_tv)
    TextView mViewCountTv;
    @Bind(R.id.m_content_wv)
    CustomerWebView mContentWv;

    private ActivityDetailPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
    }

    @Override
    protected void initComp() {
        ButterKnife.bind(this);

        mPresenter = new ActivityDetailPresenter();
        mPresenter.setView(this);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initListener() {
        mToolBar.setOnMenuItemClickListener(item -> {
            toast("Open Share");
            return false;
        });
        mToolBar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initData() {
        ArticleListBean mArticleBean = (ArticleListBean) getIntent().getSerializableExtra(Constants.ARTICLE_LIST);
        if (null != mArticleBean) {
            mPresenter.getArticleDetail(mArticleBean.getMlArticleId());
            mToolBar.setTitle(mArticleBean.getBrandName());
            showTempInfo(mArticleBean);
        }
    }

    @Override
    public void showDetail(ArticleDetailBean detail) {
        //Update Temp Info
        showTempInfo(detail);
        mContentWv.loadUrlForMobile(detail.getContentMsg());
    }

    /**
     * 數據未加載前，可先展示mArticleBean中的數據防止空頁面
     */
    public void showTempInfo(IDetailEntity detailEntity) {
        mTitleTv.setText(detailEntity.getTitle());
        mLabelTv.setText(detailEntity.getLabel());
        mTimeTv.setText(TimerUtils.simplifyTime(detailEntity.getUpdateTime()));
        mViewCountTv.setText(String.valueOf(detailEntity.getViewCount()));
    }

    @Override
    public void onLoading() {
        super.onLoading();
        displayProgressBar();
    }

    @Override
    public void onCompleteLoading() {
        super.onCompleteLoading();
        hideProgressBar();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_share, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
