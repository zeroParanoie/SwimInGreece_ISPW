package model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends User {
    private List<Booking> bookedTours;

    public Swimmer(String username, String fullName) {
        super(username, fullName);
        this.bookedTours = new ArrayList<>();
    }

    public List<Booking> getBookedTours() {
        return bookedTours;
    }

    public void addTour(Booking booking) {
        this.bookedTours.add(booking);
    }
}
