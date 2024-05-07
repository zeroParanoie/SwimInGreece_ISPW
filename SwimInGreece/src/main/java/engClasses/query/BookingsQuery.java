package engClasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookingsQuery {
    private BookingsQuery() {}

    public static ResultSet getAllBookings(Statement stmt, String swimmer) throws SQLException {
        String sql;
        sql = "SELECT * FROM Bookings WHERE Swimmer = '" + swimmer + "';";
        return stmt.executeQuery(sql);
    }
}
