package com.beyondsoft.fruit.ui.home.page;

import com.beyondsoft.fruit.NFragment;
import com.beyondsoft.fruit.module.TabBean;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public abstract class TabFragment extends NFragment {

    protected TabBean mTab;

    public void setTabBean(TabBean tabBean){
        this.mTab = tabBean;
    }
}
