package com.food.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.food.dao.FoodItemDAO;
import com.food.model.AdminModel;
import com.food.model.FoodItemModel;

@WebServlet("/AddFoodItemController")
public class AddFoodItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

        /* ✅ CHECK ADMIN LOGIN */
        HttpSession session = request.getSession(false);
        AdminModel currentAdmin = (AdminModel) session.getAttribute("currentAdmin");

        if (currentAdmin == null) {
            response.sendRedirect("admin-login.jsp");
            return;
        }
		  // 🔹 Read parameters as String FIRST

        String restaurantIdStr = request.getParameter("restaurantId");

        String categoryIdStr   = request.getParameter("categoryId");
        String priceStr        = request.getParameter("price");

        String name  = request.getParameter("name");
        String image = request.getParameter("image");
        String desc  = request.getParameter("description");
        

        // 🔹 Validation (THIS FIXES YOUR ERROR)
        if (restaurantIdStr == null || restaurantIdStr.equals("null") || restaurantIdStr.isEmpty()
                || categoryIdStr == null || categoryIdStr.isEmpty()
                || priceStr == null || priceStr.isEmpty()) {

            RequestDispatcher rd1 = request.getRequestDispatcher("add-food.jsp");
            rd1.forward(request, response);
            return;
        }

        // 🔹 Safe parsing
        int restaurantId = Integer.parseInt(restaurantIdStr);
        int categoryId   = Integer.parseInt(categoryIdStr);
        double price     = Double.parseDouble(priceStr);

        // 🔹 Model
        FoodItemModel food = new FoodItemModel();
        food.setRestaurantId(restaurantId);
        food.setCategoryId(categoryId);
        food.setName(name);
        food.setPrice(price);
        food.setImage(image);
        food.setDescription(desc);
        food.setStatus("AVAILABLE");

        // 🔹 DAO
        FoodItemDAO dao = new FoodItemDAO();
        boolean success = dao.addFoodItem(food);

        // 🔹 SAME FLOW AS YOUR CODE
        if (success) {
            RequestDispatcher rd1 = request.getRequestDispatcher("admin-home.jsp");
            rd1.forward(request, response);
        } else {
            RequestDispatcher rd1 = request.getRequestDispatcher("add-food.jsp");
            rd1.forward(request, response);
        }
   

	    }
	}
