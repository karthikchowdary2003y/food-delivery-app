package com.food.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.RestaurantDAO;
import com.food.model.RestaurantModel;

/**
 * Servlet implementation class EditRestaurantController
 */
@WebServlet("/EditRestaurantController")
public class EditRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());try {
		  int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

	        RestaurantDAO dao = new RestaurantDAO();
	        RestaurantModel restaurant = dao.getRestaurantById(restaurantId);

	        request.setAttribute("restaurant", restaurant);
	        request.getRequestDispatcher("edit-restaurant.jsp").forward(request, response);
	}
}

