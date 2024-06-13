package engclasses.dao;

import engclasses.exceptions.AlreadyInUseException;
import engclasses.exceptions.LoginFromDBException;
import engclasses.query.LoginQuery;
import misc.Connect;
import model.Organiser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrganiserDAO {
    private OrganiserDAO() {}

    public static Organiser organiserLogin(String usr, String pw) throws LoginFromDBException {
        Statement stmt = null;
        Connection conn = null;
        String fullname = null;


        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.orgLogin(stmt, usr, pw);
            if(!rs.first()) {
                throw new LoginFromDBException(0);
            }

            fullname = rs.getString("Fullname");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Organiser(usr, fullname);
    }

    public static void addOrganiser(Organiser organiser, String pw) throws AlreadyInUseException {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.orgLogin(stmt, organiser.getUsername());
            if(rs.first()) {
                throw new AlreadyInUseException("this username is taken!");
            }

            LoginQuery.organiserSignIn(stmt, organiser, pw);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Organiser getOrganiser(String username) {
        Statement stmt = null;
        Connection conn = null;

        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            ResultSet rs = LoginQuery.orgLogin(stmt, username);
            if(rs.first()) {
                // no organiser found
            }

            String fullname = rs.getString("Fullname");
            return new Organiser(username, fullname);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}