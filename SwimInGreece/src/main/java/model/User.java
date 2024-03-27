package model;

public abstract class User {
    private String username;
    private String fullName;

    public User(String username, String fullName) {
        this.username = username;
        this.fullName = fullName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }
}
