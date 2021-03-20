package com.Pengyanlong.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {response.setContentType("text/html;charset=GBK");

        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("sex");
        String birth = request.getParameter("birth");

        out.println("<html><body>");
        //---
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        out.println("Date and Time: " + df.format(new Date()) + "<br>" + "<br>");
        try {
            out.println("username is : " + username + "<br>");
            out.println("password is : " + password + "<br>");
            out.println("email is : " + email + "<br>");
            out.println("gender is : " + gender + "<br>");
            out.println("birth is : " + birth + "<br>");
            //
        } catch (NumberFormatException e) {
            out.println("input is error！" + "<br>");
        }
        //---
        out.println("</html></body>");
    }
}
