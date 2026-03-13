package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.FoodItemDAO;
import com.food.model.FoodItemModel;

/**
 * Servlet implementation class EditFoodItemController
 */
@WebServlet("/EditFoodItemController")
public class EditFoodItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int foodId = Integer.parseInt(request.getParameter("foodId"));

        FoodItemDAO dao = new FoodItemDAO();
        FoodItemModel food = dao.getFoodItemById(foodId);

        request.setAttribute("food", food);
        request.getRequestDispatcher("edit-food.jsp").forward(request, response);
    }

	}


