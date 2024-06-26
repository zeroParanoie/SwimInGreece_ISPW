package controllers.graphical.reviews;

import controllers.application.WriteReview;
import engclasses.beans.reviews.FetchReviewsBean;
import engclasses.exceptions.NoReviewsFound;
import engclasses.exceptions.NoTripsFound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;
import model.Review;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadReviewsSwimmerGUIController implements Initializable {


    private Session session;


    @FXML
    private TableColumn<Review, String> bodyCol;

    @FXML
    private Button bookBtn;

    @FXML
    private Button homeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private HBox navbar;

    @FXML
    private TableColumn<Review, Integer> ratingCol;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<Review> tableView;

    @FXML
    private TableColumn<Review, String> tourCol;

    ObservableList<Review> reviewObservableList = FXCollections.observableArrayList();

    public ReadReviewsSwimmerGUIController(Session session) {
        this.session = session;
    }

    private void startSettings() {


        try {
            WriteReview writeReview = new WriteReview();
            FetchReviewsBean fetchReviewsBean = new FetchReviewsBean();
            fetchReviewsBean = writeReview.getReviews(session.getLoggedUserBean());
            for(Review review : fetchReviewsBean.getReviews()) {
                reviewObservableList.add(review);
            }
        } catch (NoReviewsFound e) {
            reviewObservableList = null;
        } catch (NoTripsFound e) {
            session.getLogger().info(e.getMessage());
        }

        tourCol.setCellValueFactory(new PropertyValueFactory<>("tourName"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        bodyCol.setCellValueFactory(new PropertyValueFactory<>("body"));

        tableView.setItems(reviewObservableList);
    }

    public void revOnHome() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSwimmerHomepage(session);
    }

    public void revBack() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showBooking(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startSettings();
        loginBtn.setVisible(false);
        homeBtn.setOnAction(actionEvent -> revOnHome());
        bookBtn.setOnAction(actionEvent -> revBack());
    }

}
