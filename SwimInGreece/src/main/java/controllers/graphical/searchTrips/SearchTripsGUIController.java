package controllers.graphical.searchTrips;

import controllers.application.SearchTrips;
import engClasses.beans.searchTrips.TourBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
        errorLabel.setText("you need to login to perform that action!");
        errorLabel.setVisible(true);
    }

    private void onRefresh() {
        ObservableList<Tour> filteredToursObservableList = FXCollections.observableArrayList();
        SearchTrips searchTrips = new SearchTrips();
        TourBean tourBean = new TourBean();

        try {
            float maxLength = Float.parseFloat(maxLengthField.getText());
        } catch (NumberFormatException e) {
            errorLabel.setText("max length must be a number!");
            errorLabel.setVisible(true);
            e.printStackTrace();
        }

        if(searchField.getText().isEmpty() && maxLengthField.getText().isEmpty()) {
            errorLabel.setVisible(false);
            tourBean = searchTrips.getAllTours();
        } else if(searchField.getText().isEmpty() && !maxLengthField.getText().isEmpty()) {
            errorLabel.setVisible(false);
            tourBean = searchTrips.getSelectedTours("", Float.parseFloat(maxLengthField.getText()));
        } else if(!searchField.getText().isEmpty() && maxLengthField.getText().isEmpty()) {
            errorLabel.setVisible(false);
            tourBean = searchTrips.getSelectedTours(searchField.getText(), 0);
        } else if(searchField.getText().isEmpty() && !maxLengthField.getText().isEmpty()) {
            errorLabel.setVisible(false);
            tourBean = searchTrips.getSelectedTours("", Float.parseFloat(maxLengthField.getText()));
        }

        for(Tour tour : tourBean.getTours()) {
            filteredToursObservableList.add(tour);
        }

        this.tableView.setItems(filteredToursObservableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);

        homeBtn.setOnAction(actionEvent -> onHome());
        loginBtn.setOnAction(actionEvent -> onLogin());
        submitBtn.setOnAction(actionEvent -> onBook());
        refreshBtn.setOnAction(actionEvent -> onRefresh());

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
