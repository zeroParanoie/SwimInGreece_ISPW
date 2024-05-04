package controllers.application;

import engClasses.DAO.ToursDAO;
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


}
