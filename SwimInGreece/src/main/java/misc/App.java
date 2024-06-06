package misc;

import engClasses.DAO.LogWriterDAO;
import engClasses.pattern.Facade;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Swimmer;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Session session = new Session();
        session.setChosenView(0);

        Model.getInstance().getViewFactory().showHomepage(session);
    }
}
