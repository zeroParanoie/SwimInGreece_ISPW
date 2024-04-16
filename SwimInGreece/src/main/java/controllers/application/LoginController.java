package controllers.application;

import engClasses.DAO.OrganiserDAO;
import engClasses.DAO.SwimmerDAO;
import engClasses.beans.LoggedUserBean;
import engClasses.beans.UserBean;
import model.Organiser;
import model.Swimmer;

public class LoginController {
    public LoggedUserBean loginMethod(UserBean loggingUser) {
        LoggedUserBean loggedUser = new LoggedUserBean();

            if(loggingUser.isOrganiser()) {
                Organiser organiser;
                organiser = OrganiserDAO.organiserLogin(loggingUser.getUsername(), loggingUser.getPassword());
                loggedUser.setUsr(organiser.getUsername());
                loggedUser.setFullname(organiser.getFullName());
            } else {
                Swimmer swimmer;
                swimmer = SwimmerDAO.selectSwimmer(loggingUser.getUsername(), loggingUser.getPassword());
                loggedUser.setUsr(swimmer.getUsername());
                loggedUser.setFullname(swimmer.getFullName());
            }
        return loggedUser;

    }
}
