package com.controller;

import com.pojo.Chats;
import com.pojo.Comments;
import com.service.ChatsService;
import com.service.CommentsService;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

/**
 * com.controller
 * Created by ForMe
 * 2019/4/1
 * 16:28
 * 所有关于comment的逻辑都在这里
 */
@Controller
public class CommentsController {
    @Resource(name = "commentsService")
    private CommentsService commentsService;

    @Resource(name = "chatsService")
    private ChatsService chatsService;

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/listAllComments")
    public ModelAndView listAllComments(HttpServletRequest request){
        String chatid = (String) request.getSession().getAttribute("chatid");
        if(chatid == null) {
            String queryString = request.getQueryString();
            chatid = queryString.substring(queryString.indexOf('=') + 1);
            request.getSession().setAttribute("chatid", chatid);
        }
        List<Comments> allComments = commentsService.getAllComments(chatid);
        Chats chats = chatsService.getChatById(chatid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allComments",allComments);
        modelAndView.addObject("content",chats.getContent());
        modelAndView.addObject("time",chats.getReleasetime());
        modelAndView.setViewName("listallComments");
        return modelAndView;
    }

    @RequestMapping("/listAllCommentsByTrums") //按点赞数排序
    public ModelAndView listAllCommentsByTrums(HttpServletRequest request){
//        String queryString = request.getQueryString();
//        String chatid = queryString.substring(queryString.indexOf('=') + 1);
//        request.getSession().setAttribute("chatid",chatid);
        String chatid = (String) request.getSession().getAttribute("chatid");
        List<Comments> allComments = commentsService.getAllComments2(chatid);
        Chats chats = chatsService.getChatById(chatid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allComments",allComments);
        modelAndView.addObject("content",chats.getContent());
        modelAndView.addObject("time",chats.getReleasetime());
        modelAndView.setViewName("listallComments");
        return modelAndView;
    }

    @RequestMapping("/makeComments")  //评论
    public String makeComments(@RequestParam(value = "mycomment") String mycomment, HttpServletRequest request, HttpServletResponse response){
        String chatid = (String) request.getSession().getAttribute("chatid");
        request.getSession().removeAttribute("chatid");
        if(mycomment.length() > 500)
            mycomment = mycomment.substring(0,300) + "</p>";
        Comments comments = new Comments();
        comments.setComment(mycomment);
        comments.setCommentid(UUID.randomUUID().toString().replaceAll("-","_"));
        comments.setCommenttime(new Timestamp(new Date().getTime()));
        String username = (String) request.getSession().getAttribute("username");
        comments.setReleasername(username);
        comments.setChatid(chatid);
        comments.setReleaserid(userService.searchId(username));
        commentsService.makeComment(comments);
        return "redirect:listAllComments?chatid=" + chatid;
    }

    @RequestMapping("/maketrump") //点赞
    public @ResponseBody Map<String,String> maketrump(HttpServletRequest request){
        String commentid = request.getParameter("commentid");
        Comments comments = commentsService.getCommentById(commentid);
        String flag = request.getParameter("flag");
        System.out.println(flag);
        System.out.println(comments);
        System.out.println(comments.getTrumps());
        if(flag.equals("true")){
            comments.setTrumps(comments.getTrumps() + 1);
            System.out.println(comments.getTrumps());
        }else {
            comments.setTrumps(comments.getTrumps() - 1);
            System.out.println(comments.getTrumps());
        }
        commentsService.giveTrump(comments);
        Map<String,String> map = new HashMap<>();
        String num = comments.getTrumps() + "";
        map.put("data",num);
        return map;
    }

    @RequestMapping("/listAllMyComments")
    public ModelAndView getAllMyComments(HttpServletRequest request){
        String releasername = (String) request.getSession().getAttribute("username");
        List<Comments> allMyComments = commentsService.getAllMyComments(releasername);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allMyComments",allMyComments);
        modelAndView.setViewName("allMyComments");
        return modelAndView;
    }

    @RequestMapping("/deleteThisComment")
    public String deleteThisComment(HttpServletRequest request){
        String queryString = request.getQueryString();
        String commentid = queryString.substring(queryString.indexOf('=') + 1);
        commentsService.deleteComment(commentid);
        return "redirect:/listAllMyComments";
    }
}
