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


@WebServlet("/UserCategoryFoodController")
public class UserCategoryFoodController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		  int categoryId = Integer.parseInt(request.getParameter("categoryId"));
	        
	        FoodItemDAO dao = new FoodItemDAO();
	        List<FoodItemModel> foods = dao.getFoodItemsByCategory(categoryId);

	        request.setAttribute("foods", foods);
	        request.getRequestDispatcher("user-food-list.jsp").forward(request, response);
	    }
	}


