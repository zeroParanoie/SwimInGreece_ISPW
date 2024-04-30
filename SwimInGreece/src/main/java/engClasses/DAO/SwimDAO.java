package engClasses.DAO;

import misc.Connect;

import java.sql.*;

public class SwimDAO {
    public static void insertSwim(float length, String place, String tour, String organiser) {
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = Connect.getInstance().getConnection();
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            CallableStatement callableStatement = connection.prepareCall(" call insertSwims(?, ?, ?, ?)");
            callableStatement.setFloat(1, length);
            callableStatement.setString(2, place);
            callableStatement.setString(3, tour);
            callableStatement.setString(4, organiser);
            callableStatement.executeUpdate();
            System.out.println("Query swim ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
