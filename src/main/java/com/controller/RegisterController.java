package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

/**
 * com.controller
 * Created by ForMe
 * 2019/3/27
 * 12:43
 * 注册使用的 controller
 */
@Controller
public class RegisterController {
    @Resource
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public ModelAndView register( User user, HttpServletRequest request,String repassword){
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getUsername());
        System.out.println(request.getSession().getAttribute("usernameflag"));
        System.out.println(request.getSession().getAttribute("emailflag"));
        if(user.getUsername().equals("") || user.getUsername().trim().equals("") || user.getUsername() == null || request.getSession().getAttribute("usernameflag") != null
                || user.getPassword().trim().equals("") || user.getPassword().equals("") || user.getPassword() == null || user.getPassword().length() < 6 || user.getPassword().length() > 16 ||
        user.getQqnum().trim().equals("") || user.getQqnum().equals("") || user.getQqnum() == null || user.getQqnum().length() < 5 || user.getQqnum().length() > 11 || user.getEmail().trim().equals("") ||
        user.getEmail().equals("") || !user.getEmail().endsWith("qq.com") || user.getEmail() == null || request.getSession().getAttribute("emailflag") != null || !user.getPassword().equals(repassword)){
            modelAndView.setViewName("registerdefeat");
            return modelAndView;
        }
        modelAndView.addObject("email",user.getEmail());
        request.getSession().setAttribute("username",user.getUsername());
        request.getSession().setAttribute("password",user.getPassword());
        request.getSession().setAttribute("sex",user.getSex());
        request.getSession().setAttribute("qqnum",user.getQqnum());
        request.getSession().setAttribute("selfIntroduction",user.getSelfIntroduction());
        request.getSession().setAttribute("email",user.getEmail());
//        int userid = userService.searchId(user.getUsername());
//        request.getSession().setAttribute("userid",userid);
        modelAndView.setViewName("redirect:verifymail");
        return modelAndView;
    }
}
