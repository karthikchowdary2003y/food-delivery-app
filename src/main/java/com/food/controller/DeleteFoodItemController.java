package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.FoodItemDAO;


@WebServlet("/DeleteFoodItemController")
public class DeleteFoodItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		

        int foodId = Integer.parseInt(request.getParameter("foodId"));

        FoodItemDAO dao = new FoodItemDAO();
        boolean deleted = dao.deleteFoodItem(foodId);

        if (deleted) {
            response.sendRedirect("admin-home.jsp?msg=deleted");
        } else {
            response.sendRedirect("admin-home.jsp?msg=error");
        }
    
	}

}
