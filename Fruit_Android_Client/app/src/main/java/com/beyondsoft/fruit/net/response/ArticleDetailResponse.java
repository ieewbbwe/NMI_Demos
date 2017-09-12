package com.beyondsoft.fruit.net.response;

import com.android_mobile.net.response.BaseResponse;
import com.beyondsoft.fruit.module.ArticleDetailBean;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class ArticleDetailResponse extends BaseResponse {

    private ArticleDetailBean content;

    public ArticleDetailBean getContent() {
        return content;
    }

    public void setContent(ArticleDetailBean content) {
        this.content = content;
    }
}
