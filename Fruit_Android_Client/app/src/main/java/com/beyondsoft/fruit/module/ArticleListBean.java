package com.beyondsoft.fruit.module;

import com.beyondsoft.fruit.module.inter.IDetailEntity;

import java.io.Serializable;
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
        return updateDate;
    }

    public void setUpdateDate(long updateDate) {
        this.updateDate = updateDate;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int getViewCount() {
        return social == null ? 0 : social.getViewCount();
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
}
