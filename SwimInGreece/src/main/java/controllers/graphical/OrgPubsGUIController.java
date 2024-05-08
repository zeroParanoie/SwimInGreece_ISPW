package controllers.graphical;

import controllers.application.SearchTrips;
import engClasses.beans.searchTrips.TourBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import misc.Session;
import model.Tour;

import java.net.URL;
import java.util.ResourceBundle;

public class OrgPubsGUIController implements Initializable {

    private Session session;

    @FXML
    private Button bookBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private HBox navbar;

    @FXML
    private TableColumn<Tour, String> placeCol;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<Tour> tableView;

    @FXML
    private TableColumn<Tour, String> tourCol;

    ObservableList<Tour> tourObservableList = FXCollections.observableArrayList();

    public OrgPubsGUIController(Session session) {
        this.session = session;
    }

    private void tableInit() {
        SearchTrips searchTrips = new SearchTrips();
        TourBean tourBean = searchTrips.getToursOrg(session.getLoggedUserBean());

        for(Tour tour : tourBean.getTours()) {
            tourObservableList.add(tour);
        }

        tourCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        placeCol.setCellValueFactory(new PropertyValueFactory<>("place"));

        tableView.setItems(tourObservableList);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableInit();
    }
}

