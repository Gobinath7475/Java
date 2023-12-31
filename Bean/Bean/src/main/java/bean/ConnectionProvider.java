package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static bean.Provider.*;

public class ConnectionProvider {
    private static Connection con = null;

    static {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return con;
    }
}
