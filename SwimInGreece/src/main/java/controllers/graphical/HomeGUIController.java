package controllers.graphical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeGUIController implements Initializable {
    @FXML
    public Button sponsorBtn;

    @FXML
    public Button becomeGuideBtn;

    @FXML
    private AnchorPane body;

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

    public HomeGUIController() {}

    private void onLogin() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLogin();
    }

    private void onBook() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showBooking(new Session());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        sponsorBtn.setVisible(false);

        loginBtn.setOnAction(actionEvent -> onLogin());
        bookBtn.setOnAction(actionEvent -> onBook());
    }
}
