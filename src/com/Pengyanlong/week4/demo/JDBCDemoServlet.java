package com.Pengyanlong.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "JDBCDemoServlet", urlPatterns = {"/jdbc"}
        /*,
        initParams = {
                @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value = "jdbc:sqlserver://localhost:1433;DatabaseName=userDB"),
                @WebInitParam(name="username",value = "sa"),
                @WebInitParam(name="password",value = "20011120"),
        },loadOnStartup = 1
         */
)
public class JDBCDemoServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        /*
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;DatabaseName=userDB";
        String username="sa";
        String password="20011120";
        */
        /*
        ServletConfig config=getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("JDBCinit()-->"+con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-->I am in doGet()");
        String sql="select * from userTB";
        try {
            ResultSet rs=con.createStatement().executeQuery(sql);
            while (rs.next()) {
                //get from rs
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

