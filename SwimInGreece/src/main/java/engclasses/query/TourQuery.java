package engclasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TourQuery {
    private TourQuery() {}

    public static void insertTour(Statement stmt, float length, String tourName, String organiser, String place) throws SQLException {
        String newStatement;

        newStatement = String.format("INSERT INTO Tours (Name, Organiser, TotalLength, Place) VALUES ('%s', '%s', %s, '%s')", tourName, organiser, length, place);
        stmt.executeUpdate(newStatement);
    }

    public static ResultSet selectTour(Statement stmt, String tourName, String organiser) throws SQLException {
        String sql;
        sql = "SELECT * FROM Tours WHERE Name = '" + tourName + "' AND Organiser = '" + organiser + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet getAllTours(Statement stmt) throws SQLException {
        String sql;
        sql = "SELECT * FROM Tours;";
        return stmt.executeQuery(sql);
    }

    public static ResultSet searchTour(Statement stmt, String tourName) throws SQLException {
        String sql;
        sql = "SELECT * FROM Tours WHERE Name LIKE '%" + tourName +"%';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet searchTour(Statement stmt, String tourName, float maxLength) throws SQLException {
        String sql;
        sql = "SELECT * FROM Tours WHERE Name LIKE '%" + tourName + "%' AND TotalLength <= " + maxLength + ";";
        return stmt.executeQuery(sql);
    }

    public static ResultSet searchTour(Statement stmt, float maxLength) throws SQLException {
        String sql;
        sql = "SELECT * FROM Tours WHERE TotalLength <= " + maxLength + ";";
        return stmt.executeQuery(sql);
    }

    public static void insertBooking(Statement stmt, String organiser, String swimmer, String date, String tourName) throws SQLException {
        String newStatement;
        newStatement = String.format("INSERT INTO Bookings (Swimmer, Name, Org, Date) VALUES ('%s', '%s', '%s', '%s')", swimmer, tourName, organiser, date);
        stmt.executeUpdate(newStatement);
    }

    public static ResultSet selectTour(Statement stmt, String organiser) throws SQLException {
        String sql;
        sql = "SELECT * FROM Tours WHERE Organiser = '" + organiser + "';";
        return stmt.executeQuery(sql);
    }
}
