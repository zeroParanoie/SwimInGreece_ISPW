package controllers.graphical.searchTrips;

import controllers.application.SearchTrips;
import engClasses.beans.searchTrips.TourBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;
import model.Tour;

import java.net.URL;
import java.util.ResourceBundle;

public class SearchTripsGUIController implements Initializable {
    private Session session;
    @FXML
    private Button bookBtn;

    @FXML
    private HBox finalDatePicker;

    @FXML
    private Button homeBtn;

    @FXML
    private TableColumn<Tour, Float> lengthCol;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField maxLengthField;

    @FXML
    private TableColumn<Tour, String> nameCol;

    @FXML
    private HBox navbar;

    @FXML
    private TableColumn<Tour, String> orgCol;

    @FXML
    private TableColumn<Tour, String> placeCol;

    @FXML
    private TextField searchField;

    @FXML
    private Button refreshBtn;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<Tour> tableView;

    @FXML
    private Label errorLabel;

    ObservableList<Tour> tourObservableList = FXCollections.observableArrayList();

    public SearchTripsGUIController(Session session) {
        this.session = session;
    }

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

    private void onBook() {
        if(session.getLoggedUserBean() == null) {
            errorLabel.setText("you need to login to perform that action!");
            errorLabel.setVisible(true);
        } else {
            //booking logic
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);

        homeBtn.setOnAction(actionEvent -> onHome());
        loginBtn.setOnAction(actionEvent -> onLogin());
        submitBtn.setOnAction(actionEvent -> onBook());


        SearchTrips searchTrips = new SearchTrips();
        TourBean allTours = new TourBean();
        allTours = searchTrips.getAllTours();
        for(Tour tour : allTours.getTours()) {

            tourObservableList.add(tour);
        }

        lengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        orgCol.setCellValueFactory(new PropertyValueFactory<>("orgName"));
        placeCol.setCellValueFactory(new PropertyValueFactory<>("place"));

        tableView.setItems(tourObservableList);
    }

}
