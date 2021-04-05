package com.Pengyanlong.week5.demo;

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

@WebServlet(name = "LoginServlet",value = "/Login",
        initParams = {
                @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value = "jdbc:sqlserver://localhost:1433;DatabaseName=userDB"),
                @WebInitParam(name="username",value = "sa"),
                @WebInitParam(name="password",value = "20011120"),
        },loadOnStartup = 1
)
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();
        ServletConfig config=getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("LGinit()-->"+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            boolean LGflag=false;
            while (rs.next()) {
                LGflag=true;
                out.println("<h1>Login Successful ! </h1><br/>");
                out.println("<h1>Welcome "+ username + "</h1><br/>");
                break;
            }
            if(LGflag==false)
            {
                out.println("<h1>Login Failed ! </h1><br/>");
                out.println("<h1>Username or Password Error ! </h1><br/>");
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
