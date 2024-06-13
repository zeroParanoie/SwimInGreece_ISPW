package controllers.graphical.login;

import controllers.application.LoginController;
import engclasses.beans.login.LoggedUserBean;
import engclasses.beans.login.UserBean;
import engclasses.exceptions.LoginFromDBException;
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
    private Session session;

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

    public LoginGUIController(Session session) {
        this.session = session;
    }

    private void onHome() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showHomepage(session);
    }

    private void onCreateAccount() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showCreateAccount(session);
    }

    private void onLogin() {


        try {
            LoggedUserBean loggedUserBean;
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
            session.setChosenView(this.session.getChosenView());
            Stage stage = (Stage) submitBtn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);

            if(isOrganiser) {
                session.setOrganiser(true);
                Model.getInstance().getViewFactory().showOrganiserHomePage(session);
            } else {
                session.setOrganiser(false);
                Model.getInstance().getViewFactory().showSwimmerHomepage(session);
            }
        } catch (LoginFromDBException e) {
            errorLabel.setText("username or password are incorrect!");
            errorLabel.setVisible(true);
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
