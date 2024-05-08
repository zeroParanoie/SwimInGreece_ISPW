package engClasses.DAO;

import engClasses.query.LoginQuery;
import misc.Connect;
import model.Swimmer;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SwimmerDAO {
    private SwimmerDAO() {}

    public static Swimmer selectSwimmer(String usr, String pw) {
        User swimmer;
        Statement stmt = null;
        Connection conn = null;
        String fullName = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.swimmerLogin(stmt, usr, pw);
            if(!rs.first()) {
                //data exception
            }

            fullName = rs.getString("Fullname");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Swimmer(usr, fullName);
    }

    public static void addSwimmer(Swimmer swimmer, String pw) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.swimmerLogin(stmt, swimmer.getUsername());
            if(rs.first()) {
                //username already in use
            } else {
                LoginQuery.swimmerSignIn(stmt, swimmer, pw);
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Swimmer selectSwimmer(String usr) {
        Statement stmt = null;
        Connection conn = null;
        Swimmer swimmer = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.swimmerLogin(stmt, usr);
            if(!rs.first()) {
                //no user found
            }

            rs.next();
            String fullName = rs.getString("Fullname");
            return new Swimmer(usr, fullName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
