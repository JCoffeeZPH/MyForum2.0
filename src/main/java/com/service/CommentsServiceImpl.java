package com.service;

import com.dao.CommentsDao;
import com.pojo.Comments;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * com.service
 * Created by ForMe
 * 2019/4/1
 * 16:20
 */
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService{

    @Resource
    private CommentsDao commentsDao;

    @Override
    public List<Comments> getAllComments(String chatid) {
        return commentsDao.getAllComments(chatid);
    }

    @Override
    public List<Comments> getAllComments2(String chatid) {
        return commentsDao.getAllComments2(chatid);
    }

    @Override
    public void deleteComment(String commentid) {
        commentsDao.deleteComment(commentid);
    }

    @Override
    public void makeComment(Comments comments) {
        commentsDao.makeComment(comments);
    }

    @Override
    public int getTrumps(String commentid) {
        return commentsDao.getTrumps(commentid);
    }

    @Override
    public void giveTrump(Comments comments) {
        commentsDao.giveTrump(comments);
    }

    @Override
    public Comments getCommentById(String commentid) {
        return commentsDao.getCommentById(commentid);
    }

    @Override
    public void deleteAllComments(String chatid) {
        commentsDao.deleteAllComments(chatid);
    }

    @Override
    public List<Comments> getAllMyComments(String releasername) {
        return commentsDao.getAllMyComments(releasername);
    }
}
