package misc;

import engClasses.beans.login.LoggedUserBean;

public class Session {
    private LoggedUserBean loggedUserBean;
    private boolean isOrganiser;
    private String sessionFirstPage;
    private int chosenView;

    public Session() {
        this.loggedUserBean = null;
    }

    public void setOrganiser(boolean organiser) {
        isOrganiser = organiser;
    }

    public boolean isOrganiser() {
        return isOrganiser;
    }

    public void setLoggedUserBean(LoggedUserBean loggedUserBean) {
        this.loggedUserBean = loggedUserBean;
    }

    public LoggedUserBean getLoggedUserBean() {
        return loggedUserBean;
    }

    public void setChosenView(int chosenView) {
        this.chosenView = chosenView;
    }

    public int getChosenView() {
        return chosenView;
    }
}
