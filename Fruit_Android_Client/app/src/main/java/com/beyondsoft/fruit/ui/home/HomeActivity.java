package com.beyondsoft.fruit.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;

import com.android_mobile.core.utiles.Lg;
import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.NActivity;
import com.beyondsoft.fruit.R;
import com.beyondsoft.fruit.module.ArticleListBean;
import com.beyondsoft.fruit.module.TabBean;
import com.beyondsoft.fruit.ui.home.page.ArticleFragment;
import com.beyondsoft.fruit.ui.home.page.FragmentAdapter;
import com.beyondsoft.fruit.ui.home.page.FragmentFactory;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by mxh on 2017/9/11.
 * Describe：首页
 */
public class HomeActivity extends NActivity<HomePresenter> implements HomeContract.View {

    @Bind(R.id.m_tool_tb)
    Toolbar mToolTb;
    @Bind(R.id.m_main_tl)
    TabLayout mMainTl;
    @Bind(R.id.m_tool_ctl)
    CollapsingToolbarLayout mToolCtl;
    @Bind(R.id.m_main_bar_abl)
    AppBarLayout mMainBarAbl;
    @Bind(R.id.m_content_vp)
    ViewPager mContentVp;
    @Bind(R.id.m_nest_scroll_nsv)
    NestedScrollView mNestScrollNsv;
    @Bind(R.id.m_main_content_cl)
    CoordinatorLayout mMainContentCl;
    @Bind(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;
    @Bind(R.id.m_main_drawer_dl)
    DrawerLayout mMainDrawerDl;

    private HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initComp() {
        ButterKnife.bind(this);
        mPresenter = new HomePresenter();
        mPresenter.setView(this);

        setSupportActionBar(mToolTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.getTabList();
    }

    @Override
    public void showTabList(List<TabBean> mTabs) {
        Observable.from(mTabs).map((Func1<TabBean, Fragment>) tab -> {
            //為方便以後修改佈局，根據tab類型創建出不同的Fragment
            return FragmentFactory.newInstance(tab);
        }).toList().map(fragments -> {
            //創建Fragment Adapter
            return FragmentAdapter.newInstance(getSupportFragmentManager()
                    , fragments, Arrays.asList(Constants.HOME_TABS));
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(fragmentAdapter -> {
                    mContentVp.setAdapter(fragmentAdapter);
                    mMainTl.setupWithViewPager(mContentVp);
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
