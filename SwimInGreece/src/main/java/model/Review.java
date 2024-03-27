package model;

public class Review {
    private String body;
    private Swimmer swimmer;
    private int rating;

    public Review(String body, Swimmer swimmer, int rating) {
        this.body = body;
        this.swimmer = swimmer;
        this.rating = rating;
    }

    public void setBody(String body) {
        this.body = body;
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
}
