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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAccountGUIController implements Initializable {
    @FXML
    private AnchorPane body;

    @FXML
    private CheckBox orgCheckBox;

    @FXML
    private Button bookBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField fullnameField;

    @FXML
    private Button homeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private HBox navbar;

    @FXML
    private TextField passwordField;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField usernameField;

    private void onLogin() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLogin();
    }

    private void onHome() {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showHomepage();
    }

    private void onSignIn() {
        LoggedUserBean loggedUserBean;
        boolean isOrganiser = orgCheckBox.isSelected();
        String username = usernameField.getText();
        String password = passwordField.getText();
        String fullname = fullnameField.getText();
        UserBean userBean = new UserBean();
        userBean.setOrganiser(isOrganiser);
        userBean.setPassword(password);
        userBean.setUsername(username);
        userBean.setFullname(fullname);
        LoginController loginController = new LoginController();
        loggedUserBean = loginController.signInMethod(userBean);

        Stage stage = (Stage) usernameField.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showHomepage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);

        homeBtn.setOnAction(actionEvent -> onHome());
        loginBtn.setOnAction(actionEvent -> onLogin());
        submitBtn.setOnAction(actionEvent -> onSignIn());
    }
}
