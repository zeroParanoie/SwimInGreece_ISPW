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

        // this is ok System.out.println(ToursDAO.getAllTours().get(0).getOrganiser().getUsername());
        // this is ok System.out.println(tourBean.getTours().get(0).getOrganiser().getUsername());
        return tourBean;
    }


}
