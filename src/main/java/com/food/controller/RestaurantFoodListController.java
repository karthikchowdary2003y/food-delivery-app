package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.food.dao.FoodItemDAO;
import com.food.model.FoodItemModel;

/**
 * Servlet implementation class RestaurantFoodListController
 */
@WebServlet("/RestaurantFoodListController")
public class RestaurantFoodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

        FoodItemDAO dao = new FoodItemDAO();
        List<FoodItemModel> foods = dao.getFoodItemsByRestaurant(restaurantId);

        request.setAttribute("foods", foods);
        request.setAttribute("restaurantId", restaurantId);
        request.getRequestDispatcher("restaurant-food-list.jsp").forward(request, response);
    
	}

}
