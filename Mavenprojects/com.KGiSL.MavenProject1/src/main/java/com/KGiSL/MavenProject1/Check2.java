package com.KGiSL.MavenProject1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Check2 {
    public static void main(String args[]) throws SQLException {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        CallableStatement Stmt = con.prepareCall("{CALL getallUser120()}");

        ResultSet result1 = Stmt.executeQuery();

        System.out.println("************************************Contents of the first result1-set************************************");

        while (result1.next()) {
            String userid = result1.getString("user_id");

            String username = result1.getString("username");

            String password = result1.getString("password");

            String email = result1.getString("email");

            String fname = result1.getString("first_name");

            String lname = result1.getString("last_name");

            String usertype = result1.getString("user_type");

            System.out.println(userid + "," + username + "," + password + "," + email + ","

                    + fname + "," + lname + "," + usertype);
        }

        Stmt.getMoreResults();

        System.out.println("(************************************SECOND RESULTSET************************************************************************");

        ResultSet result2 = Stmt.getResultSet();

        while (result2.next()) {

            String EVENT_ID = result2.getString("EVENT_ID");

            String EVENT_NAME = result2.getString("EVENT_NAME");

            String EVENT_DATE = result2.getString("EVENT_DATE");

            String LOCATION = result2.getString("LOCATION");

            String DESCRIPTION = result2.getString("DESCRIPTION");

            System.out.println(EVENT_ID + "  " + EVENT_NAME + "  " + EVENT_DATE + "  " + LOCATION + "  " + DESCRIPTION);
        }

        Stmt.getMoreResults();

        ResultSet result3 = Stmt.getResultSet();

        System.out.println("************************************THIRD RESULTSET**************************************************************");

        while (result3.next()) {

            String ADMIN_ID = result3.getString("ADMIN_ID");

            String USER_ID = result3.getString("USER_ID");

            String ADMIN_LEVEL = result3.getString("ADMIN_LEVEL");

            System.out.println(ADMIN_ID + "  " + USER_ID + "  " + ADMIN_LEVEL );
        }
    }
}