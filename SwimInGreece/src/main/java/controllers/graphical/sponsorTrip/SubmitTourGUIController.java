package controllers.graphical.sponsorTrip;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class SubmitTourGUIController implements Initializable {

    private Session session;

    private Stage closingStage;

    @FXML
    private Label labelBot;

    @FXML
    private Label labelTop;

    @FXML
    private Button submitBtn;

    public SubmitTourGUIController(Session session, Stage closingStage) {
        this.closingStage = closingStage;
        this.session = session;
    }

    private void onSubmit() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().closeStage(closingStage);
        Model.getInstance().getViewFactory().showOrganiserHomePage(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submitBtn.setOnAction(actionEvent -> onSubmit());
    }
}