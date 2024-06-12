package controllers.application;

import engClasses.beans.login.LoggedUserBean;
import engClasses.beans.login.UserBean;
import engClasses.exceptions.AlreadyInUseException;
import engClasses.exceptions.LoginFromDBException;
import model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {

    @Test
    void loginMethodWrongPassword() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("Sw1");
        userBean.setPassword("2");
        userBean.setOrganiser(false);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.loginMethod(userBean);
        } catch (LoginFromDBException e) {
            flag = 1;
        }

        assertEquals(1, flag);
    }

    @Test
    void loginMethodWrongPasswordOrg() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("Org1");
        userBean.setPassword("2");
        userBean.setOrganiser(true);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.loginMethod(userBean);
        } catch (LoginFromDBException e) {
            flag = 1;
        }

        assertEquals(1, flag);
    }

    @Test
    void loginMethodWrongRole() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("Sw1");
        userBean.setPassword("1");
        userBean.setOrganiser(true);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.loginMethod(userBean);
        } catch (LoginFromDBException e) {
            flag = 1;
        }

        assertEquals(1, flag);
    }

    @Test
    void loginMethodWrongRoleOrg() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("Org1");
        userBean.setPassword("1");
        userBean.setOrganiser(false);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.loginMethod(userBean);
        } catch (LoginFromDBException e) {
            flag = 1;
        }

        assertEquals(1, flag);
    }

    @Test
    void loginMethodCorrect() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("Sw1");
        userBean.setPassword("1");
        userBean.setOrganiser(false);

        UserBean _userBean = new UserBean();
        _userBean.setUsername("Org1");
        _userBean.setPassword("1");
        _userBean.setOrganiser(true);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.loginMethod(userBean);
            loggedUserBean = loginController.loginMethod(_userBean);
        } catch (LoginFromDBException e) {
            flag = 1;
        }

        assertEquals(0, flag);
    }

    @Test
    void signInMethodUsernameTaken() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("Sw1");
        userBean.setPassword("5");
        userBean.setOrganiser(false);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.signInMethod(userBean);
        } catch (AlreadyInUseException e) {
            flag = 1;
        }

        assertEquals(1, flag);
    }

    @Test
    void signInMethodUsernameTakenOrg() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("Org1");
        userBean.setPassword("5");
        userBean.setOrganiser(false);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.signInMethod(userBean);
        } catch (AlreadyInUseException e) {
            flag = 1;
        }

        assertEquals(1, flag);
    }

    @Test
    void signInMethodSamePassword() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("pane");
        userBean.setPassword("5");
        userBean.setOrganiser(false);

        UserBean _userBean = new UserBean();
        userBean.setUsername("pasta");
        userBean.setPassword("5");
        userBean.setOrganiser(false);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.signInMethod(userBean);
            loggedUserBean = loginController.signInMethod(_userBean);
        } catch (AlreadyInUseException e) {
            flag = 1;
        }

        assertEquals(0, flag);
    }

    @Test
    void signInDifferentRoles() {
        int flag = 0;

        UserBean userBean = new UserBean();
        userBean.setUsername("pane");
        userBean.setPassword("5");
        userBean.setOrganiser(true);

        UserBean _userBean = new UserBean();
        userBean.setUsername("pane");
        userBean.setPassword("5");
        userBean.setOrganiser(false);

        LoggedUserBean loggedUserBean = new LoggedUserBean();
        LoginController loginController = new LoginController();

        try {
            loggedUserBean = loginController.signInMethod(userBean);
            loggedUserBean = loginController.signInMethod(_userBean);
        } catch (AlreadyInUseException e) {
            flag = 1;
        }

        assertEquals(0, flag);
    }
}