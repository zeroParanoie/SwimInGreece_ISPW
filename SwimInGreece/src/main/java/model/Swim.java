package model;

public class Swim {
    private String place;
    private float length;

    public Swim(String place, float length) {
        this.place = place;
        this.length = length;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getPlace() {
        return place;
    }

    public float getLength() {
        return length;
    }
}
