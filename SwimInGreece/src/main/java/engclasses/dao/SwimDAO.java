package engclasses.dao;

import misc.Connect;

import java.sql.*;

public class SwimDAO {

    private SwimDAO() {
        throw new IllegalStateException("Utility class");
    }

    public static void insertSwim(float length, String place, String tour, String organiser) {
        Connection connection = null;

        try {
            connection = Connect.getInstance().getConnection();

            CallableStatement callableStatement = connection.prepareCall(" call insertSwims(?, ?, ?, ?)");
            callableStatement.setFloat(1, length);
            callableStatement.setString(2, place);
            callableStatement.setString(3, tour);
            callableStatement.setString(4, organiser);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
