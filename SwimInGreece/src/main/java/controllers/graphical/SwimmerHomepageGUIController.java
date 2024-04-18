package controllers.graphical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class SwimmerHomepageGUIController implements Initializable {
    Session session;

    @FXML
    private Button becomeGuideBtn;

    @FXML
    private AnchorPane body;

    @FXML
    private Button bookBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private Button homeBtn;

    @FXML
    private HBox navbar;

    @FXML
    private Button sponsorBtn;

    @FXML
    private Label welcomeLabel;

    public SwimmerHomepageGUIController(Session session) {
        this.session = session;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeLabel.setText("Welcome back, " + this.session.getLoggedUserBean().getFullname());
    }
}
