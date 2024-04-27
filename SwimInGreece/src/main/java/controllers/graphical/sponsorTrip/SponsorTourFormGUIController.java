package controllers.graphical.sponsorTrip;

import controllers.application.SponsorTourController;
import engClasses.beans.sponsorTour.BeanNewTour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Places;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class SponsorTourFormGUIController implements Initializable {
    private Session session;


    @FXML
    private Label TourNameLabel;

    @FXML
    private TextField TourNameField;

    @FXML
    private AnchorPane body;

    @FXML
    private Button homeBtn;

    @FXML
    private HBox navbar;

    @FXML
    private ChoiceBox<String> placeChoiceBox;

    @FXML
    private Label placeLabel;

    @FXML
    private Button readReviewsBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private Button sponsorBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField swimsField;

    @FXML
    private Label swimsLabel;
    private ObservableList<String> placesObservableList = FXCollections.observableArrayList();

    public SponsorTourFormGUIController(Session session) {
        this.session = session;
    }

    private void onAdd() {
        if (TourNameField.getText().isEmpty() || swimsField.getText().isEmpty() || placeChoiceBox.getValue() == null) {
            errorLabel.setVisible(true);
            errorLabel.setText("Fields can't be empty!");
        } else {
            errorLabel.setVisible(false);
            int numberOfSwims;
            try {
                numberOfSwims = Integer.parseInt(swimsField.getText());
            } catch (NumberFormatException nfe) {
                throw new RuntimeException("insert an integer!");
            }

            BeanNewTour beanNewTour = new BeanNewTour();
            beanNewTour.setName(TourNameField.getText());
            beanNewTour.setOrganiser(session.getLoggedUserBean().getUsr());
            beanNewTour.setLength(0);
            beanNewTour.setPlace(placeChoiceBox.getValue());
            SponsorTourController sponsorTourController = new SponsorTourController();
            sponsorTourController.saveTour(beanNewTour);

            for (int i = numberOfSwims; i > 0; i = i - 1) {
                Model.getInstance().getViewFactory().showAddSwim(session, i, numberOfSwims, (Stage) errorLabel.getScene().getWindow(), beanNewTour);
            }
        }

    }

    private void onHome() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOrganiserHomePage(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);

        for(Places places : Places.values()) {
            placesObservableList.add(places.place);
        }
        placeChoiceBox.setItems(placesObservableList);

        submitBtn.setOnAction(actionEvent -> onAdd());
        homeBtn.setOnAction(actionEvent -> onHome());
    }
}
