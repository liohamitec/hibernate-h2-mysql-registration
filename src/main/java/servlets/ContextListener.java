package servlets;

import dbService.DBService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent event) {
        DBService dbService = new DBService();

        ServletContext ctx = event.getServletContext();
        ctx.setAttribute("dbService", dbService);
    }


    public void contextDestroyed(ServletContextEvent arg0) {
    }
}
