package com.KGiSL.MavenProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class callablestmt2 {
    public static void main(String[] args) throws SQLException {
        inselect();
        // // callableupdate();
        // callabledelete();
    }

    public static void inselect() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{CALL getallUser1()}";

        CallableStatement Stmt = con.prepareCall(str);

        ResultSet R = Stmt.executeQuery(str);
        int rowcount = 0;

        while (R.next()) {
            String USERNAME = R.getString("USERNAME");
            String USER_ID = R.getString("USER_ID");
            String PASSWORD = R.getString("PASSWORD");
            String EVENT_ID = R.getString("EVENT_ID");

            System.out.println(USER_ID + "   " + USERNAME + "   " + PASSWORD+"  " + EVENT_ID);
            rowcount = rowcount + 1;
        }
        System.out.println("Total row in table : " + rowcount);

        

        con.close();
        Stmt.close();
    }

    public static void callableupdate() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{CALL UPDATEUSER1(5)}";

        CallableStatement Stmt = con.prepareCall(str);

        int result = Stmt.executeUpdate(str);

        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void callabledelete() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{CALL deleteuser1(18)}";

        CallableStatement Stmt = con.prepareCall(str);

        int result = Stmt.executeUpdate(str);

        System.out.println(result);

        con.close();
        Stmt.close();
    }
}
