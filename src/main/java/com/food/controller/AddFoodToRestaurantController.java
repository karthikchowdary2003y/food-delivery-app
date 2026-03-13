package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AddFoodToRestaurantController
 */
@WebServlet("/AddFoodToRestaurantController")
public class AddFoodToRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		   int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
	        // Pass restaurantId to add-food.jsp
	        request.setAttribute("restaurantId", restaurantId);
	        request.getRequestDispatcher("add-food.jsp").forward(request, response);
	    
	}

}
