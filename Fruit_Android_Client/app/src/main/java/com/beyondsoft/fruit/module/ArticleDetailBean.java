package com.beyondsoft.fruit.module;

import com.android_mobile.core.utiles.CollectionUtils;
import com.beyondsoft.fruit.module.inter.IDetailEntity;

import java.text.DecimalFormat;
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
    private List<ContentBlockBean> contentBlocks;
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
    public String getViewCount() {
        DecimalFormat df1 = new DecimalFormat("#,###");

        return social == null ? "0" : df1.format(social.getViewCount());
    }

    @Override
    public long getUpdateTime() {
        return displayTime;
    }

    @Override
    public String getVideoImgPath() {
        return mediaGroup == null ? "" : mediaGroup.get(1).getLargePath();
    }

    @Override
    public String getContentMsg() {
        StringBuilder sb = new StringBuilder();
        if (CollectionUtils.isNotEmpty(contentBlocks)) {
            for (ContentBlockBean content : contentBlocks) {
                if (CollectionUtils.isNotEmpty(content.getPhotos())) {
                    sb.append(image(content.getPhotos().get(0).getImagePath()));
                }
                sb.append(content.getContent());
            }
            return sb.toString();
        }
        return "";
    }

    /**
     * 添加內容中的圖片標記，
     * 因為示例用，暫時添加一張
     */
    private String image(String imagePath) {
        return "<img src='" + imagePath + "'/> </br>";
    }

    public List<MediaBean> getMediaGroup() {
        return mediaGroup;
    }

    public void setMediaGroup(List<MediaBean> mediaGroup) {
        this.mediaGroup = mediaGroup;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SocialBean getSocial() {
        return social;
    }

    public void setSocial(SocialBean social) {
        this.social = social;
    }

    public List<ContentBlockBean> getContentBlocks() {
        return contentBlocks;
    }

    public void setContentBlocks(List<ContentBlockBean> contentBlocks) {
        this.contentBlocks = contentBlocks;
    }

    public void setLabel(String label) {
        this.label = label;
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
}
