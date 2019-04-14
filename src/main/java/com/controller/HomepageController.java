package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * com.controller
 * Created by ForMe
 * 2019/3/27
 * 22:39
 */
@Controller
public class HomepageController {

    @Resource
    private UserService userService;

    @RequestMapping("/homepage")
    public String homepagecontroller(@RequestParam(value = "verificationcode",required = true) String verificationcode, HttpServletRequest request){
        if(verificationcode.equals(request.getSession().getAttribute("authCode"))) {
            User user = new User();
            user.setRegistertime(new Timestamp(new Date().getTime()));
            user.setUsername((String) request.getSession().getAttribute("username"));
            user.setPassword((String) request.getSession().getAttribute("password"));
            user.setSex((String) request.getSession().getAttribute("sex"));
            user.setQqnum((String) request.getSession().getAttribute("qqnum"));
            user.setEmail((String) request.getSession().getAttribute("email"));
            user.setSelfIntroduction((String) request.getSession().getAttribute("selfIntroduction"));
            userService.addUser(user);
            return "homepage";
        }
        return "registerdefeat";
    }

    @RequestMapping(value = "/aboutme",produces="application/json;charset=UTF-8")
    public @ResponseBody Map<String,String> aboutMe(HttpServletRequest request) throws IOException {
        User user = userService.checkUsername((String) request.getSession().getAttribute("username"));
//        PrintWriter writer = response.getWriter();
        Map<String,String> map = new HashMap<>();
//        String data = "username: " + user.getUsername() + "<br> 性别：" + user.getSex() + " <br> QQ号: " + user.getQqnum() +
//                "<br> 邮箱：" + user.getEmail() + "<br> 自我介绍: " + user.getSelfIntroduction();
//        map.put("message",data);
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        map.put("sex",user.getSex());
        map.put("QQ",user.getQqnum());
        map.put("email",user.getEmail());
        map.put("selfIntroduction",user.getSelfIntroduction());
//        System.out.println("uioas");
        return map;
    }

    @RequestMapping("/updatemessage")
    @ResponseBody
    public ModelAndView udateMessage(User user, HttpServletRequest request){ //更新个人信息
        ModelAndView modelAndView = new ModelAndView();
        if(request.getSession().getAttribute("usernameflag") != null || user.getUsername().equals("") || user.getUsername() == null || user.getUsername().trim().equals("") || user.getPassword().equals("") ||
        user.getPassword().trim().equals("") || user.getPassword().length() < 6 || user.getPassword().length() > 16 || user.getQqnum().length() < 5 || user.getQqnum().length() > 11
         || user.getQqnum().trim().equals("") || user.getQqnum().equals("") || user.getQqnum() == null || user.getPassword() == null){
            modelAndView.setViewName("updatedefeat");
            return modelAndView;
        }
        String username = (String) request.getSession().getAttribute("username");
        User user1 = userService.checkUsername(username);
//        System.out.println(username + " " + user.getUsername());
//        System.out.println(user1.getPassword() + " " + user.getPassword());
//        int userid = user1.getUserid();
        if(username.equals(user.getUsername()) && user.getPassword().equals(user1.getPassword())){
            user1.setQqnum(user.getQqnum());
            user1.setSex(user.getSex());
            user1.setSelfIntroduction(user.getSelfIntroduction());
            userService.updatemessage(user1);
            modelAndView.setViewName("homepage");
            return modelAndView;
        }
        user1.setQqnum(user.getQqnum());
        user1.setSex(user.getSex());
        user1.setSelfIntroduction(user.getSelfIntroduction());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        userService.updatemessage(user1);
        Enumeration enumeration = request.getSession().getAttributeNames();
        while(enumeration.hasMoreElements())
            request.getSession().removeAttribute(enumeration.nextElement().toString());
        modelAndView.setViewName("updatesuccess");
        return modelAndView;
    }
}
