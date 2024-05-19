package misc;

import com.opencsv.exceptions.CsvValidationException;
import engClasses.DAO.CSVSwimmerDAO;
import engClasses.exceptions.DupSwimmerException;
import engClasses.exceptions.WrongCredsException;
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
