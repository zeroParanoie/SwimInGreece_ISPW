package controllers.graphical.sponsorTrip;

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

public class SponsorTripFormGUIController implements Initializable {
    private Session session;



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
    private Button sponsorBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private TextField swimsField;

    @FXML
    private Label swimsLabel;
    private ObservableList<String> placesObservableList = FXCollections.observableArrayList();

    public SponsorTripFormGUIController(Session session) {
        this.session = session;
    }

    private void onAdd() {
        int numberOfSwims;
        try {
            numberOfSwims = Integer.parseInt(swimsField.getText());
        } catch (NumberFormatException nfe) {
            throw new RuntimeException("insert an integer!");
        }

        for (int i = 0; i < numberOfSwims; i += 1) {
            Model.getInstance().getViewFactory().showAddSwim(session, i + 1);
        }
    }

    private void onHome() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOrganiserHomePage(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(Places places : Places.values()) {
            placesObservableList.add(places.place);
        }
        placeChoiceBox.setItems(placesObservableList);

        submitBtn.setOnAction(actionEvent -> onAdd());
        homeBtn.setOnAction(actionEvent -> onHome());
    }
}
