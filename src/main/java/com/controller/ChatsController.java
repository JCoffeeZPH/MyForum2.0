package com.controller;

import com.pojo.Chats;
import com.pojo.Comments;
import com.service.ChatsService;
import com.service.CommentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * com.controller
 * Created by ForMe
 * 2019/4/1
 * 13:29
 * 所有有关chat的逻辑都在这里
 */
@Controller
public class ChatsController {

    @Resource(name = "chatsService")
    private ChatsService chatsService;

    @Resource(name = "commentsService")
    private CommentsService commentsService;

    @RequestMapping("/getAllMyChats") //个人发布的所有话题
    public ModelAndView getAllMyChats(HttpServletRequest request){ //查看所有的chats
        String username = (String) request.getSession().getAttribute("username");
        List<Chats> listAll = chatsService.getAllMyChats(username);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listAllMyChats",listAll);
        modelAndView.setViewName("mychats");
        return modelAndView;
    }

    @RequestMapping("/getAllChats")  //所有人发布的话题
    public ModelAndView getAllChats(){
        List<Chats> allchats = chatsService.getAllChats();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allchats",allchats);
        modelAndView.setViewName("listAllChats");
        return modelAndView;
    }

    @RequestMapping("/releaseChats")//发布话题
    private String releaseChats(@RequestParam(value = "mycomment") String ckeditor, HttpServletRequest request){
        Chats chats = new Chats();
        System.out.println(ckeditor);
        if(ckeditor.length() > 500)
            ckeditor = ckeditor.substring(0,300) + "</p>";
        chats.setUsername((String) request.getSession().getAttribute("username"));
        chats.setUserid((Integer) request.getSession().getAttribute("userid"));
        chats.setChatid(UUID.randomUUID().toString().replaceAll("-","_"));
        chats.setReleasetime(new Timestamp(new Date().getTime()));
        chats.setContent(ckeditor);
        chatsService.release(chats);
        return "redirect:/getAllChats";
    }

    @RequestMapping("/deleteThisChat")  //删除话题及下面的所有评论
    public String deleteThisChat(HttpServletRequest request){
        String queryString = request.getQueryString();
        String chatid = queryString.substring(queryString.indexOf('=') + 1);
        commentsService.deleteAllComments(chatid);
        chatsService.delete(chatid);
        return "redirect:/getAllMyChats";
    }
}
