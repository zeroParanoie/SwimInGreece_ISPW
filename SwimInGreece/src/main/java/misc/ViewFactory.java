package misc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
    public ViewFactory() {}

    public void showHomepage() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/Homepage1.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }
}
