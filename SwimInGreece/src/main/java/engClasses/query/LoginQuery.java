package engClasses.query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginQuery {
    private LoginQuery() {}

    public static ResultSet swimmerLogin(Statement stmt, String usr, String pw) throws SQLException {
        String sql;
        sql = "SELECT * FROM swimmers WHERE Username =  '" + usr + "' AND Password = '" + pw + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet swimmerLogin(Statement stmt, String usr) throws SQLException {
        String sql;
        sql = "SELECT * FROM swimmers WHERE Username =  '" + usr + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet orgLogin(Statement stmt, String usr, String pw) throws SQLException {
        String sql;
        sql = "SELECT * FROM organisers WHERE Username =  '" + usr + "' AND Password = '" + pw + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet orgLogin(Statement stmt, String usr) throws SQLException {
        String sql;
        sql = "SELECT * FROM organisers WHERE Username =  '" + usr + "';";
        return stmt.executeQuery(sql);
    }
}
