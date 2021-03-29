package com.Pengyanlong.week3.demo;

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

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        ServletConfig config=getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("RGinit()-->"+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        java.sql.Date birthD = java.sql.Date.valueOf(birth);
        /*
        out.println("<html><body>");
        System.out.println("-->I am in doPost()");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        out.println("Date and Time: " + df.format(new Date()) + "<br>" + "<br>");
        try {
            out.println("username is : " + username + "<br>");
            out.println("password is : " + password + "<br>");
            out.println("email is : " + email + "<br>");
            out.println("gender is : " + gender + "<br>");
            out.println("birth is : " + birth + "<br>");
        } catch (NumberFormatException e) {
            out.println("input is error！" + "<br>");
        }
        out.println("</html></body>");
        */

        String sqlAdd = "insert into userTB values(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlAdd);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setDate(5, birthD);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sqlQuery="select * from userTB";
        try {
            ResultSet rs=con.createStatement().executeQuery(sqlQuery);
            out.print("<table border="+3+">");
            out.print("<tr>");
            out.print("<th>ID</th>");
            out.print("<th>UserName</th>");
            out.print("<th>PassWord</th>");
            out.print("<th>Email</th>");
            out.print("<th>Gender</th>");
            out.print("<th>Birth</th>");
            out.print("</tr>");
            while (rs.next()) {
                out.print("<tr>");
                out.print("<td>"+rs.getInt("id")+"</td>");
                out.print("<td>"+rs.getString("username")+"</td>");
                out.print("<td>"+rs.getString("password")+"</td>");
                out.print("<td>"+rs.getString("email")+"</td>");
                out.print("<td>"+rs.getString("gender")+"</td>");
                out.print("<td>"+rs.getDate("birthdate")+"</td>");
                out.print("<tr>");
            }
            out.print("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}