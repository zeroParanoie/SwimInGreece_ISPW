package misc;

import controllers.graphical.OrganiserHomepageGUIController;
import controllers.graphical.SwimmerHomepageGUIController;
import controllers.graphical.login.CreateAccountGUIController;
import controllers.graphical.HomeGUIController;
import controllers.graphical.login.LoginGUIController;
import controllers.graphical.SearchTripsGUIController;
import controllers.graphical.sponsorTrip.AddSwimGUIController;
import controllers.graphical.sponsorTrip.SponsorTourFormGUIController;
import controllers.graphical.sponsorTrip.SubmitTourGUIController;
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
        showStage(loader);
    }

    private void showStage(FXMLLoader loader) {
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
        showStage(loader);
    }

    public void showBooking(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SearchTrips1.fxml"));
        loader.setController(new SearchTripsGUIController(session));
        showStage(loader);
    }

    public void showSwimmerHomepage(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SwimmerHomepage1.fxml"));
        loader.setController(new SwimmerHomepageGUIController(session));
        showStage(loader);
    }

    public void showOrganiserHomePage(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/OrganiserHomepage1.fxml"));
        loader.setController(new OrganiserHomepageGUIController(session));
        showStage(loader);
    }

    public void showSponsor(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SponsorTour1.fxml"));
        loader.setController(new SponsorTourFormGUIController(session));
        showStage(loader);
    }

    public void showAddSwim(Session session, int swimNum, int maxSwims, Stage closingStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/AddSwim1.fxml"));
        loader.setController(new AddSwimGUIController(session, swimNum, maxSwims, closingStage));
        showStage(loader);
    }

    public void showSubmitTour(Session session, Stage closingStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SubmitTour1.fxml"));
        loader.setController(new SubmitTourGUIController(session, closingStage));
        showStage(loader);
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
