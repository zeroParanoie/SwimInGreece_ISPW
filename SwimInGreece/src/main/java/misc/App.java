package misc;

import com.opencsv.exceptions.CsvValidationException;
import engClasses.DAO.CSVSwimmerDAO;
import engClasses.exceptions.DupSwimmerException;
import engClasses.exceptions.WrongCredsException;
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

        CSVSwimmerDAO csvSwimmerDAO = new CSVSwimmerDAO();
        Swimmer swimmer = new Swimmer("Sw1", "Mario Rossi");
        try {
            csvSwimmerDAO.addSwimmer(swimmer, "1");
        } catch (DupSwimmerException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (WrongCredsException e) {
            throw new RuntimeException(e);
        }

        Model.getInstance().getViewFactory().showHomepage(session);
    }
}
