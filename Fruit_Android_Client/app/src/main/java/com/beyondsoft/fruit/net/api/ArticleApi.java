package com.beyondsoft.fruit.net.api;

import com.beyondsoft.fruit.net.UrlMgr;
import com.beyondsoft.fruit.net.response.ArticleDetailResponse;
import com.beyondsoft.fruit.net.response.ArticleListResponse;

import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by picher on 2017/9/11.
 * Describe：API for Article
 */

public interface ArticleApi {

    /**
     * Get Article List
     * @param start the start index
     * @param offset the count of each page
     */
    @GET(UrlMgr.Url_Article_List)
    Observable<Response<ArticleListResponse>> getArticleList(@Field("Start") int start,@Field("Offset") int offset);

    /**
     * Get Article Detail
     * @param id the Article's id
     * @param menuId the menu's id
     */
    @GET(UrlMgr.Url_Article_Detial)
    Observable<Response<ArticleDetailResponse>> getArticleDetail(@Field("mlArticleId") String id,@Field("sideMenuId")String menuId);
}
