package com;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_register")
public class Servlet_register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String phoneNumber=request.getParameter("phone");
        String password1=request.getParameter("Password1");
        String password2=request.getParameter("Password2");
        Integer flag=0;
        JDBC_util jc=new JDBC_util();
        if(!password1.equals(password2)) {
            flag=1;
        }if(flag==0){
            String sql="insert into user(Name,PhoneNumber,Password) values(?,?,?)";
            try{
                jc.user_insert(sql,name,phoneNumber,password1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("register.html");
        }
    }
}
