package com.KGiSL.MavenProject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class preparedstmt {

    public static void main(String[] args) throws SQLException {
        select();
        insert();
        update();
        delete();
        multiinsert();
    }

    public static void select() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String str = "select  USER_ID , USERNAME , PASSWORD from USERS WHERE USERNAME LIKE  ? AND USER_ID = ? ";

        PreparedStatement Stmt = con.prepareStatement(str);

        Stmt.setString(1, "J%");
        Stmt.setInt(2, 6);

        ResultSet R = Stmt.executeQuery();

        int rowcount = 0;

        while (R.next()) {
            String USER_ID = R.getString("user_id");
            String USERNAME = R.getString("USERNAME");
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

        String sqlinsert = "insert into users values ( ? , ? , ? , ? , ? , ? , ?)";

        PreparedStatement Stmt = con.prepareStatement(sqlinsert);

        Stmt.setInt(1, 14);
        Stmt.setString(2, "SCOTT2");
        Stmt.setString(3, "scu@123");
        Stmt.setString(4, "scu@gmail.com");
        Stmt.setString(5, "SCOTT2");
        Stmt.setString(6, "S");
        Stmt.setString(7, "COACH");

        int result = Stmt.executeUpdate();
        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void update() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String sqlupdate = "Update users set username = ? WHERE USER_ID = ? ";

        PreparedStatement Stmt = con.prepareStatement(sqlupdate);

        Stmt.setString(1, "LARA");
        Stmt.setInt(2, 9);

        int result = Stmt.executeUpdate();

        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void delete() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");

        String sqldelete = "delete from users where user_id= ?";

        PreparedStatement Stmt = con.prepareStatement(sqldelete);

        Stmt.setInt(1, 14);

        int result = Stmt.executeUpdate();

        System.out.println(result);

        con.close();
        Stmt.close();
    }

    public static void multiinsert() throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Gobinath T?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "");
        
        String stinsert = "INSERT INTO users (user_id, username, password, email, first_name, last_name, user_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
       
        PreparedStatement st = con.prepareStatement(stinsert);
        st.setInt(1, 17);
        st.setString(2, "Andrew1");
        st.setString(3, "andrew@123");
        st.setString(4, "andrew@gmail.com");
        st.setString(5, "Andrew");
        st.setString(6, "A");
        st.setString(7, "Coach");
        st.addBatch();

        st.setInt(1, 18);
        st.setString(2, "David1");
        st.setString(3, "david@123");
        st.setString(4, "david@gmail.com");
        st.setString(5, "David");
        st.setString(6, "S");
        st.setString(7, "Coach");
        st.addBatch();

        int[] result = st.executeBatch();
        System.out.println(Arrays.toString(result));
        st.close();
        con.close();
    }

    
}