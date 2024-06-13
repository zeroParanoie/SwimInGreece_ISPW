package engclasses.pattern;

import engclasses.dao.BookingsDAO;
import engclasses.dao.OrganiserDAO;
import engclasses.dao.SwimmerDAO;
import engclasses.dao.ToursDAO;
import engclasses.exceptions.NoTripsFound;
import model.Booking;
import model.Organiser;
import model.Swimmer;
import model.Tour;

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

    public Tour getTourFromFacade(String tourName) throws NoTripsFound {
        return ToursDAO.getTourFromName(tourName);
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
