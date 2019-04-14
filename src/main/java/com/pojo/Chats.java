package com.pojo;

import java.sql.Timestamp;

/**
 * com.pojo
 * Created by ForMe
 * 2019/4/1
 * 12:40
 * 用于发布chat
 */
public class Chats {
    private String chatid;
    private String username;
    private int userid;
    private String content;
    private Timestamp releasetime;

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getReleasetime() {
        return releasetime;
    }

    public void setReleasetime(Timestamp releasetime) {
        this.releasetime = releasetime;
    }
}
