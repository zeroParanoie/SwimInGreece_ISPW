package controllers.application;

import engclasses.dao.BookingsDAO;
import engclasses.dao.ReviewsDAO;
import engclasses.beans.login.LoggedUserBean;
import engclasses.beans.reviews.BookingBean;
import engclasses.beans.reviews.FetchReviewsBean;
import engclasses.beans.reviews.ReviewBean;
import engclasses.exceptions.DivisionByZero;
import engclasses.exceptions.NoReviewsFound;
import engclasses.exceptions.NoTripsFound;
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

    public FetchReviewsBean getReviews(LoggedUserBean loggedUserBean) throws NoReviewsFound, NoTripsFound {
           FetchReviewsBean fetchReviewsBean = new FetchReviewsBean();
           List<Review> reviews = ReviewsDAO.getReviews(loggedUserBean.getUsr());
           fetchReviewsBean.setReviews(reviews);

           return fetchReviewsBean;
    }

    public FetchReviewsBean getReviews(String organiser) throws NoReviewsFound, NoTripsFound {
        FetchReviewsBean fetchReviewsBean = new FetchReviewsBean();
        List<Review> reviews = ReviewsDAO.getReviewsFromOrg();

        fetchReviewsBean.setReviews(reviews);
        return fetchReviewsBean;
    }

    public float getRatingPercentage(int rating, FetchReviewsBean fetchReviewsBean) throws DivisionByZero {
        float retVal = 0;

        for(Review review : fetchReviewsBean.getReviews()) {
            if(review.getRating() == rating) {
                retVal += 1;
            }
        }

        if(fetchReviewsBean.getReviews().isEmpty()) {
            throw new DivisionByZero("no reviews!");
        }

        return retVal/fetchReviewsBean.getReviews().size();
    }
}
