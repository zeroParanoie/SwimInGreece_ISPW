package model;

public class Review {
    private String body;
    private Swimmer swimmer;
    private String swimmerName;
    private Tour tour;
    private String tourName;
    private int rating;

    public Review(String body, Swimmer swimmer, int rating, Tour tour) {
        this.body = body;
        this.swimmer = swimmer;
        this.rating = rating;
        this.tour = tour;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void setSwimmerName() {
        this.swimmerName = swimmer.getUsername();
    }

    public void setTourName() {
        this.tourName = this.tour.getName();
    }

    public void setSwimmer(Swimmer swimmer) {
        this.swimmer = swimmer;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public Swimmer getSwimmer() {
        return swimmer;
    }

    public int getRating() {
        return rating;
    }

    public Tour getTour() {
        return tour;
    }

    public String getTourName() {
        return tourName;
    }

    public String getSwimmerName() {
        return swimmerName;
    }
}
