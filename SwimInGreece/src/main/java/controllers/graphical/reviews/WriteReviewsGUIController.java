package controllers.graphical.reviews;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import misc.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class WriteReviewsGUIController implements Initializable {
    private Session session;

    @FXML
    private ChoiceBox<String> ratingChoiceBox;

    @FXML
    private Button submitBtn;

    @FXML
    private TextArea textArea;

    ObservableList<String> reviewString = FXCollections.observableArrayList();

    public WriteReviewsGUIController(Session session) {
        this.session = session;
    }

    private void choiceBoxInit(ChoiceBox choiceBox) {
        for(int i = 1; i < 6; i = i+1) {
            reviewString.add(Integer.toString(i) + " Stars");
        }
        choiceBox.setItems(reviewString);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxInit(ratingChoiceBox);
    }
}
