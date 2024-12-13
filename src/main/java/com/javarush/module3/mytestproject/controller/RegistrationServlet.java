package com.javarush.module3.mytestproject.controller;

import com.javarush.module3.mytestproject.entity.Role;
import com.javarush.module3.mytestproject.entity.User;
import com.javarush.module3.mytestproject.model.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(req.getParameter("name"), req.getParameter("login"), req.getParameter("password"));
        user.setRole(Role.USER);
        userService.addUser(user);
        resp.sendRedirect("/login");
    }
}
