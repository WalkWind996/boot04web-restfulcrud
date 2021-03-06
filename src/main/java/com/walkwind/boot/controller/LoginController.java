package com.walkwind.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-10-15:57
 **/
@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username)&&"123456".equals(password)){
            //登陆成功将页面重定向到主页,防止表单重复提交
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
