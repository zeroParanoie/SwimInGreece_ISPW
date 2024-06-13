package controllers.application;

import engclasses.dao.SwimDAO;
import engclasses.dao.ToursDAO;
import engclasses.beans.addswim.BeanNewSwim;
import engclasses.beans.sponsortour.BeanNewTour;
import engclasses.exceptions.TourAlreadyExistsException;

public class SponsorTourController {
    public void saveTour(BeanNewTour beanNewTour) throws TourAlreadyExistsException {
        ToursDAO.insertTour(beanNewTour.getName(), beanNewTour.getOrganiser(), beanNewTour.getLength(), beanNewTour.getPlace());
    }

    public void saveSwim(BeanNewSwim beanNewSwim, BeanNewTour beanNewTour) {
        SwimDAO.insertSwim(beanNewSwim.getLength(), beanNewTour.getPlace(), beanNewTour.getName(), beanNewTour.getOrganiser());
    }
}
