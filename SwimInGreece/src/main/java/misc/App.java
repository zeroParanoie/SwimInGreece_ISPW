package misc;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Session session = new Session();
        session.setChosenView(1);
        Model.getInstance().getViewFactory().showHomepage(session);
    }
}
