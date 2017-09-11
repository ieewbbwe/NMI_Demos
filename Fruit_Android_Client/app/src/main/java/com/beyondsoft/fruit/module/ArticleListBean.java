package com.beyondsoft.fruit.module;

import java.util.List;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class ArticleListBean extends BaseBean{

    private String mlArticleId;
    private String title;
    private String displayTime;
    private String label;
    private SocialBean social;
    private List<MediaBean> mediaGroup;

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

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public String getLabel() {
        return label;
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
