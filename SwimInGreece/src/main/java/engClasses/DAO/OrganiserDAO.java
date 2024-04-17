package engClasses.DAO;

import engClasses.query.LoginQuery;
import misc.Connect;
import model.Organiser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrganiserDAO {
    private OrganiserDAO() {}

    public static Organiser organiserLogin(String usr, String pw) {
        Organiser organiser;
        Statement stmt = null;
        Connection conn = null;
        String fullname = null;


        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.orgLogin(stmt, usr, pw);
            if(!rs.first()) {
                //data exception
            }

            fullname = rs.getString("Fullname");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Organiser(usr, fullname);
    }

    public static void addOrganiser(Organiser organiser, String pw) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.orgLogin(stmt, organiser.getUsername());
            if(rs.first()) {
                //username already in use
            }

            LoginQuery.organiserSignIn(stmt, organiser, pw);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
