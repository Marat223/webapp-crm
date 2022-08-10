package org.lowtech.app.initializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.lowtech.app.dao.datasource.DataSource;

@WebListener
public class DataSourceInitializer implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("dbConnectionClose", "true");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String realAppPath = sce.getServletContext().getRealPath("");
        sce.getServletContext().setAttribute("realAppPath", realAppPath);
    }

}
