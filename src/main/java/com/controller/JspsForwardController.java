package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * com.controller
 * Created by ForMe
 * 2019/4/11
 * 9:06
 */
@Controller
public class JspsForwardController {
    @RequestMapping("/makeChats")
    public String makeChats(){
        return "makeChats";
    }
    @RequestMapping("/releasecommentss")
    public String makeComments(){
        return "makeComments";
    }

    @RequestMapping("/updatedefeat") //修改信息失败
    public String updateDefeat(){
        return "homepage";
    }

    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request){
        Enumeration enumeration = request.getSession().getAttributeNames();
        while (enumeration.hasMoreElements()){
            request.getSession().removeAttribute(enumeration.nextElement().toString());
        }
        return "logout";
    }
}
