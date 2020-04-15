package com.walkwind.boot.myconfig;

import com.walkwind.boot.component.MyTomcatProperties;
import com.walkwind.boot.filter.MyFilter;
import com.walkwind.boot.listener.MyListener;
import com.walkwind.boot.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.expression.Strings;

import java.util.ArrayList;


/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-15-14:28
 **/
@Configuration
public class MyServerConfig {
    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean servletListenerRegistrationBean=new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>(new MyFilter());
        ArrayList<String> strings = new ArrayList<>();
        strings.add("/myServlet");
        strings.add("/hello");
        myFilterFilterRegistrationBean.setUrlPatterns(strings);
        return myFilterFilterRegistrationBean;
    }
    //
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
        return servletRegistrationBean;
    }
//嵌入式的Servlet容器的定制器
    @Bean
    public MyTomcatProperties myTomcatProperties(){
        return new MyTomcatProperties();
    }



}
