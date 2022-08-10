package org.lowtech.app.dao;

import java.util.List;
import java.util.Optional;
import org.lowtech.app.exception.DaoException;

public interface DaoInterface<T> {

    boolean create(T entity) throws DaoException;

    boolean update(T entity) throws DaoException;

    boolean delete(T entity) throws DaoException;

    boolean delete(int id) throws DaoException;

    Optional<T> read(T entity) throws DaoException;

    Optional<T> read(int id) throws DaoException;

    List<T> getAll() throws DaoException;

    List<T> getAll(String condition) throws DaoException;
}
