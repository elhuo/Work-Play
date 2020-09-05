package com;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String phoneNumber=request.getParameter("phoneNumber");
        String email=request.getParameter("email");
        String password1=request.getParameter("password1");
        String password2=request.getParameter("password2");
        Integer flag=0;
        JDBC_util jc=new JDBC_util();
        if(!password1.equals(password2)) {
            flag=1;
        }
//        else if(name.length()!=11){
//            response.sendRedirect("/22/register.html");
//            return ;
//        }else {
//            int singal=0;char[] email_ch=email.toCharArray();
//            for (int i=0;i<email_ch.length;i++){
//                if(email_ch[i]=='@'){
//                    singal++;
//                }
//            }if (singal==1){
//                response.sendRedirect("/22/register.html");
//            }else {
//                response.sendRedirect("/22/register.html");
//                return;
//            }
//        }
        if(flag==0){
            String sql="insert into user(Name,PhoneNumber,Email,Password) values(?,?,?,?,?)";
            try{
                jc.user_insert(sql,name,phoneNumber,email,password1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            response.sendRedirect("/coffee_order/register.html");
        }
    }
}

