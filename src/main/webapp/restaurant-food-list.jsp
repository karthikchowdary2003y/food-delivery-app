<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.food.model.FoodItemModel"%>

<%
    List<FoodItemModel> foods = (List<FoodItemModel>) request.getAttribute("foods");
    int restaurantId = (Integer) request.getAttribute("restaurantId");
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Restaurant Food Items</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body {
    background: #f4f6f9;
}
.card {
    border-radius: 12px;
    box-shadow: 0 10px 20px rgba(0,0,0,0.1);
    margin-bottom: 20px;
}
.card img {
    height: 150px;
    object-fit: cover;
    border-top-left-radius: 12px;
    border-top-right-radius: 12px;
}
</style>
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4 text-center">🍴 Available Food Items</h2>

    <% if(foods.isEmpty()) { %>
        <div class="alert alert-info">No food items available for this restaurant.</div>
    <% } else { %>
        <div class="row">
            <% for(FoodItemModel f : foods) { %>
            <div class="col-md-4">
                <div class="card">
                    <img src="<%= f.getImage() != null && !f.getImage().isEmpty() ? f.getImage() : "https://via.placeholder.com/400x150.png?text=No+Image" %>" alt="<%= f.getName() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= f.getName() %></h5>
                        <p><%= f.getDescription() %></p>
                        <p class="fw-bold text-danger">₹ <%= f.getPrice() %></p>
                        <p>Status: <%= f.getStatus() %></p>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    <% } %>

    <div class="text-center mt-4">
        <a href="restaurant-list.jsp" class="btn btn-secondary">⬅ Back to Restaurants</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
