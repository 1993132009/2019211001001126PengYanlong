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

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("sex");
        String birth = request.getParameter("birth");
        java.sql.Date birthD = java.sql.Date.valueOf(birth);

        UserDao userDao = new UserDao();
        User userup = new User();
        int id = Integer.parseInt(ID);
        userup.setId(id);
        userup.setUsername("username");
        userup.setPassword("password");
        userup.setEmail("email");
        userup.setGender("gender");
        userup.setBirthDate(birthD);
        try {
            int update = userDao.updateUser(con, userup);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10);
            session.setAttribute("user",userup);
            if(update!=0) {
                request.setAttribute("message","UpdateUser successful!!!");
            } else {
                request.setAttribute("message","UpdateUser failed!!!");
            }
            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
