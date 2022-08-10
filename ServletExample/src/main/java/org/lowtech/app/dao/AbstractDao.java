package org.lowtech.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.lowtech.app.dao.datasource.DataSource;
import org.lowtech.app.exception.DaoException;
import org.lowtech.app.exception.DataSourceException;

public class AbstractDao {

    protected int executeCreate(String sql) throws DaoException {
        int result = -1;
        try ( Connection connection = DataSource.getConnection();  Statement statement = connection.createStatement()) {
            if ((statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) == 1) {
                ResultSet resultSet = statement.getGeneratedKeys();
                resultSet.next();
                result = resultSet.getInt(1);
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException("Creating of record has been threw an exception: ", ex);
        }
        return result;
    }

    protected boolean executeUpdate(String sql) throws DaoException {
        try ( Connection connection = DataSource.getConnection();  Statement statement = connection.createStatement()) {
            return 1 == statement.executeUpdate(sql);
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException("Updating of record has been threw an exception: ", ex);
        }
    }
}
