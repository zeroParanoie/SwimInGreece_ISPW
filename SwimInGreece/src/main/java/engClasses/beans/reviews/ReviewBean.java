package engClasses.beans.reviews;

public class ReviewBean {
    private String body;
    private String swimmer;
    private int rating;

    public void setBody(String body) {
        this.body = body;
    }

    public void setSwimmer(String swimmer) {
        this.swimmer = swimmer;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getBody() {
        return body;
    }

    public String getSwimmer() {
        return swimmer;
    }

    public int getRating() {
        return rating;
    }
}
