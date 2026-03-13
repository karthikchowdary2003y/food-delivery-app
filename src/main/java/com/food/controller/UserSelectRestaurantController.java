package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/UserSelectRestaurantController")
public class UserSelectRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

	        // 2️⃣ Store in session
	        request.getSession().setAttribute("selectedRestaurantId", restaurantId);

	        // 3️⃣ Redirect to food list page
	        response.sendRedirect("user-food-list.jsp");
	}

}
