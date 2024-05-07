package engClasses.beans.reviews;

import model.Review;

import java.util.List;

public class FetchReviewsBean {
    private List<Review> reviews;

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
