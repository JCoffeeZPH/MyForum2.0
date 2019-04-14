package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * com.controller
 * Created by ForMe
 * 2019/3/28
 * 9:04
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        User user = userService.checkUsername(username);
        ModelAndView modelAndView = new ModelAndView();
        if(user == null || !user.getPassword().equals(password) || username == null || username.trim().equals("") ||  password == null || password.trim().equals(""))
            modelAndView.setViewName("logindefeat");
        else {
            modelAndView.setViewName("homepage");
            String flag = request.getParameter("isLogin");
            if ("y".equals(flag)) {
                //创建两个Cookie对象
                Cookie nameCookie = new Cookie("username", username);
                //设置Cookie的有效期为3天
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie = new Cookie("password",password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password",password);
            int userid = userService.searchId(username);
            request.getSession().setAttribute("userid",userid);
        }
        return modelAndView;
    }
}
