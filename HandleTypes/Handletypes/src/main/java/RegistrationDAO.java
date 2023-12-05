import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.MysqlDataSource;

public class RegistrationDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private static Connection jdbcConnection;

    public RegistrationDAO() 
    {
        this.jdbcURL = "jdbc:mysql://localhost:3306/Gobinath T";
        this.jdbcUsername = "root";
        this.jdbcPassword = "";
    }

    protected static void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {

            MysqlDataSource d = new MysqlDataSource();
            d.setURL("jdbc:mysql://localhost:3306/Gobinath T");
            d.setUser("root");
            d.setPassword("");
            jdbcConnection = d.getConnection();

        }
    }

    protected static void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public static List<Registration> listAll() throws SQLException {
        List<Registration> listReg = new ArrayList<>();
        String sql = "SELECT * FROM Registration";
        connect();
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int registration_id = resultSet.getInt("registration_id");
            String event_name = resultSet.getString("event_name");
            String athlete_name = resultSet.getString("athlete_name");
            Date registration_date = resultSet.getDate("registration_date");
            Registration registration = new Registration(registration_id, event_name, athlete_name, registration_date);
            listReg.add(registration);
        } 

        resultSet.close();
        statement.close();
        disconnect();
        return listReg;
    }
}
