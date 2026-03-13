package com.food.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.food.dao.UserDAO;
import com.food.model.UserModel;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action"); // register or login
        UserDAO userDAO = new UserDAO();

        if ("register".equals(action)) {
            // ---------- REGISTER ----------
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UserModel user = new UserModel();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("user"); // default role for normal users

            boolean success = userDAO.registerUser(user);
            RequestDispatcher rd;
            if (success) {
                // registration successful → go to login page
                response.sendRedirect("login.jsp");
            } else {
                // registration failed → email exists
                request.setAttribute("error", "Email already exists!");
                rd = request.getRequestDispatcher("register.jsp");
                rd.forward(request, response);
            }

        } else if ("login".equals(action)) {
            // ---------- LOGIN ----------
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            UserModel user = userDAO.loginUser(email, password);

            if (user != null) {
                // login successful → create session
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", user);

                // redirect based on role
                if ("admin".equals(user.getRole())) {
                    response.sendRedirect("admin-home.jsp"); // admin home page
                } else {
                    response.sendRedirect("user-home.jsp");  // user home page
                }

            } else {
                // login failed
                request.setAttribute("error", "Invalid email or password");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }
        }
    }
}
