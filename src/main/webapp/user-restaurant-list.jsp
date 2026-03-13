<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.food.dao.RestaurantDAO, com.food.model.RestaurantModel"%>
<%@ page import="java.util.List"%>

<%
    RestaurantDAO dao = new RestaurantDAO();
    List<RestaurantModel> restaurants = dao.getAllRestaurants();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Select Restaurant | FoodApp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4 text-center">Select a Restaurant</h2>
    <div class="row g-4">
        <% for(RestaurantModel r : restaurants) { %>
            <div class="col-md-4">
                <div class="card shadow-sm">
                    <img src="<%= r.getImage() != null ? r.getImage() : "https://via.placeholder.com/300x180" %>" class="card-img-top">
                    <div class="card-body">
                        <h5><%= r.getName() %></h5>
                        <p>Rating: <%= r.getRating() %> ⭐</p>
                        <p>Location: <%= r.getLocation() %></p>
                        <a href="UserSelectRestaurantController?restaurantId=<%= r.getRestaurantId() %>" class="btn btn-primary w-100">View Menu</a>
                    </div>
                </div>
            </div>
        <% } %>
    </div>
</div>
</body>
</html>
