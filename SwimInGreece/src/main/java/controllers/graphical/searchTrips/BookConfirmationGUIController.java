package controllers.graphical.searchTrips;

import controllers.application.SearchTrips;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import misc.Session;
import model.Tour;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class BookConfirmationGUIController implements Initializable {

    private Session session;

    private Tour bookingTour;

    @FXML
    private DatePicker datepicker;

    @FXML
    private Label inputLabel;

    @FXML
    private Button submitBtn;

    public BookConfirmationGUIController(Session session, Tour bookingTour) {
        this.session = session;
        this.bookingTour = bookingTour;
    }

    private void onBook() {
        String formattedDate = datepicker.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        SearchTrips searchTrips = new SearchTrips();

        searchTrips.book(formattedDate, bookingTour, session.getLoggedUserBean());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inputLabel.setText("You are booking the '" + bookingTour.getName() + "' tour");
        submitBtn.setText("Confirm booking");
        submitBtn.setOnAction(actionEvent -> onBook());
    }
}
