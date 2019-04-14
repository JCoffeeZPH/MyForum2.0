package com.service;

import com.dao.ChatsDao;
import com.pojo.Chats;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * com.service
 * Created by ForMe
 * 2019/4/1
 * 12:59
 */
@Service("chatsService")
public class ChatsServiceImpl implements ChatsService{

    @Resource
    private ChatsDao chatsDao;

    @Override
    public void release(Chats chats) {
        chatsDao.release(chats);
    }

    @Override
    public void delete(String chatid) {
        chatsDao.delete(chatid);
    }

    @Override
    public List<Chats> getAllMyChats(String username) {
        return chatsDao.getAllMyChats(username);
    }

    @Override
    public Chats getChatById(String chatid) {
        return chatsDao.getChatById(chatid);
    }

    @Override
    public List<Chats> getAllChats() {
        return chatsDao.getAllChats();
    }
}
