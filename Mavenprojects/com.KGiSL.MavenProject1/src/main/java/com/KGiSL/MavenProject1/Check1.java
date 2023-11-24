package com.KGiSL.MavenProject1;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

public class Check1 {

    public static void main(String args[]) throws SQLException {

        Connection con = DriverManager.getConnection(

                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",

                "root", "");

        CallableStatement stmt = con.prepareCall("{CALL SELECTUSERSS()}");

        boolean hasResults = stmt.execute();

        do {

            if (hasResults) {

                ResultSet rs = stmt.getResultSet();

                if (rs != null) {

                    if (rs.getMetaData().getColumnCount() == 7) {

                        System.out.println("Contents of the first result set");

                        while (rs.next()) {

                            String userid = rs.getString("user_id");

                            String username = rs.getString("username");

                            String password = rs.getString("password");

                            String email = rs.getString("email");

                            String fname = rs.getString("first_name");

                            String lname = rs.getString("last_name");

                            String usertype = rs.getString("user_type");

                            System.out.println(userid + "," + username + "," + password + "," + email + ","

                                    + fname + "," + lname + "," + usertype);
                        }

                    } else if (rs.getMetaData().getColumnCount() == 5) {

                        System.out.println("Contents of the second result set");

                        while (rs.next()) {

                            String event_id = rs.getString("EVENT_ID");

                            String event_name = rs.getString("EVENT_NAME");

                            String event_date = rs.getString("EVENT_DATE");

                            String location = rs.getString("LOCATION");

                            String description = rs.getString("DESCRIPTION");

                            System.out.println(event_id + "  " + event_name + "  " + event_date + "  " + location + "  "
                                    + description);
                        }

                    } else if (rs.getMetaData().getColumnCount() == 5) {

                        System.out.println("Contents of the third result set");

                        while (rs.next()) {

                            String coach_id = rs.getString("COACH_ID");

                            String user_id = rs.getString("USER_ID");

                            String speciality = rs.getString("SPECIALITY");

                            String bio = rs.getString("BIO");

                            String certifications = rs.getString("CERTIFICATIONS");

                            System.out.println(
                                coach_id + "  " + user_id + "  " + speciality + "  " + bio + "  " + certifications);
                        }
                    }
                    rs.close();
                }
            }
            hasResults = stmt.getMoreResults();
        } while (hasResults);
        stmt.close();
        con.close();
    }
}