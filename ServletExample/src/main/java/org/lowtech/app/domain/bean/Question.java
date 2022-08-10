package org.lowtech.app.domain.bean;

public class Question {

        private int id;
        private String theme;

        public Question() {
        }

        public Question(int id, String theme) {
            this.id = id;
            this.theme = theme;
        }

        public Question(String theme) {
            this.theme = theme;
        }

        public int getIdQuestion() {
            return id;
        }

        public void setIdQuestion(int id) {
            this.id = id;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Question)) {
                return false;
            }

            Question question = (Question) o;

            if (id != question.id) {
                return false;
            }
            return theme.equals(question.theme);
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + theme.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Question{"
                    + "theme='" + theme + '\''
                    + '}';
        }
    }
