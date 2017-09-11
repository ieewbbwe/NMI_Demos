package com.beyondsoft.fruit.net.request;

import com.android_mobile.net.request.BaseRequest;

/**
 * Created by picher on 2017/9/11.
 * Describe：首页请求信息实体
 */

public class CategoryRequest extends BaseRequest{
    private String Start;
    private String Type;
    private String Offset;
    private String Platform;

    public String getStart() {
        return Start;
    }

    public void setStart(String start) {
        Start = start;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getOffset() {
        return Offset;
    }

    public void setOffset(String offset) {
        Offset = offset;
    }

    public String getPlatform() {
        return Platform;
    }

    public void setPlatform(String platform) {
        Platform = platform;
    }
}
