package org.lowtech.app.exception;

public class DaoException extends Exception {

    public DaoException() {
    }

    public DaoException(String string) {
        super("Dao exception occured: " + string);
    }

    public DaoException(String string, Throwable thrwbl) {
        super("Dao exception occured: " + string, thrwbl);
    }

}
