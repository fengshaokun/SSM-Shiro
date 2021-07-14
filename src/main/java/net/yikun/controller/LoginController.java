package net.yikun.controller;

import net.yikun.pojo.User;
import net.yikun.service.UserServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserServiceI userServiceI;



    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }




    @RequestMapping("register")
    public String register(User user) {

        String viewName = "fail";

        try {
            userServiceI.register(user);
            viewName = "success";
        } catch (Exception e) {
            e.printStackTrace();
            return viewName;
        }

        return viewName;

    }


    @RequestMapping("login")
    public String login(User user) {

        String viewName = "fail";
        if (user == null) {
            throw new RuntimeException("参数不能为空");
        }

        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            viewName = "success";
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        return viewName;


    }


}
