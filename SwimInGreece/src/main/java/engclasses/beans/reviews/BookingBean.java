package engclasses.beans.reviews;

import model.Booking;

import java.util.List;

public class BookingBean {
    private List<Booking> bookings;

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
