package com.walkwind.boot.controller;

import com.walkwind.boot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-3-15:14
 **/
@Controller
public class HelloController {
/*    @RequestMapping({"/","/index.html"})
    public String index(){
        return "login";
    }*/

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String username){
        if ("aaa".equals(username)) {
            throw new UserNotExistException();
        }
        return "hello";
    }

    @RequestMapping("/success")
    public String success(HashMap<String,Object> map1){
        map1.put("success","成功");
        map1.put("hello","<h1>你好</h1>");
        map1.put("lists",Arrays.asList("张三","李四","王五"));
        return "success";
    }
}
