package com.beyondsoft.fruit.net.response;

import com.android_mobile.net.response.BaseResponse;
import com.beyondsoft.fruit.module.ArticleListBean;

import java.util.List;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class ArticleListResponse extends BaseResponse {
    private List<ArticleListBean> content;

    public List<ArticleListBean> getContent() {
        return content;
    }

    public void setContent(List<ArticleListBean> content) {
        this.content = content;
    }
}
