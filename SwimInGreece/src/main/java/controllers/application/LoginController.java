package controllers.application;

import engClasses.DAO.OrganiserDAO;
import engClasses.DAO.SwimmerDAO;
import engClasses.beans.login.LoggedUserBean;
import engClasses.beans.login.UserBean;
import engClasses.exceptions.AlreadyInUseException;
import engClasses.exceptions.LoginFromDBException;
import model.Organiser;
import model.Swimmer;

public class LoginController {
    public LoggedUserBean loginMethod(UserBean loggingUser) throws LoginFromDBException {
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

    public LoggedUserBean signInMethod(UserBean loggingUser) throws AlreadyInUseException {
        String username = loggingUser.getUsername();
        String fullname = loggingUser.getFullname();
        String password = loggingUser.getPassword();

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        if(loggingUser.isOrganiser()) {
            Organiser organiser = new Organiser(username, fullname);
            OrganiserDAO.addOrganiser(organiser, password);
        } else {
            Swimmer swimmer = new Swimmer(username, fullname);
            SwimmerDAO.addSwimmer(swimmer, password);
        }

        loggedUserBean.setFullname(fullname);
        return loggedUserBean;
    }
}
