package controllers.graphical;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import misc.Model;
import misc.Session;
import org.controlsfx.control.ToggleSwitch;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeGUIController implements Initializable {
    private Session session;

    @FXML
    private AnchorPane body;

    @FXML
    private ToggleSwitch toggleSwitch;

    @FXML
    private Button bookBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private Button homeBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private HBox navbar;

    public HomeGUIController(Session session) {
        this.session = session;
    }

    private void onLogin() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLogin(session);
    }

    private void onBook() {
        Stage stage = (Stage) loginBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showBooking(new Session());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLabel.setVisible(false);
        if(session.getChosenView() == 1) {
            toggleSwitch.setSelected(true);
        }

        toggleSwitch.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if(session.getChosenView() == 0) {
                    session.setChosenView(1);
                    Stage stage = (Stage) loginBtn.getScene().getWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().showHomepage(session);
                } else {
                    session.setChosenView(0);
                    Stage stage = (Stage) loginBtn.getScene().getWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().showHomepage(session);
                }
            }
        });
        loginBtn.setOnAction(actionEvent -> onLogin());
        bookBtn.setOnAction(actionEvent -> onBook());
    }
}
