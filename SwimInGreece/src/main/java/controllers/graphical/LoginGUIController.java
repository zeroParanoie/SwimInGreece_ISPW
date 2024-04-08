package controllers.graphical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);

        homeBtn.setOnAction(actionEvent -> onHome());
        registerBtn.setOnAction(actionEvent -> onCreateAccount());
    }
}
