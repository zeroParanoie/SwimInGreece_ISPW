package engClasses.DAO;

import engClasses.beans.searchTrips.TourBean;
import engClasses.query.ReviewsQuery;
import misc.Connect;
import misc.Facade;
import model.Review;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewsDAO {
    private ReviewsDAO() {}

    public static void insertReview(String body, int rating, String swimmer, String tourName) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();

            ReviewsQuery.insertReview(stmt, body, swimmer, rating, tourName);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Review> getReviews(String username) {
        Statement stmt = null;
        Connection conn = null;
        List<Review> reviews = new ArrayList<Review>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = ReviewsQuery.getReviewsFromBooking(stmt, username);
            while(rs.next()) {
                String body = rs.getString("Body");
                int rating = rs.getInt("Rating");
                String tour = rs.getString("Tour");
                Review review = new Review(body, Facade.getInstance().getSwimmerFromFacade(username), rating, Facade.getInstance().getTourFromFacade(tour));
                review.setTourName();
                reviews.add(review);
            }
            return reviews;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Review> getReviewsFromTourName(String tourName) {
        Statement stmt = null;
        Connection conn = null;
        List<Review> reviews = new ArrayList<Review>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();

            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = ReviewsQuery.getReviewsFromTourName(stmt, tourName);
            while(rs.next()) {
                String body = rs.getString("Body");
                int rating = rs.getInt("Rating");
                String user = rs.getString("Username");
                Review review = new Review(body, Facade.getInstance().getSwimmerFromFacade(user), rating, Facade.getInstance().getTourFromFacade(tourName));
                review.setTourName();
                review.setSwimmerName();
                reviews.add(review);
            }
            return reviews;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
