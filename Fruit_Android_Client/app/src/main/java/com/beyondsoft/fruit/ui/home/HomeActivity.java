package com.beyondsoft.fruit.ui.home;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;

import com.beyondsoft.fruit.NActivity;
import com.beyondsoft.fruit.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mxh on 2017/9/11.
 * Describe：首页
 */
public class HomeActivity extends NActivity implements HomeContract.View {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initComp() {
        ButterKnife.bind(this);
        setSupportActionBar(mToolTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void showTabList(String[] mTabs) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
