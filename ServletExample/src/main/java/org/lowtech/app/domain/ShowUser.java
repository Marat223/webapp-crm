package org.lowtech.app.domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.lowtech.app.controller.command.AboutUsCommand;
import org.lowtech.app.dao.Dao;
import org.lowtech.app.domain.bean.User;
import org.lowtech.app.exception.DaoException;

public class ShowUser {

    public User ReadUserById() {
        try {
            return Dao.getInstance().getUserDao().read(1).get();
        } catch (DaoException ex) {
            Logger.getLogger(AboutUsCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
