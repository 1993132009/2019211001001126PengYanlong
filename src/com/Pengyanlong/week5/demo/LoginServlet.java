package com.Pengyanlong.week5.demo;

import com.Pengyanlong.dao.UserDao;
import com.Pengyanlong.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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

        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con,username,password);
            if(user!=null) {
                //week8
                /*
                Cookie c = new Cookie("sessionid",""+user.getId());
                c.setMaxAge(10*60);
                response.addCookie(c);
                */
                String rememberMe = request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")) {
                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", rememberMe);
                    usernameCookie.setMaxAge(10);
                    passwordCookie.setMaxAge(10);
                    rememberMeCookie.setMaxAge(10);
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session = request.getSession();
                System.out.println("seccion id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                //request.setAttribute("user",user);
                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            } else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
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
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            } else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doPost(request,response);
        request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,response);
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
