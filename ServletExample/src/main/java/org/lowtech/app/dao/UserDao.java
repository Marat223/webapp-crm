package org.lowtech.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.lowtech.app.dao.datasource.DataSource;
import org.lowtech.app.exception.DaoException;
import org.lowtech.app.exception.DataSourceException;
import org.lowtech.app.domain.bean.User;

public class UserDao extends AbstractDao implements DaoInterface<User> {

    @Override
    public boolean create(User user) throws DaoException {
        String name = user.getName();
        String login = user.getLogin();
        String password = user.getPassword();
        int id = executeCreate("INSERT INTO users (name, login, password) VALUES ('" + name + "', '" + login + "', '" + password + "');");
        if (0 < id) {
            user.setIdUser(id);
        }
        return (0 < id);
    }

    @Override
    public boolean update(User user) throws DaoException {
        return (1 == executeCreate("UPDATE users SET login='" + user.getName() + "', password='" + user.getLogin() + "' , name='" + user.getPassword() + "' WHERE id_user='" + user.getIdUser() + "';"));
    }

    @Override
    public boolean delete(User user) throws DaoException {
        return (0 < executeCreate("DELETE FROM users WHERE id_user='" + user.getIdUser() + "';"));
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return (0 < executeCreate("DELETE FROM users WHERE id_user='" + id + "';"));
    }

    @Override
    public Optional<User> read(User user) throws DaoException {
        try ( Connection connection = DataSource.getConnection();  Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id_user='" + user.getIdUser() + "';");
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id_user"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }
        } catch (DataSourceException | SQLException e) {
            throw new DaoException();
        }
        return Optional.of(user);
    }

    @Override
    public Optional<User> read(int id) throws DaoException {
        User user = null;
        try ( Connection connection = DataSource.getConnection();  Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id_user='" + id + "';");
            if (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id_user"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }
        } catch (DataSourceException | SQLException e) {
            throw new DaoException("Can't read user by 'id' ", e);
        }
        return Optional.of(user);
    }

    @Override
    public List<User> getAll() throws DaoException {
        return getAll("");
    }

    @Override
    public List<User> getAll(String condition) throws DaoException {
        List<User> userResultSet = new ArrayList<>();
        try ( Connection connection = DataSource.getConnection();  Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users" + condition + ";");
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id_user"),
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
                userResultSet.add(user);
            }
        } catch (DataSourceException | SQLException e) {
            throw new DaoException();
        }
        return userResultSet;
    }

}
