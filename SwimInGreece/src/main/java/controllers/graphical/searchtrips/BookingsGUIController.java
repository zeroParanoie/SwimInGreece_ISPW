package controllers.graphical.searchtrips;

import controllers.application.WriteReview;
import engclasses.beans.reviews.BookingBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;
import model.Booking;

import java.net.URL;
import java.util.ResourceBundle;

public class BookingsGUIController implements Initializable {


    private Session session;

    @FXML
    private Button backBtn;

    @FXML
    private TableColumn<Booking, String> dateCol;

    @FXML
    private Button reviewBtn;

    @FXML
    private TableView<Booking> tableView;

    @FXML
    private TableColumn<Booking, String> tourCol;

    ObservableList<Booking> bookingObservableList = FXCollections.observableArrayList();

    public BookingsGUIController(Session session) {
        this.session = session;
    }

    private void setTableView() {
        WriteReview writeReview = new WriteReview();
        BookingBean bookingBean = new BookingBean();

        bookingBean = writeReview.getBookings(session.getLoggedUserBean());
        for(Booking booking : bookingBean.getBookings()) {
            this.bookingObservableList.add(booking);
        }

        this.dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.tourCol.setCellValueFactory(new PropertyValueFactory<>("tourName"));
        this.tableView.setItems(bookingObservableList);
    }

    private void onReview() {
        Booking booking = tableView.getSelectionModel().getSelectedItem();
        Model.getInstance().getViewFactory().showReviewSubmitForm(session, booking.getTour());
    }

    private void onBack() {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showPersonalArea(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTableView();
        backBtn.setOnAction(actionEvent -> onBack());
        reviewBtn.setOnAction(actionEvent -> onReview());
    }
}

