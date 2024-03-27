package model;

import java.util.ArrayList;
import java.util.List;

public class Organiser extends User {
    private List<Tour> offeredTours;

    public Organiser(String username, String fullName) {
        super(username, fullName);
        this.offeredTours = new ArrayList<>();
    }

    public List<Tour> getOfferedTours() {
        return offeredTours;
    }

    public void addTour(Tour tour) {
        this.offeredTours.add(tour);
    }
}
