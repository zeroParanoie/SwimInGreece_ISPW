package engClasses.beans;

public class UserBean {
    private String username;
    private boolean isOrganiser;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOrganiser(boolean organiser) {
        isOrganiser = organiser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isOrganiser() {
        return isOrganiser;
    }

    public String getPassword() {
        return password;
    }
}
