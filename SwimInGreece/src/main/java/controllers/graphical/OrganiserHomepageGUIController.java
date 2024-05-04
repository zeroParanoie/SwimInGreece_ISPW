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
import model.Organiser;

import java.net.URL;
import java.util.ResourceBundle;

public class OrganiserHomepageGUIController implements Initializable {
    private Session session;
    @FXML
    private AnchorPane body;

    @FXML
    private Button personalAreaBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private Button homeBtn;

    @FXML
    private HBox navbar;

    @FXML
    private Button readReviewsBtn;

    @FXML
    private Button sponsorBtn;

    @FXML
    private Label welcomeLabel;

    public OrganiserHomepageGUIController(Session session) {
        this.session = session;
    }

    private void onSponsor() {
        Stage stage = (Stage) welcomeLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSponsor(session);
    }

    private void onPersonalArea() {
        Stage stage = (Stage) welcomeLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showPersonalArea(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        welcomeLabel.setText("Welcome back, " + session.getLoggedUserBean().getFullname());

        sponsorBtn.setOnAction(actionEvent -> onSponsor());
        personalAreaBtn.setOnAction(actionEvent -> onPersonalArea());
    }
}
