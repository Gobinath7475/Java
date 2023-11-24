package com.KGiSL.MavenProject1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbcconn {

    public static void main(String[] args) throws SQLException {
        // insert();
        // update();
        // delete();
        // select();
        sqljoin();
    }

    public static void select() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement Stmt = con.createStatement();

        String str = "select USERNAME , USER_ID , PASSWORD from USERS";

        ResultSet R = Stmt.executeQuery(str);
        int rowcount = 0;

        while (R.next()) {
            String USERNAME = R.getString("USERNAME");
            String USER_ID = R.getString("user_id");
            String PASSWORD = R.getString("PASSWORD");

            System.out.println(USER_ID + "   " + USERNAME + "   " + PASSWORD);
            rowcount = rowcount + 1;
        }
        System.out.println("Total row in table : " + rowcount);

        con.close();
        Stmt.close();
    }

    public static void insert() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement Stmt = con.createStatement();

        String sqlinsert = "insert into users values"

                + "( 13 , 'SCOTT1' , 'abc@12345' , 'abc@gmail.com' , 'SCOTT' , 'S' , 'COACH'),"
                + "( 14 , 'TIGER1' , 'tig@12345' , 'tig@gmail.com' , 'TIGER' , 'T' , 'ATHLETE')";

        int result = Stmt.executeUpdate(sqlinsert);
        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void update() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement Stmt = con.createStatement();

        String sqlupdate = "Update users set username = 'WILLIAM' WHERE USER_ID = 8";

        int result = Stmt.executeUpdate(sqlupdate);

        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void delete() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement Stmt = con.createStatement();

        String sqldelete = "delete from users where username = 'niva' ";

        int result = Stmt.executeUpdate(sqldelete);

        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void sqljoin() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        Statement Stmt = con.createStatement();

        String str = "SELECT er.registration_id,es.event_name,us.username AS athlete_name,er.registration_date FROM event_registrations er\r\n" + //
                "JOIN event_details es ON er.event_id=es.event_id\r\n" + //
                "JOIN athletes_table ath ON er.athlete_id=ath.athlete_id\r\n" + //
                "JOIN users us ON ath.user_id=us.user_id ";

        ResultSet R = Stmt.executeQuery(str);
        int rowcount = 0;

        while (R.next()) {
            String registration_id = R.getString("registration_id");
            String event_name = R.getString("event_name");
            String athlete_name = R.getString("athlete_name");
            String registration_date = R.getString("registration_date");
            // String PASSWORD = R.getString("PASSWORD");

            System.out.println(registration_id + "   " + event_name + "   "+ athlete_name + "  " +registration_date );

            rowcount = rowcount + 1;
        }
        System.out.println("Total row in table : " + rowcount);

        con.close();
        Stmt.close();
    }
}