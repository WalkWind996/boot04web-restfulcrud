package com.walkwind.boot.component;

import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-15-12:01
 **/
public class MyTomcatProperties implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>{

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8084);
    }
}
