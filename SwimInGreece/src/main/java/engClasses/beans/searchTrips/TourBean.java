package engClasses.beans.searchTrips;

import model.Tour;

import java.util.List;

public class TourBean {
    /* private String name;
    private String organiser;
    private String place;
    private float length;

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public String getOrganiser() {
        return organiser;
    }

    public String getPlace() {
        return place;
    }

    public float getLength() {
        return length;
    }

     */

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
