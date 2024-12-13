package com.javarush.module3.mytestproject.controller;

import java.io.*;

import com.javarush.module3.mytestproject.model.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (req.getParameter("enter") != null) {
            if (userService.authorize(login, password)) {
                req.setAttribute("authorized", true);
                HttpSession session = req.getSession(true);
                session.setAttribute("id", userService.getUserId(login, password));
                resp.sendRedirect("/" + req.getParameter("login"));
            } else {
                req.setAttribute("authorized", false);
                req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
            }
        }
    }
}