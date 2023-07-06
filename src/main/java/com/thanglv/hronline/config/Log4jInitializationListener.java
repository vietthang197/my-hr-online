package com.thanglv.hronline.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.web.Log4jServletContextListener;

@WebListener
public class Log4jInitializationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        String log4jConfigLocation = event.getServletContext().getInitParameter("log4jConfiguration");
        System.setProperty("log4jConfiguration", log4jConfigLocation);
        Log4jServletContextListener initializer = new Log4jServletContextListener();
        initializer.contextInitialized(event);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        Log4jServletContextListener destroyer = new Log4jServletContextListener();
        destroyer.contextDestroyed(event);
    }
}
