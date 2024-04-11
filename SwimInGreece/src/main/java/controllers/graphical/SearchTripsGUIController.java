package controllers.graphical;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchTripsGUIController implements Initializable {

    @FXML
    private Button bookBtn;

    @FXML
    private HBox finalDatePicker;

    @FXML
    private Button homeBtn;

    @FXML
    private TableColumn<?, ?> lengthCol;

    @FXML
    private Button loginBtn;

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
    private TextField searchField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Label errorLabel;

    private void onLogin() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLogin();
    }

    private void onHome() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showHomepage();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        homeBtn.setOnAction(actionEvent -> onHome());
        loginBtn.setOnAction(actionEvent -> onLogin());
    }
}
