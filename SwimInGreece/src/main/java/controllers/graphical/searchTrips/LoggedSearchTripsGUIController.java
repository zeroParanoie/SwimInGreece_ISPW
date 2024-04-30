package controllers.graphical.searchTrips;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedSearchTripsGUIController implements Initializable {

    private Session session;

    @FXML
    private Button bookBtn;

    @FXML
    private HBox finalDatePicker;

    @FXML
    private Button homeBtn;

    @FXML
    private TableColumn<?, ?> lengthCol;

    @FXML
    private TextField maxLengthField;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private HBox navbar;

    @FXML
    private TableColumn<?, ?> orgCol;

    @FXML
    private TableColumn<?, ?> placeCol;

    @FXML
    private Button readReviewsBtn;

    @FXML
    private TextField searchField;

    @FXML
    private Button sponsorBtn;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<?> tableView;

    public LoggedSearchTripsGUIController(Session session) {
        this.session = session;
    }

    private void onHome() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSwimmerHomepage(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeBtn.setOnAction(actionEvent -> onHome());
    }
}
