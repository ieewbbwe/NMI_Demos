package com.beyondsoft.fruit.module;

/**
 * Created by picher on 2017/9/11.
 * Describe：
 */

public class SocialBean extends BaseBean{
    private int viewCount;
    private int likeCount;
    private int videoViewCount;
    private int commentCount;

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getVideoViewCount() {
        return videoViewCount;
    }

    public void setVideoViewCount(int videoViewCount) {
        this.videoViewCount = videoViewCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
