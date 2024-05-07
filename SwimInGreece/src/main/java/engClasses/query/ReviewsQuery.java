package engClasses.query;

import java.sql.SQLException;
import java.sql.Statement;

public class ReviewsQuery {
    private ReviewsQuery() {}

    public static void insertReview(Statement stmt, String body, String swimmer, int rating) throws SQLException {
        String sql;
        sql = "INSERT INTO Reviews (Body, Username, Rating) VALUES ('" + body + "', '" + swimmer + "', " + rating + ");";
        stmt.executeUpdate(sql);
    }

    public static void getReviews(Statement stmt, String tourName, String organiser) {
        String sql;
        // sql = "SELECT * FROM Reviews WHERE "
    }
}
