package org.lowtech.app.domain.bean;

public class Answer {

    private int id;
    private boolean correct;
    private int fk_question;
    private String text;

    public Answer(int id, boolean correct, int fk_question, String text) {

        this.id = id;
        this.correct = correct;
        this.fk_question = fk_question;
        this.text = text;
    }

    public Answer(boolean correct, int fk_question, String text) {

        this.correct = correct;
        this.fk_question = fk_question;
        this.text = text;
    }

    public Answer() {

    }

    @Override
    public String toString() {
        return "Answer{"
                + "correct=" + correct
                + ", text='" + text + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Answer)) {
            return false;
        }

        Answer answer = (Answer) o;

        if (id != answer.id) {
            return false;
        }
        if (correct != answer.correct) {
            return false;
        }
        if (fk_question != answer.fk_question) {
            return false;
        }
        return text.equals(answer.text);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (correct ? 1 : 0);
        result = 31 * result + fk_question;
        result = 31 * result + text.hashCode();
        return result;
    }

    public int getIdAnswer() {

        return id;
    }

    public void setIdAnswer(int id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getFk_question() {
        return fk_question;
    }

    public void setFk_question(int fk_question) {
        this.fk_question = fk_question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
