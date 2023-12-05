package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public static boolean validate(LoginBean bean) {
        boolean status = false;
        try {
            Connection con = ConnectionProvider.getCon();
            String query = "SELECT * FROM user432 WHERE email = ? AND pass = ?";
            
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, bean.getEmail());
                ps.setString(2, bean.getPass());
                
                try (ResultSet rs = ps.executeQuery()) {
                    status = rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  
        }
        return status;
    }
}
