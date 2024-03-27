package model;

import java.util.ArrayList;
import java.util.List;

public class Swimmer extends User {
    private List<Tour> bookedTours;

    public Swimmer(String username, String fullName) {
        super(username, fullName);
        this.bookedTours = new ArrayList<>();
    }

    public List<Tour> getBookedTours() {
        return bookedTours;
    }

    public void addTour(Tour tour) {
        this.bookedTours.add(tour);
    }
}
