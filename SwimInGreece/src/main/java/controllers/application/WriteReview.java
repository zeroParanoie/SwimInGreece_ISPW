package controllers.application;

import engClasses.DAO.BookingsDAO;
import engClasses.DAO.ReviewsDAO;
import engClasses.beans.login.LoggedUserBean;
import engClasses.beans.reviews.BookingBean;
import engClasses.beans.reviews.FetchReviewsBean;
import engClasses.beans.reviews.ReviewBean;
import model.Review;

import java.util.List;

public class WriteReview {
    public BookingBean getBookings(LoggedUserBean loggedUserBean) {
        BookingBean bookingBean = new BookingBean();
        bookingBean.setBookings(BookingsDAO.getBookings(loggedUserBean.getUsr()));
        return bookingBean;
    }

    public void addReview(ReviewBean reviewBean) {
        ReviewsDAO.insertReview(reviewBean.getBody(), reviewBean.getRating(), reviewBean.getSwimmer(), reviewBean.getTourName());
    }

    public FetchReviewsBean getReviews(LoggedUserBean loggedUserBean) {
           FetchReviewsBean fetchReviewsBean = new FetchReviewsBean();
           List<Review> reviews = ReviewsDAO.getReviews(loggedUserBean.getUsr());
           fetchReviewsBean.setReviews(reviews);

           return fetchReviewsBean;
    }

    public FetchReviewsBean getReviews(String tourName) {
        FetchReviewsBean fetchReviewsBean = new FetchReviewsBean();
        List<Review> reviews = ReviewsDAO.getReviewsFromTourName(tourName);

        fetchReviewsBean.setReviews(reviews);
        return fetchReviewsBean;
    }

    public float getRatingPercentage(int rating, FetchReviewsBean fetchReviewsBean) {
        float retVal = 0;

        for(Review review : fetchReviewsBean.getReviews()) {
            if(review.getRating() == rating) {
                retVal += 1;
            }
        }

        return retVal/fetchReviewsBean.getReviews().size();
    }
}
