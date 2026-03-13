package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.FoodItemDAO;
import com.food.model.FoodItemModel;

@WebServlet("/UpdateFoodItemController")
public class UpdateFoodItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 int foodId = Integer.parseInt(request.getParameter("foodId"));
	        String name = request.getParameter("name");
	        double price = Double.parseDouble(request.getParameter("price"));
	        String image = request.getParameter("image");
	        String desc = request.getParameter("description");

	        FoodItemModel food = new FoodItemModel();
	        food.setFoodId(foodId);
	        food.setName(name);
	        food.setPrice(price);
	        food.setImage(image);
	        food.setDescription(desc);

	        FoodItemDAO dao = new FoodItemDAO();
	        dao.updateFoodItem(food);

	        response.sendRedirect("admin-home.jsp");
	    }
	
	}


