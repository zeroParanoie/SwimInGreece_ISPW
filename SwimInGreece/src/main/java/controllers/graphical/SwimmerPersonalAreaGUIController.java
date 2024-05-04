package controllers.graphical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class SwimmerPersonalAreaGUIController implements Initializable {
    private Session session;
    @FXML
    private Button bookingsBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button revBtn;

    public SwimmerPersonalAreaGUIController(Session session) {
        this.session = session;
    }

    private void onHome() {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSwimmerHomepage(session);
    }

    private void logout() {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showHomepage();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeBtn.setOnAction(actionEvent -> onHome());
        logoutBtn.setOnAction(actionEvent -> logout());
    }
}
