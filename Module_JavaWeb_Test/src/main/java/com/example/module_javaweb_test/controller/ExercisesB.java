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
@WebServlet(name = "ExercisesB", value = "/exercises-b")
@MultipartConfig
public class ExercisesB extends HttpServlet {
    UsersDAO usersDAO = new UsersDAO();
    PositionDAO positionDAO = new PositionDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("search_user.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");

        req.setAttribute("listPosition", positionDAO.findAll());
        req.setAttribute("listUser", usersDAO.SearchUser(name,address,phone));
        req.getRequestDispatcher("search_user.jsp").forward(req,resp);
    }
}
