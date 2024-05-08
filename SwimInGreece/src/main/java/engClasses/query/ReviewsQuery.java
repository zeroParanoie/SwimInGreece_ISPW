package engClasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReviewsQuery {
    private ReviewsQuery() {}

    public static void insertReview(Statement stmt, String body, String swimmer, int rating, String tourName) throws SQLException {
        String sql;
        sql = "INSERT INTO Reviews (Body, Username, Rating, Tour) VALUES ('" + body + "', '" + swimmer + "', " + rating + ", '" + tourName + "')";
        stmt.executeUpdate(sql);
    }

    public static ResultSet getReviewsFromBooking(Statement stmt, String username) throws SQLException {
        String sql;
        sql = "SELECT * FROM Reviews WHERE Username = '" + username + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet getReviewsFromTourName(Statement stmt, String tourName) throws SQLException {
        String sql;
        sql = "SELECT * FROM Reviews WHERE Tour = '" + tourName + "';";
        return stmt.executeQuery(sql);
    }
}
