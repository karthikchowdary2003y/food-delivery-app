package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.CartDAO;
import com.food.model.CartModel;


@WebServlet("/UpdateCartQuantityController")
public class UpdateCartQuantityController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub   
		try {
        int cartId = Integer.parseInt(request.getParameter("cartId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (quantity < 1) {
            quantity = 1;
        }

        CartDAO cartDAO = new CartDAO();
        CartModel cart = new CartModel();
        cart.setCartId(cartId);
        cart.setQuantity(quantity);

        // Update the quantity in the database
        cartDAO.updateCartItem(cart);

        // Redirect back to cart page
        response.sendRedirect("cart.jsp");
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("cart.jsp");
    }
	}

}
