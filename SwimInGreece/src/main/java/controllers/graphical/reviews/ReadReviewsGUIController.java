package controllers.graphical.reviews;

import controllers.application.WriteReview;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import misc.Session;
import model.Tour;

import java.net.URL;
import java.util.ResourceBundle;

public class ReadReviewsGUIController implements Initializable {


    private Session session;

    private Tour tour;

    @FXML
    private TableColumn<Tour, String> bodyCol;

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
    private TableColumn<Tour, Integer> ratingCol;

    @FXML
    private Button submitBtn;

    @FXML
    private TableView<Tour> tableView;

    @FXML
    private ProgressBar threeBar;

    @FXML
    private Label threeLabel;

    @FXML
    private Label threePer;

    @FXML
    private ProgressBar twoBar;

    @FXML
    private Label twoLabel;

    @FXML
    private Label twoPerc;

    @FXML
    private TableColumn<Tour, String> userCol;

    public ReadReviewsGUIController(Session session, Tour tour) {
        this.session = session;
        this.tour = tour;
    }

    private void startSettings() {
        WriteReview writeReview = new WriteReview();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        startSettings();
    }

}
