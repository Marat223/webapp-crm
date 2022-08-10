package org.lowtech.app.dao;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dao {

    private UserDao userDao;
    private AnswerDao answerDao;
    private QuestionDao questionDao;
    private RightDao rightDao;

    private AtomicBoolean isInitialized = new AtomicBoolean(false);

    {
        if (isInitialized.compareAndSet(false, true)) {
            Lock lock = new ReentrantLock();
            lock.lock();
            try {
                userDao = new UserDao();
                answerDao = new AnswerDao();
                questionDao = new QuestionDao();
                rightDao = new RightDao();
            } finally {
                lock.unlock();
            }
        }
    }

    private Dao() {
    }

    private static class InnerHolder {

        private static final Dao dao = new Dao();
    }

    public static Dao getInstance() {
        return InnerHolder.dao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public RightDao getRightDao() {
        return rightDao;
    }

}
