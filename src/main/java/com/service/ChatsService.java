package com.service;

import com.pojo.Chats;

import java.util.List;

/**
 * com.service
 * Created by ForMe
 * 2019/4/1
 * 12:58
 */
public interface ChatsService {
    //发布chat
    void release(Chats chats);

    //根据chat的id删除
    void delete(String chatid);

    //根据用户的名字显示出所有的发布过的chat
    List<Chats> getAllMyChats(String username);

    //根据chatid得到chat
    Chats getChatById(String chatid);

    List<Chats> getAllChats();
}
