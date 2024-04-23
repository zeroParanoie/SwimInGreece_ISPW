package controllers.graphical.sponsorTrip;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class SubmitTripGUIController implements Initializable {

    private Session session;

    @FXML
    private Label labelBot;

    @FXML
    private Label labelTop;

    @FXML
    private Button submitBtn;

    public SubmitTripGUIController(Session session) {
        this.session = session;
    }

    private void onSubmit() {
        Model.getInstance().getViewFactory().showOrganiserHomePage(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        submitBtn.setOnAction(actionEvent -> onSubmit());
    }
}