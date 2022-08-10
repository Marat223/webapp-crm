package org.lowtech.app.initializer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;
import org.lowtech.app.controller.FrontController;

@WebListener
public class WebAppContextInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        FrontController frontController = null;
        try {
            frontController = sce.getServletContext().createServlet(FrontController.class);
        } catch (ServletException ex) {
            Logger.getLogger(WebAppContextInitializer.class.getName()).log(Level.SEVERE, null, ex);
        }

        ServletRegistration.Dynamic dynamicFrontController = sce.getServletContext().addServlet("Front controller", frontController);
        dynamicFrontController.addMapping("/main");

        sce.getServletContext().setAttribute("endPoint", new HashSet<String>(Arrays.asList("/main")));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
