package com.beyondsoft.fruit.module;

import com.beyondsoft.fruit.module.inter.IDetailEntity;

import java.util.List;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class ArticleDetailBean extends BaseBean implements IDetailEntity {

    // 暫時用到這些字段，其餘字段若用到在添加
    private List<MediaBean> mediaGroup;
    private String title;
    private SocialBean social;
    private ContentBlockBean contentBlocks;
    private String label;
    private long displayTime;
    private long updateDate;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public int getViewCount() {
        return social.getViewCount();
    }

    @Override
    public long getUpdateTime() {
        return updateDate;
    }

    @Override
    public String getVideoImgPath() {
        return mediaGroup == null ? "" : mediaGroup.get(1).getLargePath();
    }

    @Override
    public String getContentMsg() {
        return contentBlocks == null ? "" : contentBlocks.getContent();
    }
}
