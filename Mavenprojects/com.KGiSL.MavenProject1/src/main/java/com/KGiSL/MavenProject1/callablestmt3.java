package com.KGiSL.MavenProject1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class callablestmt3 {
    public static void main(String[] args) throws SQLException {
        //outselect();
        inout();
    }

    public static void outselect() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{ CALL getuser123( ? , ? ) }";

        CallableStatement Stmt = con.prepareCall(str);

        Stmt.setInt(1, 5);

        Stmt.registerOutParameter(2, Types.INTEGER);

        Stmt.executeQuery();

        int total = Stmt.getInt(2);
        System.out.println(total);

        con.close();
        Stmt.close();
    }

    public static void inout() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{ SET @counter = 1; CALL GetUser(@counter,1); CALL GetUser(@counter,1);  CALL GetUser(@counter,5); }" ;

        CallableStatement Stmt = con.prepareCall(str);

        ResultSet R = Stmt.executeQuery(str);

        int rowcount = 0;

        while (R.next()) {
            String registration_id = R.getString("registration_id");
            String event_name = R.getString("event_name");
            String athlete_name = R.getString("athlete_name");
            String registration_date = R.getString("registration_date");
            // String PASSWORD = R.getString("PASSWORD");

            System.out.println( registration_id + "   " + event_name + "   "+ athlete_name + "  " + registration_date );

            rowcount = rowcount + 1;
        }
        System.out.println("Total row in table : " + rowcount);
    }
}
