package controllers.graphical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class OrgPersonalAreaGUIController implements Initializable {
    private Session session;

    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button pubBtn;

    @FXML
    private Button revBtn;

    public OrgPersonalAreaGUIController(Session session) {
        this.session = session;
    }

    private void onHome() {
        Stage stage = (Stage) pubBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOrganiserHomePage(session);
    }

    private void logout() {
        Stage stage = (Stage) pubBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showHomepage(session);
    }

    private void onPubs() {
        Stage stage = (Stage) pubBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOrgPubs(session);
    }

    private void onReviews() {
        Stage stage = (Stage) pubBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showReviewsOrganiser(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        logoutBtn.setOnAction(actionEvent -> logout());
        homeBtn.setOnAction(actionEvent -> onHome());
        pubBtn.setOnAction(actionEvent -> onPubs());
        revBtn.setOnAction(actionEvent -> onReviews());
    }
}

