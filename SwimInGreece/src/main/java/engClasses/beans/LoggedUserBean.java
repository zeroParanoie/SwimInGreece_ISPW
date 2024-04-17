package engClasses.beans;

import model.Tour;

import java.util.List;

public class LoggedUserBean {
    private String usr;
    private List<Tour> bookedTours;
    private String fullname;

    public String getUsr() {
        return usr;
    }

    public String getFullname() {
        return fullname;
    }

    public List<Tour> getBookedTours() {
        return bookedTours;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setBookedTours(List<Tour> bookedTours) {
        this.bookedTours = bookedTours;
    }


}
