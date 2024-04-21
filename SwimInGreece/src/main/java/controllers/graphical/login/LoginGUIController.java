package controllers.graphical.login;

import controllers.application.LoginController;
import engClasses.beans.login.LoggedUserBean;
import engClasses.beans.login.UserBean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginGUIController implements Initializable {

    @FXML
    private Button bookBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private Button homeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private HBox navbar;

    @FXML
    private TextField passwordField;

    @FXML
    private Button registerBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField usernameField;

    @FXML
    private CheckBox orgCheckBox;

    public LoginGUIController() {}

    private void onHome() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showHomepage();
    }

    private void onCreateAccount() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showCreateAccount();
    }

    private void onLogin() {
        LoggedUserBean loggedUserBean;
        Session session = new Session();
        boolean isOrganiser = orgCheckBox.isSelected();
        String username = usernameField.getText();
        String password = passwordField.getText();


        UserBean userBean = new UserBean();
        userBean.setUsername(username);
        userBean.setOrganiser(isOrganiser);
        userBean.setPassword(password);
        LoginController loginController = new LoginController();
        loggedUserBean = loginController.loginMethod(userBean);
        session.setLoggedUserBean(loggedUserBean);

        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);

        if(isOrganiser) {
            Model.getInstance().getViewFactory().showOrganiserHomePage(session);
        } else {
            Model.getInstance().getViewFactory().showSwimmerHomepage(session);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);

        homeBtn.setOnAction(actionEvent -> onHome());
        registerBtn.setOnAction(actionEvent -> onCreateAccount());
        submitBtn.setOnAction(actionEvent -> onLogin());
    }
}
