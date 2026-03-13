package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.RestaurantDAO;
import com.food.model.RestaurantModel;

/**
 * Servlet implementation class UpdateRestaurantController
 */
@WebServlet("/UpdateRestaurantController")
public class UpdateRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1️⃣ Get restaurantId from URL
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double rating = Double.parseDouble(request.getParameter("rating"));
        String location = request.getParameter("location");
        String status = request.getParameter("status");

        RestaurantModel restaurant = new RestaurantModel();
        restaurant.setRestaurantId(restaurantId);
        restaurant.setName(name);
        restaurant.setImage(image);
        restaurant.setRating(rating);
        restaurant.setLocation(location);
        restaurant.setStatus(status);

        RestaurantDAO dao = new RestaurantDAO();
        boolean success = dao.updateRestaurant(restaurant);

        if(success) {
            response.sendRedirect("restaurant-list.jsp"); // go back to restaurant list
        } else {
            response.getWriter().println("Update failed!");
        }
    }
	}


