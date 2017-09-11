package com.beyondsoft.fruit.ui.home.page;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.beyondsoft.fruit.Constants;
import com.beyondsoft.fruit.module.TabBean;

/**
 * Created by picher on 2017/9/11.
 * Describe：the fragment factory of home page
 */

public class FragmentFactory {

    /**
     * Generate Different types Fragment by tab_type
     * ,Default is ArticleFragment
     *
     * @param tab tab bean for generate fragment
     */
    public static TabFragment newInstance(TabBean tab){
        TabFragment fragment;
       if (Constants.PAGE_TYPE_IMG_TEXT.equals(tab.getType())){
           fragment = new ArticleFragment();
       }else{
           fragment =  new ArticleFragment();
       }
        fragment.setTabBean(tab);
        return fragment;
    }
}
