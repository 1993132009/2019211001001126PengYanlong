package com.Pengyanlong.week6.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet",value="/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Before redirect");
        //response.sendRedirect("index.jsp");
        System.out.println("After redirect");
        //response.sendRedirect("/PengYanlong2019211001001126_war_exploded/index.jsp");

        response.sendRedirect("https://www.baidu.com/");
    }
}
