package misc;

import engClasses.DAO.BookingsDAO;
import engClasses.DAO.OrganiserDAO;
import engClasses.DAO.SwimmerDAO;
import engClasses.DAO.ToursDAO;
import model.Booking;
import model.Organiser;
import model.Swimmer;
import model.Tour;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    private static Facade facadeInstance = null;

    private Facade() {}

    public static synchronized Facade getInstance() {
        if (facadeInstance == null) {
            facadeInstance = new Facade();
        }
        return facadeInstance;
    }

    public Tour getTourFromFacade(String tourName) {
        Tour tour = ToursDAO.getTourFromName(tourName);
        return tour;
    }

    public Swimmer getSwimmerFromFacade(String username) {
        Swimmer swimmer = SwimmerDAO.selectSwimmer(username);
        List<Booking> bookings = BookingsDAO.getBookings(username);
        for(Booking booking : bookings) {
            swimmer.addTour(booking);
        }

        return swimmer;
    }

    public Organiser getOrganiserFromFacade(String username) {
        Organiser organiser = OrganiserDAO.getOrganiser(username);
        List<Tour> tourList = ToursDAO.getToursFromOrganiser(username);
        for(Tour tour : tourList) {
            organiser.addTour(tour);
        }

        return organiser;
    }
}
