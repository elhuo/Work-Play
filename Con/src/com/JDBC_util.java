package com;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBC_util {
    final String URL="jdbc:mysql://localhost:3306/temp";
    final String UserName="root";
    final String PassWord="rootroot";
    public static void add(String sql_path,String account,String password,String sql) throws Exception{
        Connection conn = null;
        conn = DriverManager.getConnection(sql_path,account,password);
        Statement stmt = conn.createStatement();
        ResultSet rst =stmt.executeQuery(sql);
    }

    public static void delete(String sql_path,String account,String password,String sql) throws Exception{
        Connection conn = null;
        conn = DriverManager.getConnection(sql_path,account,password);
        Statement stmt = conn.createStatement();
        ResultSet rst =stmt.executeQuery(sql);
    }

    public static void revise(String sql_path,String account,String password,String sql) throws Exception{
        Connection conn = null;
        conn = DriverManager.getConnection(sql_path,account,password);
        Statement stmt = conn.createStatement();
        ResultSet rst =stmt.executeQuery(sql);
    }

    public static void inquire(String sql_path,String account,String password,String sql) throws Exception{
        Connection conn = null;
        conn = DriverManager.getConnection(sql_path,account,password);
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        while (rst.next()) {
            System.out.println(rst.getInt(1));
        }
    }
    public void user_insert(String sql,String name,String phoneNumber,String email,String password) throws Exception{
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(this.URL,this.UserName,this.PassWord);
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.setObject(1,name);
        pstm.setObject(2,phoneNumber);
        pstm.setObject(3,email);
        pstm.setObject(4,password);
        pstm.executeUpdate();
        conn.close();
    }
}
