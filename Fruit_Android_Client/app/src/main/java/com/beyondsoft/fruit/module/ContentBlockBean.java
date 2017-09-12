package com.beyondsoft.fruit.module;

import java.util.List;

/**
 * Created by mxh on 2017/9/12.
 * Describe：
 */

public class ContentBlockBean extends BaseBean {
    private String content;
    private String subHead;
    private List<PhotoBean> photos;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubHead() {
        return subHead;
    }

    public void setSubHead(String subHead) {
        this.subHead = subHead;
    }

    public List<PhotoBean> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotoBean> photos) {
        this.photos = photos;
    }
}
