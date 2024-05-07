package controllers.graphical.reviews;

import controllers.application.WriteReview;
import engClasses.beans.reviews.ReviewBean;
import engClasses.exceptions.RatingNotSelectedException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;
import model.Tour;

import java.net.URL;
import java.util.ResourceBundle;

public class WriteReviewsGUIController implements Initializable {
    private Session session;
    private Tour tour;

    @FXML
    private ChoiceBox<String> ratingChoiceBox;

    @FXML
    private Button submitBtn;

    @FXML
    private TextArea textArea;

    ObservableList<String> reviewString = FXCollections.observableArrayList();

    public WriteReviewsGUIController(Session session, Tour tour) {
        this.session = session;
        this.tour = tour;
    }

    private void choiceBoxInit(ChoiceBox choiceBox) {
        for(int i = 1; i < 6; i = i+1) {
            reviewString.add(Integer.toString(i) + " Stars");
        }
        choiceBox.setItems(reviewString);
    }

    private void onSubmit() throws RatingNotSelectedException {
        ReviewBean reviewBean = new ReviewBean();
        WriteReview writeReview = new WriteReview();

        reviewBean.setBody(textArea.getText());
        int rating = choiceBoxRatingConverter();
        if(rating == 0) {
            throw new RatingNotSelectedException("you must select a rating from the choicebox!");
        }
        reviewBean.setRating(rating);
        reviewBean.setSwimmer(session.getLoggedUserBean().getUsr());

        writeReview.addReview(reviewBean);

        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    private int choiceBoxRatingConverter() {
        int rating = 0;
        switch(ratingChoiceBox.getValue()) {
            case "5 Stars":
                rating = 5;
                break;
            case "4 Stars":
                rating = 4;
                break;
            case "3 Stars":
                rating = 4;
                break;
            case "2 Stars":
                rating = 4;
                break;
            case "1 Stars":
                rating = 4;
                break;
            default:
                break;
        }

        return rating;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxInit(ratingChoiceBox);
        submitBtn.setOnAction(actionEvent -> {
            try {
                onSubmit();
            } catch (RatingNotSelectedException e) {
                //errorlabel set to visible and set text to insert a rating
            }
        });
    }
}
