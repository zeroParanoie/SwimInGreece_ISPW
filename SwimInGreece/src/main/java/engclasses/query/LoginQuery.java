package engclasses.query;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginQuery {
    private LoginQuery() {}

    public static ResultSet swimmerLogin(Statement stmt, String usr, String pw) throws SQLException {
        String sql;
        sql = "SELECT * FROM Swimmers WHERE Username =  '" + usr + "' AND Password = '" + pw + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet swimmerLogin(Statement stmt, String usr) throws SQLException {
        String sql;
        sql = "SELECT * FROM Swimmers WHERE Username =  '" + usr + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet orgLogin(Statement stmt, String usr, String pw) throws SQLException {
        String sql;
        sql = "SELECT * FROM Organisers WHERE Username =  '" + usr + "' AND Password = '" + pw + "';";
        return stmt.executeQuery(sql);
    }

    public static ResultSet orgLogin(Statement stmt, String usr) throws SQLException {
        String sql;
        sql = "SELECT * FROM Organisers WHERE Username =  '" + usr + "';";
        return stmt.executeQuery(sql);
    }

    public static int swimmerSignIn(Statement stmt, User user, String pw) throws SQLException {
        String newStmt;
        String username = user.getUsername();
        String fullname = user.getFullName();

        newStmt = String.format("INSERT INTO Swimmers (Username, Password, Fullname) VALUES ('%s', '%s', '%s')", username, pw, fullname);
        return stmt.executeUpdate(newStmt);
    }

    public static int organiserSignIn(Statement stmt, User user, String pw) throws SQLException {
        String newStmt;
        String username = user.getUsername();
        String fullname = user.getFullName();

        newStmt = String.format("INSERT INTO Organisers (Username, Password, Fullname) VALUES ('%s', '%s', '%s')", username, pw, fullname);
        return stmt.executeUpdate(newStmt);
    }
}
