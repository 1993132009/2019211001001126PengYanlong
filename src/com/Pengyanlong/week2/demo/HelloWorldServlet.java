package com.Pengyanlong.week2.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

//now its just a java class
//extend HttpServlet
public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=GBK");

        PrintWriter out = response.getWriter();
        String Name = request.getParameter("name");
        String ID = request.getParameter("id");

        out.println("<html><body>");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        out.println("Date and Time: " + df.format(new Date()) + "<br>");

        try {
            out.println("Name is : " + Name + "<br>");
            out.println("ID is : " + ID + "<br>");
        } catch (NumberFormatException e) {
            out.println("inout is error！" + "<br>");
        }
        out.println("</html></body>");
    }
}
