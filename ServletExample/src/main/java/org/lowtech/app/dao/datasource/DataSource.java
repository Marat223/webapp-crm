package org.lowtech.app.dao.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;
import org.lowtech.app.exception.DataSourceException;

@WebListener
public class DataSource implements ServletContextAttributeListener {

    private static HikariDataSource hikariDataSource;

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        if (event.getName().equals("realAppPath")) {
            HikariConfig config = new HikariConfig((String) event.getValue() + "WEB-INF/classes/datasource.properties");
            config.setDriverClassName("org.h2.Driver"); //TODO Move to properties
            config.setUsername("sa"); //TODO Move to properties
            config.setPassword("sa"); //TODO Move to properties
            config.setSchema("SCHEMA_NAME"); //TODO Move to properties
            hikariDataSource = new HikariDataSource(config);
        } else if (event.getName().equals("dbConnectionClose") & event.getValue().equals("true")) {
            hikariDataSource.close();
        }
    }

    public static Connection getConnection() throws DataSourceException {
        try {
            return hikariDataSource.getConnection();
        } catch (SQLException ex) {
            throw new DataSourceException("Attemt get connection failed: ", ex);
        }
    }

}
