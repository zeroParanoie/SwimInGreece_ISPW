package controllers.application;

import engClasses.DAO.BookingsDAO;
import engClasses.DAO.ReviewsDAO;
import engClasses.beans.login.LoggedUserBean;
import engClasses.beans.reviews.BookingBean;
import engClasses.beans.reviews.ReviewBean;
import engClasses.beans.searchTrips.TourBean;
import model.Tour;

public class WriteReview {
    public BookingBean getBookings(LoggedUserBean loggedUserBean) {
        BookingBean bookingBean = new BookingBean();
        bookingBean.setBookings(BookingsDAO.getBookings(loggedUserBean.getUsr()));
        return bookingBean;
    }

    public void addReview(ReviewBean reviewBean) {
        ReviewsDAO.insertReview(reviewBean.getBody(), reviewBean.getRating(), reviewBean.getSwimmer());
    }

    public ReviewBean getReviews(TourBean tourBean) {

    }
}
