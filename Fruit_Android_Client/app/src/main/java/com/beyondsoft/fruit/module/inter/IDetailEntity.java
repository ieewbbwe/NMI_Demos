package com.beyondsoft.fruit.module.inter;

/**
 * Created by mxh on 2017/9/12.
 * Describe：
 */

public interface IDetailEntity {
    /**
     * 獲取文章標題
     */
    String getTitle();

    /**
     * 獲取標籤
     */
    String getLabel();

    /**
     * 獲取瀏覽量
     */
    int getViewCount();

    /**
     * 獲取上傳時間
     */
    long getUpdateTime();

    /**
     * 獲取視屏地址
     */
    String getVideoImgPath();

    /**
     * 獲取詳情信息
     */
    String getContentMsg();
}