package controllers.application;

import engClasses.DAO.ToursDAO;
import engClasses.beans.searchTrips.TourBean;
import model.Tour;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchTrips {
    public ArrayList<TourBean> getAllTours() {
        ArrayList<Tour> availableTours = new ArrayList<Tour>();
        ArrayList<TourBean> beans = new ArrayList<TourBean>();
        Iterator iterator = availableTours.iterator();

        availableTours = ToursDAO.getAllTours();

        while(iterator.hasNext()) {
            TourBean tourBean = new TourBean();
            Tour tour = (Tour) iterator.next();

            tourBean.setName(tour.getName());
            tourBean.setOrganiser(tour.getOrganiser().getUsername());
            tourBean.setPlace(tour.getPlace());
            tourBean.setLength(tour.getLength());

            beans.add(tourBean);
        }

        return beans;
    }
}
