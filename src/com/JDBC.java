package com;


import java.sql.*;
import java.util.Date;
import java.util.Vector;

public class JDBC {
    final String URL="jdbc:mysql://localhost:3306/temp";
    final String UserName="root";
    final String PassWord="rootroot";
    public Float food_select(String sql,String a) throws Exception{
        Connection conn = null;
        Float price=0.0f;
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(this.URL,this.UserName,this.PassWord);
        PreparedStatement pstm=conn.prepareStatement(sql);
        pstm.setObject(1,a);
        ResultSet rst = pstm.executeQuery();
        while(rst.next())
        {
            price=rst.getFloat(5);
        }
        conn.close();
        return price;
    }
}
