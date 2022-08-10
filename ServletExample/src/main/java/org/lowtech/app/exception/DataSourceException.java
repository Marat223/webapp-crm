package org.lowtech.app.exception;

public class DataSourceException extends Exception {

    public DataSourceException() {
    }

    public DataSourceException(String string) {
        super("DataSource exception occured: " + string);
    }

    public DataSourceException(String string, Throwable thrwbl) {
        super("DataSource exception occured: " + string, thrwbl);
    }

}
