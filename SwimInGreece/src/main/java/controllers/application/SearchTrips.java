package controllers.application;

import engClasses.DAO.ToursDAO;
import engClasses.beans.login.LoggedUserBean;
import engClasses.beans.searchTrips.TourBean;
import model.Tour;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchTrips {
    public TourBean getAllTours() {
        TourBean tourBean = new TourBean();
        tourBean.setTours(ToursDAO.getAllTours());

        return tourBean;
    }

    public TourBean getSelectedTours(String filterString, float maxLength) {
        TourBean tourBean = new TourBean();

        if(filterString.isEmpty() && maxLength == 0) {
            tourBean.setTours(ToursDAO.getAllTours());
        } else if(!filterString.isEmpty() && maxLength == 0) {
            tourBean.setTours(ToursDAO.getFilteredTours(filterString));
        } else if(!filterString.isEmpty() && maxLength > 0) {
            tourBean.setTours(ToursDAO.getFilteredTours(filterString, maxLength));
        } else if(filterString.isEmpty() && maxLength > 0) {
            tourBean.setTours(ToursDAO.getFilteredTours(maxLength));
        }

        return tourBean;
    }

    public void book(String date, Tour tour, LoggedUserBean loggedUserBean) {
        ToursDAO.insertBooking(date, tour.getOrgName(), loggedUserBean.getUsr(), tour.getName());
    }
}
