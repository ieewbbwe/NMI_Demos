package com.beyondsoft.fruit.net;

import com.android_mobile.net.BaseFactory;
import com.beyondsoft.fruit.net.api.ArticleApi;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class ApiFactory extends BaseFactory {

    private static ArticleApi mArticleApi;

    public static <T> T createApi(String baseUrl, Class<T> t) {
        return createApi(baseUrl, GsonConverterFactory.create(), t);
    }

    public static ArticleApi getArticleApi() {
        if (mArticleApi == null) {
            mArticleApi = createApi(UrlMgr.Server, GsonConverterFactory.create(), ArticleApi.class);
        }
        return mArticleApi;
    }
}
