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
import org.lowtech.app.domain.bean.Right;

public class RightDao extends AbstractDao implements DaoInterface<Right> {

    //convert to Bean parameter
    private boolean convBean(int par) {
        return par == 1;
    }

    //convert to SQL parameter
    private int convSQL(boolean par) {
        if (par) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean create(Right right) throws DaoException {
        int id_user = right.getIdRight();
        int admin = convSQL(right.isAdmin());
        int user = convSQL(right.isUser());
        int guest = convSQL(right.isGuest());
        return (0 < executeCreate("INSERT INTO rights (id_right, admin, user, guest) VALUES (" + id_user + ", " + admin + ", " + user + ", " + guest + ");"));
    }

    @Override
    public boolean update(Right right) throws DaoException {
        int idRight = right.getIdRight();
        int admin = convSQL(right.isAdmin());
        int user = convSQL(right.isUser());
        int guest = convSQL(right.isGuest());
        return (1 == executeCreate("UPDATE rights SET admin=" + admin + ", user=" + user + ", guest=" + guest + " WHERE id_right='" + idRight + "';"));
    }

    @Override
    public boolean delete(Right right) throws DaoException {
        return (0 < executeCreate("DELETE FROM rights WHERE id_right='" + right.getIdRight() + "';"));
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return (0 < executeCreate("DELETE FROM rights WHERE id_right='" + id + "';"));
    }

    @Override
    public Optional<Right> read(Right right) throws DaoException {
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM rights WHERE id_right='" + right.getIdRight() + "';");
            if (rs.next()) {
                right = new Right(right.getIdRight(), convBean(rs.getInt("admin")), convBean(rs.getInt("user")), convBean(rs.getInt("guest")));
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return Optional.of(right);
    }

    @Override
    public Optional<Right> read(int id) throws DaoException {
        Right right = null;
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM rights WHERE id_right='" + id + "';");
            if (rs.next()) {
                right = new Right(id, convBean(rs.getInt("admin")), convBean(rs.getInt("user")), convBean(rs.getInt("guest")));
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return Optional.of(right);
    }

    @Override
    public List<Right> getAll() throws DaoException {
        return getAll("");
    }

    @Override
    public List<Right> getAll(String condition) throws DaoException {
        List<Right> pack = new ArrayList<>();
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM rights" + condition + ";");
            while (rs.next()) {
                pack.add(new Right(rs.getInt("id_right"), convBean(rs.getInt("admin")), convBean(rs.getInt("user")), convBean(rs.getInt("guest"))));
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return pack;
    }
}
