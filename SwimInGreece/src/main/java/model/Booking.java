package model;

public class Booking {
    private Tour tour;
    private Organiser organiser;
    private Swimmer swimmer;
    private String date;

    private String tourName;

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    public void setSwimmer(Swimmer swimmer) {
        this.swimmer = swimmer;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTourName() {
        this.tourName = this.tour.getName();
    }

    public Tour getTour() {
        return tour;
    }

    public Organiser getOrganiser() {
        return organiser;
    }

    public Swimmer getSwimmer() {
        return swimmer;
    }

    public String getDate() {
        return date;
    }

    public String getTourName() {
        return tourName;
    }
}
