package indi.orange1438.managementsystem.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener例子
 *
 * @author orange1438
 *         github: github.com/orange1438
 *         date: 2017/02/19 18:22
 */
public class WebAppContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("listener initialized...");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("listener destroyed....");
    }
}
