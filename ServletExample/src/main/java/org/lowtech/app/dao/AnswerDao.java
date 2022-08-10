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
import org.lowtech.app.domain.bean.Answer;

public class AnswerDao extends AbstractDao implements DaoInterface<Answer> {

    @Override
    public boolean create(Answer answer) throws DaoException {
        boolean correct = answer.isCorrect();
        int fk_question = answer.getFk_question();
        String text = answer.getText();
        int id = executeCreate("INSERT INTO answers (correct, fk_question, text) VALUES ('" + correct + "', '" + fk_question + "', '" + text + "');");
        if (0 < id) {
            answer.setIdAnswer(id);
        }
        return (0 < id);
    }

    @Override
    public boolean update(Answer answer) throws DaoException {
        return (1 == executeCreate("UPDATE answers SET correct='" + answer.isCorrect() + "', fk_question='" + answer.getFk_question() + "' WHERE id_answer='" + answer.getIdAnswer() + "';"));
    }

    @Override
    public boolean delete(Answer answer) throws DaoException {
        return (0 < executeCreate("DELETE FROM answers WHERE id_answer='" + answer.getIdAnswer() + "';"));
    }

    @Override
    public boolean delete(int id) throws DaoException {
        return (0 < executeCreate("DELETE FROM answers WHERE id_answer='" + id + "';"));
    }

    @Override
    public Optional<Answer> read(Answer answer) throws DaoException {
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM answers WHERE idAnswer='" + answer.getIdAnswer() + "';");
            if (rs.next()) {
                answer = new Answer(
                        rs.getBoolean("correct"),
                        rs.getInt("fk_question"),
                        rs.getString("text"));
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return Optional.of(answer);
    }

    @Override
    public Optional<Answer> read(int id) throws DaoException {
        Answer answer = null;
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM answers WHERE id_answer='" + id + "';");
            if (rs.next()) {
                answer = new Answer(
                        rs.getBoolean("correct"),
                        rs.getInt("fk_question"),
                        rs.getString("text"));
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return Optional.of(answer);
    }

    @Override
    public List<Answer> getAll() throws DaoException {
        return getAll("");
    }

    @Override
    public List<Answer> getAll(String condition) throws DaoException {
        List<Answer> answers = new ArrayList<>();
        try ( Connection con = DataSource.getConnection();  Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM answers" + condition + ";");
            while (rs.next()) {
                Answer answer = new Answer(
                        rs.getInt("id_answer"),
                        rs.getBoolean("correct"),
                        rs.getInt("fk_question"),
                        rs.getString("text"));
                answers.add(answer);
            }
        } catch (DataSourceException | SQLException ex) {
            throw new DaoException();
        }
        return answers;
    }
}
