package com.food.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.food.dao.AdminDAO;
import com.food.model.AdminModel;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action"); // "login" only for now
        AdminDAO adminDAO = new AdminDAO();
        if ("login".equals(action)) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            AdminModel admin = adminDAO.loginAdmin(username, password);

            if (admin != null) {
                HttpSession session = request.getSession();
                session.setAttribute("currentAdmin", admin);
                session.setAttribute("role", "admin");

                response.sendRedirect("admin-home.jsp");
            } else {
                request.setAttribute("error", "Invalid username or password");
                RequestDispatcher rd = request.getRequestDispatcher("admin-login.jsp");
                rd.forward(request, response);
            }
        }

    }
}
