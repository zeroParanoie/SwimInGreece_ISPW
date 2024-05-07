package engClasses.DAO;

import engClasses.beans.searchTrips.TourBean;
import engClasses.query.ReviewsQuery;
import misc.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReviewsDAO {
    private ReviewsDAO() {}

    public static void insertReview(String body, int rating, String swimmer) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();

            ReviewsQuery.insertReview(stmt, body, swimmer, rating);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getReviews(TourBean tourBean) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();

            ResultSet rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
