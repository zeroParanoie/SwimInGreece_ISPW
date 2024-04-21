package engClasses.DAO;

import misc.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SwimDAO {
    public static void insertSwim(float length) {
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = Connect.getInstance().getConnection();
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
