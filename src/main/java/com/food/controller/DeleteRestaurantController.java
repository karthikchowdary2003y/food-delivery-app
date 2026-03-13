package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.RestaurantDAO;

@WebServlet("/DeleteRestaurantController")
public class DeleteRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 // 1️⃣ Get restaurantId from URL
        String rid = request.getParameter("restaurantId");
        if(rid == null || rid.isEmpty()) {
            response.sendRedirect("admin-restaurants.jsp"); // no ID provided
            return;
        }

        int restaurantId = Integer.parseInt(rid);

        // 2️⃣ Delete restaurant using DAO
        RestaurantDAO dao = new RestaurantDAO();
        boolean success = dao.deleteRestaurant(restaurantId);

        // 3️⃣ Redirect back to admin restaurants page
        if(success) {
            response.sendRedirect("admin-restaurants.jsp");
        } else {
            response.getWriter().println("Failed to delete restaurant!");
        }
	}

}
