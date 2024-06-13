package misc;

import engclasses.beans.login.LoggedUserBean;

import java.util.logging.Logger;

public class Session {
    private LoggedUserBean loggedUserBean;
    private boolean isOrganiser;
    private String sessionFirstPage;
    private int chosenView;

    private Logger logger;

    public Session() {
        this.loggedUserBean = null;
        this.logger = Logger.getLogger(getClass().getName());
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

    public Logger getLogger() {
        return logger;
    }
}
