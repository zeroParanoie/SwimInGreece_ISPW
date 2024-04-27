package controllers.application;

import engClasses.DAO.ToursDAO;
import engClasses.beans.addSwim.BeanNewSwim;
import engClasses.beans.sponsorTour.BeanNewTour;
import model.Tour;

public class SponsorTourController {
    public void saveTour(BeanNewTour beanNewTour) {
        ToursDAO.insertTour(beanNewTour.getName(), beanNewTour.getOrganiser(), beanNewTour.getLength(), beanNewTour.getPlace());
    }
}
