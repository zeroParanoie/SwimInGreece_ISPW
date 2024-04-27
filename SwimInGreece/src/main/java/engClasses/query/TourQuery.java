package engClasses.query;

import model.Organiser;
import model.Tour;

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
}
