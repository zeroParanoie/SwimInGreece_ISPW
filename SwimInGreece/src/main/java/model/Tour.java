package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tour {
    private String startDate;
    private String endDate;
    private String name;
    private List<Swim> allSwims = new ArrayList<>();

    public Tour(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public List<Swim> getAllSwims() {
        return allSwims;
    }

    public String getName() {
        return name;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void addSwim(Swim swim) {
        this.allSwims.add(swim);
    }

    public void setName(String name) {
        this.name = name;
    }
}
