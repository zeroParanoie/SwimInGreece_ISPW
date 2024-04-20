package controllers.graphical.sponsorTrip;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class AddSwimGUIController implements Initializable {

    private Session session;

    private int swimNum;

    @FXML
    private Label inputLabel;

    @FXML
    private TextField lengthField;

    @FXML
    private Button submitBtn;

    public AddSwimGUIController(Session session, int swimNum) {
        this.session = session;
        this.swimNum = swimNum;
    }

    private void onSubmit() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputLabel.setText("length of the #" + swimNum + " swim");
        submitBtn.setOnAction(actionEvent -> onSubmit());
    }
}
