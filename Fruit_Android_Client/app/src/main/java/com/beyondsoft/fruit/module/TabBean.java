package com.beyondsoft.fruit.module;

import com.beyondsoft.fruit.module.inter.IMultiEntity;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class TabBean extends BaseBean implements IMultiEntity{
    private String name;
    private String tabId;
    private String type;

    public TabBean() {
    }

    public TabBean(String name, String tabId, String type) {
        this.name = name;
        this.tabId = tabId;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getItemType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTabId() {
        return tabId;
    }

    public void setTabId(String tabId) {
        this.tabId = tabId;
    }
}
