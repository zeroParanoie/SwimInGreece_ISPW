package engClasses.query;

import model.Organiser;
import model.Tour;

import java.sql.Statement;

public class TourQuery {
    private TourQuery() {}

    public static int insertSwim(Statement stmt, float length, Tour tour, Organiser organiser) {
        String newStatement;
        String place = tour.getPlace();

        //newStatement = String.format("INSERT INTO swims (Place, Tour, Organiser, Length) VALUES ('%s', '%s', '%s', '%s')", );
        return 0;
    }
}
