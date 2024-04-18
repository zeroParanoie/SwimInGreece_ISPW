package misc;

import engClasses.beans.LoggedUserBean;

public class Session {
    private LoggedUserBean loggedUserBean;
    private boolean isOrganiser;
    private String sessionFirstPage;

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
}
