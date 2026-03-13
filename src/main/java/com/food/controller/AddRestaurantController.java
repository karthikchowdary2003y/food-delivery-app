package com.food.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.food.dao.RestaurantDAO;
import com.food.model.RestaurantModel;


@WebServlet("/AddRestaurantController")
public class AddRestaurantController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

        String name = request.getParameter("name");
        String image = request.getParameter("image");
        double rating = Double.parseDouble(request.getParameter("rating"));
        String location = request.getParameter("location");
        String status = request.getParameter("status");

        RestaurantModel r = new RestaurantModel();
        r.setName(name);
        r.setImage(image);
        r.setRating(rating);
        r.setLocation(location);
        r.setStatus(status);

        RestaurantDAO dao = new RestaurantDAO();
        boolean success = dao.addRestaurant(r);

        if(success) {
            response.sendRedirect("restaurant-list.jsp"); // Redirect to restaurant list page
        } else {
            response.getWriter().println("Failed to add restaurant!");
        }
    }

}
