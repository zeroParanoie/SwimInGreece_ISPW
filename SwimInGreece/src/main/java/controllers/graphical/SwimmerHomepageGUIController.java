package controllers.graphical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.CheckBoxTreeTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class SwimmerHomepageGUIController implements Initializable {
    private Session session;

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
    private Button personalAreaBtn;
    @FXML
    private Button sponsorBtn;

    @FXML
    private Label welcomeLabel;

    public SwimmerHomepageGUIController(Session session) {
        this.session = session;
    }

    private void onBook() {
        Stage stage = (Stage) welcomeLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showBooking(session);
    }

    private void onPersonalArea() {
        Stage stage = (Stage) welcomeLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showPersonalArea(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        welcomeLabel.setText("Welcome back, " + this.session.getLoggedUserBean().getFullname());

        bookBtn.setOnAction(actionEvent -> onBook());
        personalAreaBtn.setOnAction(actionEvent -> onPersonalArea());
    }
}
