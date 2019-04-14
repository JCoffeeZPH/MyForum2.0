package com.pojo;

import java.sql.Timestamp;

/**
 * com.pojo
 * Created by ForMe
 * 2019/4/1
 * 16:09
 * 评论
 */
public class Comments {
    private String commentid;
    private String releasername;
    private int releaserid;
    private String comment;
    private Timestamp commenttime;
    private String chatid;
    private int trumps;

    public int getTrumps() {
        return trumps;
    }

    public void setTrumps(int trumps) {
        this.trumps = trumps;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getReleasername() {
        return releasername;
    }

    public void setReleasername(String releasername) {
        this.releasername = releasername;
    }

    public int getReleaserid() {
        return releaserid;
    }

    public void setReleaserid(int releaserid) {
        this.releaserid = releaserid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Timestamp commenttime) {
        this.commenttime = commenttime;
    }

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }
}
