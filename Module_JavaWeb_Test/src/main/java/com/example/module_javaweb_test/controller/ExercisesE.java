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

@WebServlet(name = "ExercisesE", value = "/exercises-e")
@MultipartConfig
public class ExercisesE extends HttpServlet {
    UsersDAO usersDAO = new UsersDAO();
    PositionDAO positionDAO = new PositionDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listPosition", positionDAO.findAll());
        req.getRequestDispatcher("position_user.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id_postition");

        req.setAttribute("listPosition", positionDAO.findAll());
        req.setAttribute("listUser", usersDAO.findUserByPosition(Integer.valueOf(id)));
        req.getRequestDispatcher("position_user.jsp").forward(req,resp);
    }
}
