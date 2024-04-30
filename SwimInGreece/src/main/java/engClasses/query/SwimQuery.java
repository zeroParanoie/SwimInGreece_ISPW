package engClasses.query;

import model.Swim;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SwimQuery {
    private SwimQuery() {}

    public static ResultSet findSwims(Statement stmt, String tourName) throws SQLException {
        String sql;
        sql = "SELECT * FROM Swims WHERE Tour = '" + tourName + "';";
        return stmt.executeQuery(sql);
    }
}
