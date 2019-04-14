package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * com.controller
 * Created by ForMe
 * 2019/3/27
 * 13:53
 */
@Controller
public class AjaxCheck {
    @Resource
    private UserService userService;

    @RequestMapping("/checkusername")
    public void checkUsername(String username, HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        if(username.equals(request.getSession().getAttribute("username")))
            return;
        if(username.equals("") || username == null || username.trim().equals("") ) {
            response.getWriter().println("<font color='red'>用户名不能为空</font>");
            return;
        }
        User user = userService.checkUsername(username);
        if (user != null) {
            response.getWriter().println("<font color='red'>用户已经存在</font>");
            request.getSession().setAttribute("usernameflag","false");
        }
    }

    @RequestMapping("/checkemail")
    public void checkEmail(String email, HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
//        System.out.println(email);
        User user = userService.checkEmail(email);
        if(email == null || email.trim().equals("") || email.equals("")){
            response.getWriter().println("<font color='red'>邮箱不能为空</font>");
            return;
        }
        if (user != null) {
            response.getWriter().println("<font color='red'>邮箱已被注册</font>");
            request.getSession().setAttribute("emailflag","false");
        }
    }
}
