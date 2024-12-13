package com.javarush.module3.mytestproject.controller;

import com.javarush.module3.mytestproject.entity.Role;
import com.javarush.module3.mytestproject.model.UserService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/show-user")

public class ShowUserServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext().setAttribute("roles", Role.values());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("user", userService.getUser(id));
        req.getRequestDispatcher("/WEB-INF/show-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.updateUser(Long.parseLong(req.getParameter("id")),
                req.getParameter("name"),
                req.getParameter("login"),
                req.getParameter("password"),
                Role.valueOf(req.getParameter("role")));
        resp.sendRedirect("/admin");
    }
}
