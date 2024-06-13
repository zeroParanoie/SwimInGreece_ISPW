package controllers.graphical.searchtrips;

import controllers.application.SearchTrips;
import engclasses.exceptions.NoTripsFound;
import engclasses.exceptions.TourNotSelectedException;
import engclasses.beans.searchtrips.TourBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;
import model.Tour;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedSearchTripsGUIController implements Initializable {

    private Session session;

    @FXML
    private Button bookBtn;

    @FXML
    private Button refreshBtn;

    @FXML
    private HBox finalDatePicker;

    @FXML
    private Button homeBtn;

    @FXML
    private TableColumn<Tour, Float> lengthCol;

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
    private TableView<Tour> tableView;

    ObservableList<Tour> tourObservableList = FXCollections.observableArrayList();

    public LoggedSearchTripsGUIController(Session session) {
        this.session = session;
    }

    private void onHome() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSwimmerHomepage(session);
    }

    private void onBook() throws TourNotSelectedException {
        Tour selectedTour = tableView.getSelectionModel().getSelectedItem();
        if(selectedTour == null) {
            throw new TourNotSelectedException("no tour selected!");
        }
        Model.getInstance().getViewFactory().showBookConfirmation(session, selectedTour);
    }

    private void onRefresh() {
        ObservableList<Tour> filteredToursObservableList = FXCollections.observableArrayList();
        SearchTrips searchTrips = new SearchTrips();
        TourBean tourBean = new TourBean();



        try {
            if(searchField.getText().isEmpty() && maxLengthField.getText().isEmpty()) {
                tourBean = searchTrips.getAllTours();
            } else if(searchField.getText().isEmpty() && !maxLengthField.getText().isEmpty()) {
                tourBean = searchTrips.getSelectedTours("", Float.parseFloat(maxLengthField.getText()));
            } else if(!searchField.getText().isEmpty() && maxLengthField.getText().isEmpty()) {
                tourBean = searchTrips.getSelectedTours(searchField.getText(), 0);
            } else if(!searchField.getText().isEmpty() && !maxLengthField.getText().isEmpty()) {
                tourBean = searchTrips.getSelectedTours("", Float.parseFloat(maxLengthField.getText()));
            }
        } catch (NoTripsFound ntf) {
            ntf.printStackTrace();
        }


        for(Tour tour : tourBean.getTours()) {
            filteredToursObservableList.add(tour);
        }

        this.tableView.setItems(filteredToursObservableList);
    }

    private void onReviews() {
        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showTourReviewsFromBooking(session, tableView.getSelectionModel().getSelectedItem());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        homeBtn.setOnAction(actionEvent -> onHome());
        submitBtn.setOnAction(actionEvent -> {
            try {
                onBook();
            } catch (TourNotSelectedException e) {
                e.printStackTrace();
            }
        });
        refreshBtn.setOnAction(actionEvent -> onRefresh());
        readReviewsBtn.setOnAction(actionEvent -> onReviews());

        SearchTrips searchTrips = new SearchTrips();
        TourBean allTours = new TourBean();
        try {
            allTours = searchTrips.getAllTours();
        } catch (NoTripsFound e) {
            e.printStackTrace();
        }
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

