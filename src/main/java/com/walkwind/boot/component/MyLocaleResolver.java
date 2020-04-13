package com.walkwind.boot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @Author walkwind
 * @Description 自定义区域解析器
 * @Date 2020-4-10-12:01
 **/
public class MyLocaleResolver implements LocaleResolver {
    @Override//解析规则
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale=new Locale(split[0],split[1]);
        }
        return locale;
    }
    @Override//设置区域信息
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
