package engClasses.DAO;

import engClasses.exceptions.NoReviewsFound;
import engClasses.exceptions.NoTripsFound;
import engClasses.query.ReviewsQuery;
import misc.Connect;
import engClasses.pattern.Facade;
import model.Review;
import model.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.VARCHAR;

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

    public static List<Review> getReviews(String username) throws NoReviewsFound, NoTripsFound {
        Statement stmt = null;
        Connection conn = null;
        List<Review> reviews = new ArrayList<Review>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = ReviewsQuery.getReviewsFromBooking(stmt, username);
            if(!rs.first()) {
                throw new NoReviewsFound("no reviews found!");
            }

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

    public static List<Review> getReviewsFromTourName(String tourName) throws NoReviewsFound, NoTripsFound {
        Statement stmt = null;
        Connection conn = null;
        List<Review> reviews = new ArrayList<Review>();

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = ReviewsQuery.getReviewsFromTourName(stmt, tourName);
            if(!rs.first()) {
                throw new NoReviewsFound("no reviews found!");
            }

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

    public static List<Review> getReviewsFromOrg(String organiser) throws NoReviewsFound, NoTripsFound {
        Connection conn = null;
        List<Review> reviews = new ArrayList<Review>();

        try {
            conn = Connect.getInstance().getConnection();

            CallableStatement callableStatement = conn.prepareCall("{call get_org()}");
            ResultSet rs = callableStatement.executeQuery();

            while(rs.next()) {
                String user = rs.getString("Username");
                String body = rs.getString("Body");
                int rating = rs.getInt("Rating");
                String tourName = rs.getString("Name");
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
