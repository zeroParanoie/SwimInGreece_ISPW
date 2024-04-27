package controllers.application;

import engClasses.DAO.SwimDAO;
import engClasses.beans.addSwim.BeanNewSwim;

public class AddSwimController {
    public void saveSwim(BeanNewSwim beanNewSwim) {
        SwimDAO.insertSwim(beanNewSwim.getLength());
    }
}
