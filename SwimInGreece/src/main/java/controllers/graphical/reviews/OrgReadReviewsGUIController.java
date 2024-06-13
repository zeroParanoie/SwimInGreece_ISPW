package controllers.graphical.reviews;

import controllers.application.WriteReview;
import engclasses.beans.reviews.FetchReviewsBean;
import engclasses.exceptions.NoReviewsFound;
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

public class OrgReadReviewsGUIController implements Initializable {

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

    @FXML
    private TableColumn<Review, String> userCol;

    ObservableList<Review> reviews = FXCollections.observableArrayList();

    public OrgReadReviewsGUIController(Session session) {
        this.session = session;
    }

    private void tableInit() throws Exception {


        try {
            WriteReview writeReview = new WriteReview();
            FetchReviewsBean fetchReviewsBean = new FetchReviewsBean();

            fetchReviewsBean = writeReview.getReviews(session.getLoggedUserBean().getUsr());
            for(Review review : fetchReviewsBean.getReviews()) {
                reviews.add(review);
            }
        } catch (NoReviewsFound nrf) {
            nrf.printStackTrace();
        }

        tourCol.setCellValueFactory(new PropertyValueFactory<>("tourName"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("swimmerName"));
        bodyCol.setCellValueFactory(new PropertyValueFactory<>("body"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));

        tableView.setItems(reviews);
    }

    private void onHome() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSwimmerHomepage(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            tableInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        homeBtn.setOnAction(actionEvent -> onHome());
        loginBtn.setVisible(false);
        bookBtn.setVisible(false);
    }
}

