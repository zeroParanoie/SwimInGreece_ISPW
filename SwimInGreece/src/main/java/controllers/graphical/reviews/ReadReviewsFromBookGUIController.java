package controllers.graphical.reviews;

import controllers.application.WriteReview;
import engClasses.beans.reviews.FetchReviewsBean;
import engClasses.exceptions.DivisionByZero;
import engClasses.exceptions.NoReviewsFound;
import engClasses.exceptions.NoTripsFound;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;
import model.Review;
import model.Tour;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadReviewsFromBookGUIController implements Initializable {

    private Session session;
    private Tour tour;

    @FXML
    private TableColumn<Review, String> bodyCol;

    @FXML
    private Button bookBtn;

    @FXML
    private ProgressBar fiveBar;

    @FXML
    private Label fiveLabel;

    @FXML
    private Label fivePerc;

    @FXML
    private ProgressBar fourBar;

    @FXML
    private Label fourLabel;

    @FXML
    private Label fourPerc;

    @FXML
    private Button homeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private HBox navbar;

    @FXML
    private ProgressBar oneBar;

    @FXML
    private Label oneLabel;

    @FXML
    private Label onePerc;

    @FXML
    private TableColumn<Review, Integer> ratingCol;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<Review> tableView;

    @FXML
    private ProgressBar threeBar;

    @FXML
    private Label threeLabel;

    @FXML
    private Label threePerc;

    @FXML
    private ProgressBar twoBar;

    @FXML
    private Label twoLabel;

    @FXML
    private Label twoPerc;

    @FXML
    private TableColumn<Review, String> userCol;

    ObservableList<Review> reviewObservableList = FXCollections.observableArrayList();

    public ReadReviewsFromBookGUIController(Session session, Tour tour) {
        this.session = session;
        this.tour = tour;
    }

    private void tableInit() {
        WriteReview writeReview = new WriteReview();
        FetchReviewsBean fetchReviewsBean = new FetchReviewsBean();

        try {
            fetchReviewsBean = writeReview.getReviews(tour.getName());
        } catch (NoReviewsFound e) {
            reviewObservableList = null;
        } catch (NoTripsFound ntf) {
            throw new RuntimeException(ntf);
        }

        for(Review review : fetchReviewsBean.getReviews()) {
            reviewObservableList.add(review);
        }

        bodyCol.setCellValueFactory(new PropertyValueFactory<>("body"));
        ratingCol.setCellValueFactory(new PropertyValueFactory<>("rating"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("swimmerName"));

        tableView.setItems(reviewObservableList);
    }

    public void progressBarsInit() {

        try {
            WriteReview writeReview = new WriteReview();
            FetchReviewsBean fetchReviewsBean = null;
            fetchReviewsBean = writeReview.getReviews(tour.getName());

            float percentage;

            for(int i = 1; i < 6; i += 1) {
                percentage = writeReview.getRatingPercentage(i, fetchReviewsBean);
                switch (i) {
                    case 1:
                        oneBar.setProgress(percentage);
                        onePerc.setText(percentage * 100 + "%");
                        break;
                    case 2:
                        twoBar.setProgress(percentage);
                        twoPerc.setText(percentage * 100 + "%");
                        break;
                    case 3:
                        threeBar.setProgress(percentage);
                        threePerc.setText(percentage * 100 + "%");
                        break;
                    case 4:
                        fourBar.setProgress(percentage);
                        fourPerc.setText(percentage * 100 + "%");
                        break;
                    case 5:
                        fiveBar.setProgress(percentage);
                        fivePerc.setText(percentage * 100 + "%");
                        break;
                    default:
                        break;
                }
            }
        } catch (NoReviewsFound e) {
            throw new RuntimeException(e);
        } catch (DivisionByZero dbz) {
            onePerc.setText("0%");
            twoPerc.setText("0%");
            threePerc.setText("0%");
            fourPerc.setText("0%");
            fivePerc.setText("0%");
        } catch (NoTripsFound ntf) {
            throw new RuntimeException(ntf);
        }

    }

    private void onHome() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSwimmerHomepage(session);
    }

    private void back() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showBooking(session);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableInit();
        loginBtn.setVisible(false);
        homeBtn.setOnAction(actionEvent -> onHome());
        submitBtn.setOnAction(actionEvent -> back());
        progressBarsInit();
    }
}

