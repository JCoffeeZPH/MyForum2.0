package com.service;

import com.pojo.Comments;

import java.util.List;

/**
 * com.service
 * Created by ForMe
 * 2019/4/1
 * 16:19
 */
public interface CommentsService {
    List<Comments> getAllComments(String chatid); //用于查看一个chat的所有评论
    List<Comments> getAllComments2(String chatid); //用于查看一个chat的所有评论并根据点赞数排序
    void deleteComment(String commentid); //删除自己的评论
    void makeComment(Comments comments); //发表评论
    int getTrumps(String commentid); //显示评论的被点赞数
    void giveTrump(Comments comments);//为评论点赞
    Comments getCommentById(String commentid); //根据commentID获取comment
    void deleteAllComments(String chatid); //当删除一个话题时删除此话题下所有评论
    List<Comments> getAllMyComments(String releasername); //查找我所有的评论
}
