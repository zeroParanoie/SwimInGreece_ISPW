package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tour {
    private String name;
    private Organiser organiser;

    private String orgName;
    private String place;
    private float length;

    private List<Swim> swims;

    public Tour(String name, Organiser organiser, String place, float length, List<Swim> swims) {
        this.name = name;
        this.organiser = organiser;
        this.place = place;
        this.length = length;
        this.swims = swims;
        this.orgName = organiser.getUsername();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganiser(Organiser organiser) {
        this.organiser = organiser;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setSwims(List<Swim> swims) {
        this.swims = swims;
    }

    public String getName() {
        return name;
    }

    public Organiser getOrganiser() {
        return organiser;
    }

    public String getPlace() {
        return place;
    }

    public float getLength() {
        return length;
    }

    public List<Swim> getSwims() {
        return swims;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = organiser.getUsername();
    }
}
