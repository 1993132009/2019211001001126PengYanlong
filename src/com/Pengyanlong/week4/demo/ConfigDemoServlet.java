package com.Pengyanlong.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ConfigDemoServlet", urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name="name",value = "PengYanlong"),
                @WebInitParam(name="STid",value = "2019211001001126"),
        },loadOnStartup = 1
)
public class ConfigDemoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String Name = config.getInitParameter("name");
        String ID = config.getInitParameter("STid");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        try {
            out.println("Name is : " + Name + "<br>");
            out.println("ID is : " + ID + "<br>");
        } catch (NumberFormatException e) {
            out.println("input is error！" + "<br>");
        }
        out.println("</html></body>");
    }
}
