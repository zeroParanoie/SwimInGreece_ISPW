package engClasses.DAO;

import engClasses.beans.reviews.BookingBean;
import engClasses.query.BookingsQuery;
import engClasses.query.LoginQuery;
import misc.Connect;
import model.Booking;
import model.Organiser;
import model.Swimmer;
import model.Tour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingsDAO {
    private BookingsDAO() {}

    public static List<Booking> getBookings(String swimmer) {
        List<Booking> bookings = new ArrayList<>();

        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = BookingsQuery.getAllBookings(stmt, swimmer);

            while (rs.next()) {
                Booking booking = new Booking();
                booking.setSwimmer(new Swimmer(swimmer, null));
                booking.setDate(rs.getString("Date"));
                booking.setTour(new Tour(rs.getString("Name"), organiserBuilder(rs.getString("Org")), "", 0, null));
                booking.setOrganiser(null);
                booking.setTourName();

                bookings.add(booking);
            }

            return bookings;
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
}
