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
import org.lowtech.app.domain.bean.Question;

public class QuestionDao extends AbstractDao implements DaoInterface<Question> {

    @Override
    public boolean create(Question question) throws DaoException {
        String theme = question.getTheme();
        int id = executeCreate("INSERT INTO questions (theme) VALUES ('" + theme + "');");
        if (0 < id) {
            question.setIdQuestion(id);
        }
        return (0 < id);
    }

    @Override
    public boolean update(Question question) throws DaoException {
        return (1 == executeCreate("UPDATE qustions SET theme='" + question.getTheme() + " WHERE id_question='" + question.getIdQuestion() + "';"));
    }

    @Override
    public boolean delete(Question question) throws DaoException {
        return (0 < executeCreate("DELETE FROM questions WHERE id_question='" + question.getIdQuestion() + "';"));
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return (0 < executeCreate("DELETE FROM questions WHERE id_question='" + id + "';"));
    }

    @Override
    public Optional<Question> read(Question question) throws DaoException {
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM questions WHERE id_question='" + question.getIdQuestion() + "';");
            if (rs.next()) {
                question = new Question(rs.getInt("id_question"), rs.getString("theme"));
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return Optional.of(question);
    }

    @Override
    public Optional<Question> read(int id) throws DaoException {
        Question question = null;
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM questions WHERE id_question='" + id + "';");
            if (rs.next()) {
                question = new Question(rs.getInt("id_question"), rs.getString("theme"));
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return Optional.of(question);
    }

    @Override
    public List<Question> getAll() throws DaoException {
        return getAll("");
    }

    @Override
    public List<Question> getAll(String condition) throws DaoException {
        List<Question> questions = new ArrayList<>();
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM questions" + condition + ";");
            while (rs.next()) {
                Question question = new Question(rs.getInt("id_question"), rs.getString("theme"));
                questions.add(question);
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return questions;
    }

}
