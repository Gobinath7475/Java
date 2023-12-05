package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDao {

    public static int register(User u) {
        int status = 0;
        try {
            Connection con = ConnectionProvider.getCon();
            PreparedStatement ps = con.prepareStatement("INSERT INTO user432 (NAME, EMAIL, PASS) VALUES (?, ?, ?)");
            ps.setString(1, u.getUname());
            ps.setString(2, u.getUemail());
            ps.setString(3, u.getUpass());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}