package com.beyondsoft.fruit.ui.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.NActivity;
import com.beyondsoft.fruit.R;
import com.beyondsoft.fruit.module.TabBean;
import com.beyondsoft.fruit.ui.home.article.FragmentAdapter;
import com.beyondsoft.fruit.ui.home.article.FragmentFactory;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
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
    @Bind(R.id.m_content_vp)
    ViewPager mContentVp;
    @Bind(R.id.m_slid_nv)
    NavigationView nvMainNavigation;
    @Bind(R.id.m_main_drawer_dl)
    DrawerLayout mMainDrawerDl;

    private static final int DEFAULT_LOAD_PAGE = 3;
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

        //Bind Menu&Tool
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mMainDrawerDl, mToolTb, 0, 0);
        mDrawerToggle.syncState();
        mMainDrawerDl.addDrawerListener(mDrawerToggle);
        // set default load page
        mContentVp.setOffscreenPageLimit(DEFAULT_LOAD_PAGE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tools, menu);
        return true;
    }

    @Override
    protected void initListener() {
        mToolTb.setOnMenuItemClickListener(item -> {
            toast("Open MapView");
            return false;
        });
        mToolTb.setNavigationOnClickListener(v -> mMainDrawerDl.openDrawer(nvMainNavigation));
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
