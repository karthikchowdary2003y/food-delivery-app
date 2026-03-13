package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.CartDAO;

@WebServlet("/RemoveCartItemController")
public class RemoveCartItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	    int cartId = Integer.parseInt(request.getParameter("cartId"));
        CartDAO cartDAO = new CartDAO();
        cartDAO.removeCartItem(cartId);

        response.sendRedirect("cart.jsp");
	}

}
