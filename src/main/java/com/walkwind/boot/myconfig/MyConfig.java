package com.walkwind.boot.myconfig;

import com.walkwind.boot.component.MyLocaleResolver;
import com.walkwind.boot.component.MyTomcatProperties;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;



/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-7-17:23
 **/
//@EnableWebMvc //让SpringBoot对SpringMVC的所以自动配置失效，使用自己配置
// SpringBoot2.0版本使用实现WebMvcConfigurer接口或继承WebMvcConfigurationSupport 来扩展SpringMvc的功能
@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
          /*  @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/","/user/login","/index.html","/webjars/**", "/asserts/**");
            }*/
        };
        return webMvcConfigurerAdapter;
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        // 浏览器发送 /walkwind 请求，同样展示success页面，但是不读取数据
        registry.addViewController("/walkwind").setViewName("/success");
    }
    @Bean
    public MyViewResolver myViewResolver(){
        return new MyViewResolver();
    }

}
