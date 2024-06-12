package controllers.application;

import engClasses.beans.sponsorTour.BeanNewTour;
import engClasses.exceptions.TourAlreadyExistsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SponsorTourControllerTest {

    @Test
    void saveTourAlreadyExists() {
        int flag = 0;

        BeanNewTour beanNewTour = new BeanNewTour();
        beanNewTour.setName("Tour in Crete");
        beanNewTour.setLength(16.0F);
        beanNewTour.setOrganiser("Org1");
        beanNewTour.setPlace("Crete");

        SponsorTourController sponsorTourController = new SponsorTourController();

        try {
            sponsorTourController.saveTour(beanNewTour);
        } catch (TourAlreadyExistsException e) {
            flag = 1;
        }

        assertEquals(1, flag);
    }

    @Test
    void saveTourDifferentOrg() {
        int flag = 0;

        BeanNewTour beanNewTour = new BeanNewTour();
        beanNewTour.setName("Tour in Crete");
        beanNewTour.setLength(16.0F);
        beanNewTour.setOrganiser("Org2");
        beanNewTour.setPlace("Crete");

        SponsorTourController sponsorTourController = new SponsorTourController();

        try {
            sponsorTourController.saveTour(beanNewTour);
        } catch (TourAlreadyExistsException e) {
            flag = 1;
        }

        assertEquals(0, flag);
    }

    @Test
    void saveTourSameOrg() {
        int flag = 0;

        BeanNewTour beanNewTour = new BeanNewTour();
        beanNewTour.setName("Another generic tour");
        beanNewTour.setLength(16.0F);
        beanNewTour.setOrganiser("Org3");
        beanNewTour.setPlace("Naxos");

        BeanNewTour _beanNewTour = new BeanNewTour();
        _beanNewTour.setName("Generic Tour");
        _beanNewTour.setLength(16.0F);
        _beanNewTour.setOrganiser("Org3");
        _beanNewTour.setPlace("Crete");

        SponsorTourController sponsorTourController = new SponsorTourController();

        try {
            sponsorTourController.saveTour(beanNewTour);
            sponsorTourController.saveTour(_beanNewTour);
        } catch (TourAlreadyExistsException e) {
            flag = 1;
        }

        assertEquals(0, flag);
    }
}