package com.Pengyanlong.week5.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
        /*
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("LGinit()-->"+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        out.println(username);
//        out.println(password);
        String sqlQuery="select * from userTB where username=? and password=?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sqlQuery);
            ps.setString(1,username);
            ps.setString(2,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                //out.println("<h1>Login Successful ! </h1><br/>");
                //out.println("<h1>Welcome "+ username + "</h1><br/>");
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            } else {
                //out.println("<h1>Login Failed ! </h1><br/>");
                //out.println("<h1>Username or Password Error ! </h1><br/>");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
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
