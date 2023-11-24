package com.KGiSL.MavenProject1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class callablestmt1 {

    public static void main(String[] args) throws SQLException {

        // select();
        // inselect();
        // callableinsert();
        //callabledelete();
        callableupdate();
    }

    public static void select() throws SQLException {
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

            System.out.println(USER_ID + "   " + USERNAME + "   " + PASSWORD);
            rowcount = rowcount + 1;
        }
        System.out.println("Total row in table : " + rowcount);

        con.close();
        Stmt.close();
    }

    public static void callableinsert() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{CALL INSERTUSER()}";

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

        String str = "{CALL DELETEUSER()}";

        CallableStatement Stmt = con.prepareCall(str);

        int result = Stmt.executeUpdate(str);

        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void callableupdate() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "{CALL UPDATEUSER()}";

        CallableStatement Stmt = con.prepareCall(str);

        int result = Stmt.executeUpdate(str);

        System.out.println(result);

        con.close();
        Stmt.close();
    }
}
