package com.example.module_javaweb_test.controller;

import com.example.module_javaweb_test.dao.PositionDAO;
import com.example.module_javaweb_test.dao.UsersDAO;
import com.example.module_javaweb_test.entity.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ExercisesA", value = "/exercises-a")
@MultipartConfig
public class ExercisesA extends HttpServlet {
    UsersDAO usersDAO = new UsersDAO();
    PositionDAO positionDAO = new PositionDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("id_user_create") != null){
            UsersEntity users = new UsersEntity();
            req.setAttribute("user_edit",users);

            req.setAttribute("listPosition", positionDAO.findAll());
            req.getRequestDispatcher("edit_user.jsp").forward(req,resp);

        }else if (req.getParameter("id_user_edit") != null){
            String id_product = req.getParameter("id_user_edit");
            req.setAttribute("user_edit",usersDAO.findById(Integer.valueOf(id_product)));
            req.setAttribute("listPosition", positionDAO.findAll());
            req.getRequestDispatcher("edit_user.jsp").forward(req,resp);
        }
        else if (req.getParameter("id_user_delete") != null){
            String id_product = req.getParameter("id_user_delete");
            usersDAO.delete(Integer.valueOf(id_product));
            req.setAttribute("messageResponse","Delete user id = "+ id_product + " successful !");
            req.setAttribute("alert","success");
        }

        findAllUser(req,resp);

    }
    public void findAllUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        req.setAttribute("listPosition", positionDAO.findAll());
        req.setAttribute("listUser", usersDAO.findAll());
        try {
            req.getRequestDispatcher("exercises_a.jsp").forward(req,resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        UsersEntity users = new UsersEntity();
        int id_pr = Integer.parseInt(req.getParameter("id_user_update"));
        users.setId(id_pr);
        users.setName(req.getParameter("name"));
        users.setAddress(req.getParameter("address"));
        users.setPhone(req.getParameter("phone"));
        users.setAge(Integer.parseInt(req.getParameter("age")));
        users.setId_position(Integer.parseInt(req.getParameter("id_position")));
        System.out.println(req.getParameter("old_image"));
        boolean check_insert = false;
        boolean check_update = false;

        try {
            Part fileName = req.getPart("image");
            String rootPath = this.getServletContext().getRealPath("/");

            if (id_pr == 0) {
                if (fileName.getSubmittedFileName().equals("")){
                    check_insert = false;
                }else {
                    try {
                        users.setImage(fileName.getSubmittedFileName());
                        fileName.write(rootPath + "/images/" + fileName.getSubmittedFileName());
                        check_insert = true;
                    } catch (IOException e) {
                        check_insert = false;
                        e.printStackTrace();
                    }
                }

                if (check_insert == true){
                    req.setAttribute("messageResponse","Create new user successful !");
                    req.setAttribute("alert","success");
                    usersDAO.save(users);
                }else {
                    req.setAttribute("messageResponse","Create new user not successful !");
                    req.setAttribute("alert","danger");
                }

            } else {

                if (fileName.getSubmittedFileName().equals("")){
                    users.setImage(req.getParameter("old_image"));
                    check_update = true;
                }else {
                    try {
                        users.setImage(fileName.getSubmittedFileName());
                        fileName.write(rootPath + "/images/" + fileName.getSubmittedFileName());
                        check_update = true;
                    } catch (IOException e) {
                        check_update = false;
                        e.printStackTrace();
                    }

                }

                if (check_update == true){
                    req.setAttribute("messageResponse","Update user successful !");
                    req.setAttribute("alert","success");
                    usersDAO.update(users);
                }else {
                    req.setAttribute("messageResponse","Update user not successful !");
                    req.setAttribute("alert","danger");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        findAllUser(req,resp);
    }
}
