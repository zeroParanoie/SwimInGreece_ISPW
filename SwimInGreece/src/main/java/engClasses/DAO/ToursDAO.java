package engClasses.DAO;

import engClasses.query.TourQuery;
import misc.Connect;
import model.Organiser;
import model.Swim;
import model.Tour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ToursDAO {
    private ToursDAO() {
    }

    public static void insertTour(String tourName, String organiser, float length, String place) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = TourQuery.selectTour(stmt, tourName, organiser);
            if(rs.first()) {
                //already exists
            } else {
                TourQuery.insertTour(stmt, length, tourName, organiser, place);
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}