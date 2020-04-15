package com.walkwind.boot.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.walkwind.boot.exception.UserNotExistException;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-14-17:42
 **/
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public String handlerException(Exception e, HttpServletRequest request){
        //BasicErrorController利用request的javax.servlet.error.status_code的值来设置自定义异常的状态码
        //不传入状态码就不会进入解析流程所以就不能自适应生成页面或生成json
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code","user not exist");
        map.put("message",e.getMessage());
        //将自定义的错误信息放到request域中
        request.setAttribute("ext",map);
        //转发到error让basicController处理error请求
        return "forward:/error";
    }
}
