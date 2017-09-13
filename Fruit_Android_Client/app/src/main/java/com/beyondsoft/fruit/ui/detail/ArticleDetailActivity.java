package com.beyondsoft.fruit.ui.detail;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android_mobile.core.manager.image.ImageLoadFactory;
import com.android_mobile.core.utiles.CollectionUtils;
import com.android_mobile.core.utiles.TimerUtils;
import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.NActivity;
import com.beyondsoft.fruit.R;
import com.beyondsoft.fruit.module.ArticleDetailBean;
import com.beyondsoft.fruit.module.ArticleListBean;
import com.beyondsoft.fruit.module.MediaBean;
import com.beyondsoft.fruit.module.inter.IDetailEntity;
import com.beyondsoft.fruit.ui.view.CustomerWebView;
import com.xiao.nicevideoplayer.Clarity;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by mxh on 2017/9/11.
 * Describe：The Article Detail Page
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
    @Bind(R.id.m_video_nvp)
    NiceVideoPlayer mVideoNvp;
    @Bind(R.id.m_news_iv)
    ImageView mNewsIv;

    private ActivityDetailPresenter mPresenter;
    private TxVideoPlayerController mController;

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
        // init VideoPlayer
        mVideoNvp.setPlayerType(NiceVideoPlayer.TYPE_IJK);
        mController = new TxVideoPlayerController(this);
        mController.setLenght(117000);
    }

    @Override
    protected void initListener() {
        mToolBar.setOnMenuItemClickListener(item -> {
            share();
            return false;
        });
        mToolBar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    protected void initData() {
        ArticleListBean mArticleBean = (ArticleListBean) getIntent().getSerializableExtra(Constants.ARTICLE_LIST);
        if (null != mArticleBean) {
            mPresenter.getArticleDetail(mArticleBean.getMlArticleId());
            getSupportActionBar().setTitle(mArticleBean.getBrandName());
            showTempInfo(mArticleBean);
        }
    }

    @Override
    public void showDetail(ArticleDetailBean detail) {
        //Update tempInfo after request API
        showTempInfo(detail);
        mContentWv.loadUrlForMobile(detail.getContentMsg());
    }

    /**
     * Get Video Group
     */
    private void getClarites(List<MediaBean> mediaGroup) {
        Observable.from(mediaGroup)
                //Filter Video
                .filter(mediaBean -> Constants.ARTICLE_TYPE_VIDEOS.equals(mediaBean.getType()))
                //Change MediaBean to Clarity
                .map(mediaBean -> new Clarity(mediaBean.getTitle(), mediaBean.getQuality(), mediaBean.getUrl()))
                .toList()
                .observeOn(AndroidSchedulers.mainThread())
                //Add Clarity To clarities
                .subscribe(clarities -> {
                    if (CollectionUtils.isNotEmpty(clarities)) {
                        mController.setTitle(clarities.get(0).grade);
                        mNewsIv.setVisibility(View.GONE);
                        mVideoNvp.setVisibility(View.VISIBLE);
                        mController.setClarity(clarities, 0);
                        mVideoNvp.setController(mController);
                        ImageLoadFactory.getInstance().getImageLoadHandler()
                                .displayImage(mediaGroup.get(0).getLargePath(), mController.imageView());
                    } else {
                        mVideoNvp.setVisibility(View.GONE);
                        mNewsIv.setVisibility(View.VISIBLE);
                        ImageLoadFactory.getInstance().getImageLoadHandler()
                                .displayImage(mediaGroup.get(0).getLargePath(), mNewsIv);
                    }
                });
    }

    /**
     * Show some article info for avoid empty
     * ,before request article detail api.
     */
    public void showTempInfo(IDetailEntity detailEntity) {
        mTitleTv.setText(detailEntity.getTitle());
        mLabelTv.setText(detailEntity.getLabel());
        mTimeTv.setText(TimerUtils.simplifyTime(detailEntity.getUpdateTime()));
        mViewCountTv.setText(String.valueOf(detailEntity.getViewCount()));
        initVideo(detailEntity.getMediaGroup());
    }

    /**
     * Init VideoView
     * ,if not videos then show image,otherwise show video
     *
     * @param mediaGroup this group include image and video
     *                   ,maybe all of image or video or image&video
     */
    private void initVideo(List<MediaBean> mediaGroup) {
        if (CollectionUtils.isNotEmpty(mediaGroup)) {
            getClarites(mediaGroup);
        }
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
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd())
            return;
        super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
