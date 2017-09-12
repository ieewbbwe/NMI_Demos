package com.beyondsoft.fruit.ui.home.article;

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
       if (Constants.PAGE_TYPE_IMG_TEXT.equals(tab.getItemType())){
           fragment = new ArticleFragment();
       }else{
           fragment =  new ArticleFragment();
       }
        fragment.setTabBean(tab);
        return fragment;
    }
}
