package com.walkwind.boot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sound.midi.Soundbank;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-15-15:27
 **/
public class MyListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet Initialized........");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet Destroyed........");
    }
}
