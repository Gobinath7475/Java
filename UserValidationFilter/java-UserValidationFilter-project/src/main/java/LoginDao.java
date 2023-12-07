import java.sql.*;
 
public class LoginDao {
    public static boolean validate(String name, String password) {
        boolean status = false;
        try {
            //Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "");
 
            PreparedStatement ps = con.prepareStatement(
                    "select * from uservalidation where username=? and password=?");
            ps.setString(1, name);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            status = rs.next();
 
        } catch (Exception e) {
            System.out.println(e);
        }
       
        return status;
    }
}