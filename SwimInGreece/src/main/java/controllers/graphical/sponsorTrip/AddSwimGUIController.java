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

    private int totalSwims;

    private Stage closingStage;

    @FXML
    private Label errorLabel;

    @FXML
    private Label inputLabel;

    @FXML
    private TextField lengthField;

    @FXML
    private Button submitBtn;

    public AddSwimGUIController(Session session, int swimNum, int maxSwims, Stage closingStage) {
        this.session = session;
        this.swimNum = swimNum;
        this.totalSwims = maxSwims;
        this.closingStage = closingStage;
    }

    private void onSubmit() {
        if (lengthField.getText().isEmpty()) {
            errorLabel.setVisible(true);
        } else {
            if (swimNum != totalSwims) {
                Stage stage = (Stage) submitBtn.getScene().getWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
            } else {
                // here i shall add all the logic to add the swims and go to the tour submit button
                Stage stage = (Stage) submitBtn.getScene().getWindow();
                Model.getInstance().getViewFactory().closeStage(stage);
                Model.getInstance().getViewFactory().showSubmitTour(session, closingStage);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        inputLabel.setText("length of the #" + swimNum + " swim");
        submitBtn.setOnAction(actionEvent -> onSubmit());
    }
}
