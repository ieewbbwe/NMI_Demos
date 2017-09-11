package com.beyondsoft.fruit.ui.home;

import com.android_mobile.core.utiles.Lg;
import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.module.TabBean;
import com.beyondsoft.fruit.net.OnProgressRequestCallback;
import com.beyondsoft.fruit.net.ApiFactory;
import com.beyondsoft.fruit.net.response.ArticleListResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by mxh on 2017/9/11.
 * Describe：
 */
public class HomePresenter extends HomeContract.Presenter {

    public HomePresenter() {
    }

    @Override
    public void getArticleList(int start, int offset, String cateId) {
        ApiFactory.getNewsApi().getArticleList(start,offset)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new OnProgressRequestCallback<Response<ArticleListResponse>>(mView) {
                    @Override
                    public void onResponse(Response<ArticleListResponse> response) {
                        Lg.print("picher","列表數據:"+response.body().getContent().size());
                    }
                });
    }

    @Override
    public void getTabList() {
        //TODO TAB預計是通過API獲取，暫時寫死
        List<TabBean> tabs = new ArrayList<>();
        for(String name:Arrays.asList(Constants.HOME_TABS)){
            tabs.add(new TabBean(name,"",Constants.PAGE_TYPE_IMG_TEXT));
        }
        mView.showTabList(tabs);
    }
}
