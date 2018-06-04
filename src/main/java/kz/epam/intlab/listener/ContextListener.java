package kz.epam.intlab.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    private static ApplicationContext ctx;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ctx = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("context is running");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    public static ApplicationContext getCtx() {
        return ctx;
    }

    public static void setCtx(ApplicationContext ctx) {
        ContextListener.ctx = ctx;
    }
}
