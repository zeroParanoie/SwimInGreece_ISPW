package misc;

import controllers.graphical.*;
import controllers.graphical.login.CreateAccountGUIController;
import controllers.graphical.login.LoginGUIController;
import controllers.graphical.reviews.*;
import controllers.graphical.searchTrips.BookConfirmationGUIController;
import controllers.graphical.searchTrips.BookingsGUIController;
import controllers.graphical.searchTrips.LoggedSearchTripsGUIController;
import controllers.graphical.searchTrips.SearchTripsGUIController;
import controllers.graphical.sponsorTrip.AddSwimGUIController;
import controllers.graphical.sponsorTrip.OrgPubsGUIController;
import controllers.graphical.sponsorTrip.SponsorTourFormGUIController;
import controllers.graphical.sponsorTrip.SubmitTourGUIController;
import engClasses.DAO.LogWriterDAO;
import engClasses.beans.sponsorTour.BeanNewTour;
import engClasses.pattern.Facade;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Swimmer;
import model.Tour;

import java.io.IOException;

public class ViewFactory {
    public ViewFactory() {}

    public void showHomepage(Session session) {
        String resource;

        if(session.getChosenView() == 0) {
            resource = "/firstView/Homepage1.fxml";
        } else {
            resource = "/secondView/Homepage2.fxml";
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        loader.setController(new HomeGUIController(session));
        showStage(loader);
    }

    public void showLogin(Session session) {
        String resource;

        if(session.getChosenView() == 0) {
            resource = "/firstView/Login1.fxml";
        } else {
            resource = "/secondView/Login2.fxml";
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        loader.setController(new LoginGUIController(session));
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

    public void showCreateAccount(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/CreateAccount1.fxml"));
        loader.setController(new CreateAccountGUIController(session));
        showStage(loader);
    }

    public void showBooking(Session session) {
        String resource;
        if(session.getLoggedUserBean() == null) {
            resource = "/firstView/SearchTrips1.fxml";
        } else {
            resource = "/firstView/LoggedSearchTrips1.fxml";
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        if(session.getLoggedUserBean() == null) {
            loader.setController(new SearchTripsGUIController(session));
        } else {
            loader.setController(new LoggedSearchTripsGUIController(session));
        }

        showStage(loader);
    }

    public void showSwimmerHomepage(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SwimmerHomepage1.fxml"));
        loader.setController(new SwimmerHomepageGUIController(session));
        showStage(loader);
        Swimmer swimmer = Facade.getInstance().getSwimmerFromFacade(session.getLoggedUserBean().getUsr());
        LogWriterDAO logWriterDAO = new LogWriterDAO();
        try {
            logWriterDAO.updateLog(swimmer.getBookedTours());
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public void showAddSwim(Session session, int swimNum, int maxSwims, Stage closingStage, BeanNewTour beanNewTour) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/AddSwim1.fxml"));
        loader.setController(new AddSwimGUIController(session, swimNum, maxSwims, closingStage, beanNewTour));
        showStage(loader);
    }

    public void showSubmitTour(Session session, Stage closingStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/SubmitTour1.fxml"));
        loader.setController(new SubmitTourGUIController(session, closingStage));
        showStage(loader);
    }

    public void showBookConfirmation(Session session, Tour bookingTour) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/BookTourConfirmation1.fxml"));
        loader.setController(new BookConfirmationGUIController(session, bookingTour));
        showStage(loader);
    }

    public void showBookings(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/Bookings1.fxml"));
        loader.setController(new BookingsGUIController(session));
        showStage(loader);
    }

    public void showReviewSubmitForm(Session session, Tour tour) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/WriteReview1.fxml"));
        loader.setController(new WriteReviewsGUIController(session, tour));
        showStage(loader);
    }

    public void showReadReviews(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/ReadReviewsSwimmer1.fxml"));
        loader.setController(new ReadReviewsSwimmerGUIController(session));
        showStage(loader);
    }

    public void showTourReviewsFromBooking(Session session, Tour tour) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/ReadReviewsFromBook1.fxml"));
        loader.setController(new ReadReviewsFromBookGUIController(session, tour));
        showStage(loader);
    }

    public void showOrgPubs(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/OrgPubs1.fxml"));
        loader.setController(new OrgPubsGUIController(session));
        showStage(loader);
    }

    public void showReviewsOrganiser(Session session) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/firstView/ReadReviewsOrg1.fxml"));
        loader.setController(new OrgReadReviewsGUIController(session));
        showStage(loader);
    }

    public void showPersonalArea(Session session) {
        String resource;
        if(session.isOrganiser()) {
            resource = "/firstView/OrganiserPersonalArea1.fxml";
        } else {
            resource = "/firstView/SwimmerPersonalArea1.fxml";
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));

        if(session.isOrganiser()) {
            loader.setController(new OrgPersonalAreaGUIController(session));
        } else {
            loader.setController(new SwimmerPersonalAreaGUIController(session));
        }

        showStage(loader);
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
