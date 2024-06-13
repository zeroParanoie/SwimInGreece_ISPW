package controllers.graphical.sponsortrip;

import controllers.application.SponsorTourController;
import engclasses.beans.addswim.BeanNewSwim;
import engclasses.beans.sponsortour.BeanNewTour;
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

    private BeanNewTour referencedTour;

    @FXML
    private Label errorLabel;

    @FXML
    private Label inputLabel;

    @FXML
    private TextField lengthField;

    @FXML
    private Button submitBtn;

    public AddSwimGUIController(Session session, int swimNum, int maxSwims, Stage closingStage, BeanNewTour referencedTour) {
        this.session = session;
        this.swimNum = swimNum;
        this.totalSwims = maxSwims;
        this.closingStage = closingStage;
        this.referencedTour = referencedTour;
    }

    private void onSubmit() {
        if (lengthField.getText().isEmpty()) {
            errorLabel.setVisible(true);
        } else {

            BeanNewSwim beanNewSwim = new BeanNewSwim();
            try {
                Float length = Float.parseFloat(lengthField.getText());
                beanNewSwim.setLength(length);
            } catch (NumberFormatException nfe) {
                errorLabel.setText("Not a number!");
                errorLabel.setVisible(true);
            }

            SponsorTourController sponsorTourController = new SponsorTourController();
            sponsorTourController.saveSwim(beanNewSwim, referencedTour);
            Stage stage = (Stage) submitBtn.getScene().getWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
            if (swimNum == totalSwims) {
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
