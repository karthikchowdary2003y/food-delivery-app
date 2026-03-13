package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.food.dao.CartDAO;
import com.food.model.CartModel;
import com.food.model.UserModel;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		
		  HttpSession session = request.getSession();
	        UserModel currentUser = (UserModel) session.getAttribute("currentUser");

	        if(currentUser == null){
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        int userId = currentUser.getUserId();
	        int foodId = Integer.parseInt(request.getParameter("foodId"));

	        CartDAO cartDAO = new CartDAO();

	        // Check if already in cart
	        CartModel existingItem = cartDAO.getCartItemByUserAndFood(userId, foodId);

	        if(existingItem != null){
	            // Update quantity
	            existingItem.setQuantity(existingItem.getQuantity() + 1);
	            cartDAO.updateCartItem(existingItem);
	        } else {
	            // Add new item
	            CartModel cart = new CartModel();
	            cart.setUserId(userId);
	            cart.setFoodId(foodId);
	            cart.setQuantity(1);
	            cartDAO.addToCart(cart);
	        }

	        response.sendRedirect("user-home.jsp"); // Redirect back to menu page
	    }
	
}
