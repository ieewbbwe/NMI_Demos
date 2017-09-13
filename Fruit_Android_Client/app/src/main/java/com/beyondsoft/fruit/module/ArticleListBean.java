package com.beyondsoft.fruit.module;

import com.android_mobile.core.utiles.CollectionUtils;
import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.module.inter.IDetailEntity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class ArticleListBean extends BaseBean implements Serializable, IDetailEntity {

    private String mlArticleId;
    private String title;
    private long displayTime;
    private long updateDate;
    private String label;
    private SocialBean social;
    private List<MediaBean> mediaGroup;
    private int order;
    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ArticleListBean() {
    }

    public ArticleListBean(String mlArticleId) {
        this.mlArticleId = mlArticleId;
    }

    public String getMlArticleId() {
        return mlArticleId;
    }

    public void setMlArticleId(String mlArticleId) {
        this.mlArticleId = mlArticleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(long displayTime) {
        this.displayTime = displayTime;
    }

    public long getUpdateDate() {
        return displayTime;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String getViewCount() {
        DecimalFormat df1 = new DecimalFormat("#,###");

        return social == null ? "0" : df1.format(social.getViewCount());
    }

    @Override
    public long getUpdateTime() {
        return updateDate;
    }

    @Override
    public String getVideoImgPath() {
        return mediaGroup == null ? "" : mediaGroup.get(0).getLargePath();
    }

    @Override
    public String getContentMsg() {
        return null;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public SocialBean getSocial() {
        return social;
    }

    public void setSocial(SocialBean social) {
        this.social = social;
    }

    public List<MediaBean> getMediaGroup() {
        return mediaGroup;
    }

    public void setMediaGroup(List<MediaBean> mediaGroup) {
        this.mediaGroup = mediaGroup;
    }

    public boolean hasVideos() {
        if (CollectionUtils.isNotEmpty(mediaGroup)) {
            for (MediaBean item : mediaGroup) {
                if (Constants.ARTICLE_TYPE_VIDEOS.equals(item.getType())) {
                    return true;
                }
            }
        }
        return false;
    }
}
