package com.javarush.module3.mytestproject.controller;

import com.javarush.module3.mytestproject.entity.User;
import com.javarush.module3.mytestproject.model.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/admin")
public class AdminPanelServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = userService.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
    }
}
