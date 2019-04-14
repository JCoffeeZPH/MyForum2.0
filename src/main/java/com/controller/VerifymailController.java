package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * com.controller
 * Created by ForMe
 * 2019/3/27
 * 22:11
 */
@Controller
public class VerifymailController {
    @RequestMapping("/verifymail")
    public String verify(HttpServletRequest request, @RequestParam (value = "email",required = true) String email, Model model) throws MessagingException {
//        String email = (String) request.getSession().getAttribute("email");
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
//        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接
//        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息

        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("1787932750@qq.com"));
        // 设置收件人地址
        InternetAddress internetAddress = new InternetAddress(email);
        InternetAddress[] internetAddresses = {internetAddress};
        message.setRecipients(MimeMessage.RecipientType.TO, internetAddresses);
        // 设置邮件标题
        message.setSubject("邮论注册");
        // 设置邮件内容
        String authCode = achieveCode();
//        model.addAttribute("authCode",authCode);
        request.getSession().setAttribute("authCode",authCode);
        request.getSession().setAttribute("authCode",authCode);
//        ServletActionContext.getRequest().getSession().setAttribute("authCode",authCode);
        message.setText("如果不是本人操作请忽略" + "\n" + "注册验证码为:" + authCode+"\n"+"     (有效期为一分钟)");
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("smtp.qq.com","1787932750@qq.com", "eatqdhsenjgmddeg");// 密码为刚才得到的授权码
        // 发送邮件
        try {
            transport.sendMessage(message, message.getAllRecipients());

        }catch(Exception e){
            return "registerdefeat";
        }
        return "verifymailbox";
    }

    // 随机验证码
    public String achieveCode() {  //由于数字 1 、 0 和字母 O 、l 有时分不清楚，所以，没有数字 1 、 0
        String[] beforeShuffle= new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
                "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a",
                "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z" };
        List list = Arrays.asList(beforeShuffle);//将数组转换为集合
        Collections.shuffle(list);  //打乱集合顺序
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)); //将集合转化为字符串
        }
        return sb.toString().substring(3, 8);  //截取字符串第4到8
    }
}
