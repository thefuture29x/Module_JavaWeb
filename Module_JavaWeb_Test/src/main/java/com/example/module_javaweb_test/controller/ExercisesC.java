package com.example.module_javaweb_test.controller;

import com.example.module_javaweb_test.dao.PositionDAO;
import com.example.module_javaweb_test.dao.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ExercisesC", value = "/exercises-c")
@MultipartConfig
public class ExercisesC extends HttpServlet {
    UsersDAO usersDAO = new UsersDAO();
    PositionDAO positionDAO = new PositionDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("filter_user.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int minage = 0;
        int maxage = 0;
        String min = req.getParameter("minage");
        String max = req.getParameter("maxage");
        if (min.equals("")){
            min = String.valueOf(0);
        }else {
            minage = Integer.parseInt(min);
        }
        if (max.equals("")){
            max = String.valueOf(0);
        }else {
            maxage = Integer.parseInt(max);
        }

        req.setAttribute("listPosition", positionDAO.findAll());
        req.setAttribute("listUser", usersDAO.FilterUser(minage,maxage));
        req.getRequestDispatcher("filter_user.jsp").forward(req,resp);
    }
}
