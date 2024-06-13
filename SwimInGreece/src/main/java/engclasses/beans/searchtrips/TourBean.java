package engclasses.beans.searchtrips;

import model.Tour;

import java.util.List;

public class TourBean {

    private List<Tour> tours;
    private List<String> orgUsername;

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public void setOrgUsername(List<String> orgUsername) {
        this.orgUsername = orgUsername;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public List<String> getOrgUsername() {
        return orgUsername;
    }
}
