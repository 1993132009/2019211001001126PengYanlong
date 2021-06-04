package com.Pengyanlong.controller;

import com.Pengyanlong.dao.UserDao;
import com.Pengyanlong.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String mail=request.getParameter("email");
        String sex=request.getParameter("sex");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth= null;
        try {
            birth = simpleDateFormat.parse(request.getParameter("birth").trim());
        } catch (ParseException e) {
            System.out.println(e);
        }
        User u=new User(Integer.valueOf(id),username,password,mail,sex,birth);
        UserDao userDao=new UserDao();
        try {
            userDao.updateUser((Connection)getServletContext().getAttribute("con"),u);
            HttpSession session=request.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("user",u);

        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println(birth);
        request.getRequestDispatcher("accountDetails").forward(request,response);
    }
}
