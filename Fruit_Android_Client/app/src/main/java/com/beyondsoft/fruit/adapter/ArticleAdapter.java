package com.beyondsoft.fruit.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.android_mobile.core.manager.image.ImageLoadFactory;
import com.android_mobile.core.utiles.TimerUtils;
import com.beyondsoft.fruit.R;
import com.beyondsoft.fruit.module.ArticleListBean;

/**
 * Created by mxh on 2017/9/12.
 * Describe：The adapter of article page
 */

public class ArticleAdapter extends MultiAdapter<ArticleListBean> {

    public static final int TYPE_IMG_TEXT = 0;
    public static final int TYPE_NORMAL = 1;

    public ArticleAdapter(Context context) {
        super(context);
        addItemType(TYPE_IMG_TEXT, R.layout.layout_article_item_big_img);
        addItemType(TYPE_NORMAL, R.layout.layout_article_item);
    }

    @Override
    public void onBindItemHolder(SuperViewHolder holder, int position) {
        ArticleListBean item = getDataList().get(position);
        if (position == 0) {
            bindItemImgText(holder, item, position);
        } else {
            bindItemNormal(holder, item, position);
        }
    }

    private void bindItemImgText(SuperViewHolder holder, ArticleListBean item, int position) {
        ImageView mArticleIv = holder.getView(R.id.m_article_iv);
        TextView mIndexTv = holder.getView(R.id.m_index_tv);
        TextView mLabelTv = holder.getView(R.id.m_label_tv);
        TextView mTimeTv = holder.getView(R.id.m_time_tv);
        TextView mViewCountTv = holder.getView(R.id.m_view_count_tv);
        TextView mTitleTv = holder.getView(R.id.m_title_tv);

        ImageLoadFactory.getInstance().getImageLoadHandler()
                .displayImage(item.getVideoImgPath(), mArticleIv);
        mIndexTv.setText(String.valueOf(item.getOrder()));
        mLabelTv.setText(item.getLabel());
        mTimeTv.setText(TimerUtils.simplifyTime(item.getUpdateTime()));
        mViewCountTv.setText(String.valueOf(item.getSocial().getViewCount()));
        mTitleTv.setText(item.getTitle());
    }

    private void bindItemNormal(SuperViewHolder holder, ArticleListBean item, int position) {
        TextView mListIndexTv = holder.getView(R.id.m_list_index_tv);
        ImageView mArticleIv = holder.getView(R.id.m_article_iv);
        TextView mTitleTv = holder.getView(R.id.m_title_tv);
        TextView mLabelTv = holder.getView(R.id.m_label_tv);
        TextView mTimeTv = holder.getView(R.id.m_time_tv);
        TextView mViewCountTv = holder.getView(R.id.m_view_count_tv);

        ImageLoadFactory.getInstance().getImageLoadHandler()
                .displayImage(item.getVideoImgPath(), mArticleIv);
        mListIndexTv.setText(String.valueOf(item.getOrder()));
        mLabelTv.setText(item.getLabel());
        mTimeTv.setText(TimerUtils.simplifyTime(item.getUpdateTime()));
        mViewCountTv.setText(String.valueOf(item.getSocial().getViewCount()));
        mTitleTv.setText(item.getTitle());
    }
}
