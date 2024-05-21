package engClasses.DAO;

import engClasses.exceptions.NoTripsFound;
import engClasses.exceptions.TourAlreadyExistsException;
import engClasses.query.LoginQuery;
import engClasses.query.SwimQuery;
import engClasses.query.TourQuery;
import misc.Connect;
import engClasses.pattern.Facade;
import model.Organiser;
import model.Swim;
import model.Tour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToursDAO {
    private ToursDAO() {
    }

    public static void insertTour(String tourName, String organiser, float length, String place) throws TourAlreadyExistsException {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.selectTour(stmt, tourName, organiser);
            if(rs.first()) {
                throw new TourAlreadyExistsException("tour already exists!");
            } else {
                TourQuery.insertTour(stmt, length, tourName, organiser, place);
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Tour> getAllTours() throws NoTripsFound {
        Statement stmt = null;
        Connection conn = null;
        ArrayList<Tour> outputTours = new ArrayList<Tour>();


        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.getAllTours(stmt);
            if(!rs.first()) {
                throw new NoTripsFound("no trips in the db!");
            }

            while(rs.next()) {
                String name = rs.getString("Name");
                String organiser = rs.getString("Organiser");
                String place = rs.getString("Place");
                float length = rs.getFloat("TotalLength");

                Tour tour = new Tour(name, organiserBuilder(organiser), place, length, findSwims(name));
                outputTours.add(tour);
            }

            return outputTours;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Tour> getFilteredTours(String filterString) throws NoTripsFound {
        Statement stmt = null;
        Connection conn = null;
        ArrayList<Tour> outputTours = new ArrayList<Tour>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.searchTour(stmt, filterString);
            if(!rs.first()) {
                throw new NoTripsFound("no trips found for these constraints!");
            }

            while (rs.next()) {
                String name = rs.getString("Name");
                String organiser = rs.getString("Organiser");
                String place = rs.getString("Place");
                float length = rs.getFloat("TotalLength");

                Tour tour = new Tour(name, organiserBuilder(organiser), place, length, findSwims(name));
                outputTours.add(tour);
            }

            return outputTours;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Tour> getFilteredTours(String filterString, float maxLength) throws NoTripsFound {
        Statement stmt = null;
        Connection conn = null;
        ArrayList<Tour> outputTours = new ArrayList<Tour>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.searchTour(stmt, filterString, maxLength);
            if(!rs.first()) {
                throw new NoTripsFound("no trips found for these constraints!");
            }

            while (rs.next()) {
                String name = rs.getString("Name");
                String organiser = rs.getString("Organiser");
                String place = rs.getString("Place");
                float length = rs.getFloat("TotalLength");

                Tour tour = new Tour(name, organiserBuilder(organiser), place, length, findSwims(name));
                outputTours.add(tour);
            }

            return outputTours;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Tour> getFilteredTours(float maxLength) throws NoTripsFound {
        Statement stmt = null;
        Connection conn = null;
        ArrayList<Tour> outputTours = new ArrayList<Tour>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.searchTour(stmt, maxLength);
            if(!rs.first()) {
                throw new NoTripsFound("no trips found for these constraints!");
            }

            while (rs.next()) {
                String name = rs.getString("Name");
                String organiser = rs.getString("Organiser");
                String place = rs.getString("Place");
                float length = rs.getFloat("TotalLength");

                Tour tour = new Tour(name, organiserBuilder(organiser), place, length, findSwims(name));
                outputTours.add(tour);
            }

            return outputTours;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void insertBooking(String date, String organiser, String swimmer, String tourName) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            TourQuery.insertBooking(stmt, organiser, swimmer, date, tourName);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Tour> getToursFromOrganiser(String organiser) {
        Statement stmt = null;
        Connection conn = null;
        List<Tour> tours = new ArrayList<>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.selectTour(stmt, organiser);

            while(rs.next()) {
                String tourName = rs.getString("Name");
                String place = rs.getString("Place");
                float length = rs.getFloat("TotalLength");

                Tour tour = new Tour(tourName, organiserBuilder(organiser), place, length, findSwims(tourName));
                tours.add(tour);
            }
            return tours;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Tour getTourFromName(String tourName) throws NoTripsFound {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.searchTour(stmt, tourName);

            if(!rs.first()) {
                throw new NoTripsFound("no trips found under this name!");
            }

            String organiser = rs.getString("Organiser");
            String place = rs.getString("Place");
            float length = rs.getFloat("TotalLength");
            return new Tour(tourName, Facade.getInstance().getOrganiserFromFacade(organiser), place, length, findSwims(tourName));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Organiser organiserBuilder(String username) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.orgLogin(stmt, username);
            rs.next();

            String usr = rs.getString("Username");
            String fullname = rs.getString("Fullname");

            return new Organiser(usr, fullname);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ArrayList<Swim> findSwims(String tourName) {
        Statement stmt = null;
        Connection conn = null;
        ArrayList<Swim> swimArrayList = new ArrayList<Swim>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = SwimQuery.findSwims(stmt, tourName);

            while(rs.next()) {
                float length = rs.getFloat("Length");
                Swim swim = new Swim(length);
                swimArrayList.add(swim);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return swimArrayList;
    }
}