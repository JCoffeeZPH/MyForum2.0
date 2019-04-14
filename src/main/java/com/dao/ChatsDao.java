package com.dao;

import com.pojo.Chats;

import java.util.List;

/**
 * com.dao
 * Created by ForMe
 * 2019/4/1
 * 12:44
 * 处理chats的接口
 */
public interface ChatsDao {
    //发布chat
    void release(Chats chats);

    //根据chat的id删除
    void delete(String chatid);

    //根据用户的名字显示出所有的发布过的chat
    List<Chats> getAllMyChats(String username);

    //根据chatid得到chat
    Chats getChatById(String chatid);

    //显示所有的chats
    List<Chats> getAllChats();
}
