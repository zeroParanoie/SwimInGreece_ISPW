package misc;

import controllers.graphical.OrganiserHomepageGUIController;
import controllers.graphical.SwimmerHomepageGUIController;
import controllers.graphical.login.CreateAccountGUIController;
import controllers.graphical.HomeGUIController;
import controllers.graphical.login.LoginGUIController;
import controllers.graphical.SearchTripsGUIController;
import controllers.graphical.sponsorTrip.AddSwimGUIController;
import controllers.graphical.sponsorTrip.SponsorTripFormGUIController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        loader.setController(new HomeGUIController());
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void showLogin() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/Login1.fxml"));
        loader.setController(new LoginGUIController());
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void showCreateAccount() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/CreateAccount1.fxml"));
        loader.setController(new CreateAccountGUIController());
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void showBooking(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SearchTrips1.fxml"));
        loader.setController(new SearchTripsGUIController(session));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void showSwimmerHomepage(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SwimmerHomepage1.fxml"));
        loader.setController(new SwimmerHomepageGUIController(session));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void showOrganiserHomePage(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/OrganiserHomepage1.fxml"));
        loader.setController(new OrganiserHomepageGUIController(session));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void showSponsor(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SponsorTour1.fxml"));
        loader.setController(new SponsorTripFormGUIController(session));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void showAddSwim(Session session, int swimNum) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/AddSwim1.fxml"));
        loader.setController(new AddSwimGUIController(session, swimNum));
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/misc/icon.jpg"))));
        stage.setScene(scene);
        stage.setTitle("SwimInGreece");
        stage.resizableProperty().set(false);
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
