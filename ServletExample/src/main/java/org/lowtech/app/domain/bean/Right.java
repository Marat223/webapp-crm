package org.lowtech.app.domain.bean;

public class Right {

    private int id;
    private boolean admin;
    private boolean user;
    private boolean guest;

    public Right(int id, boolean admin, boolean user, boolean guest) {
        this.id = id;
        this.admin = admin;
        this.user = user;
        this.guest = guest;
    }

    public Right() {

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.id;
        hash = 73 * hash + (this.admin ? 1 : 0);
        hash = 73 * hash + (this.user ? 1 : 0);
        hash = 73 * hash + (this.guest ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Right other = (Right) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.admin != other.admin) {
            return false;
        }
        if (this.user != other.user) {
            return false;
        }
        if (this.guest != other.guest) {
            return false;
        }
        return true;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Right{" + "id=" + id + ", admin=" + admin + ", user=" + user + ", guest=" + guest + '}';
    }

    public int getIdRight() {

        return id;
    }

    public void setIdRight(int id) {
        this.id = id;
    }
}
