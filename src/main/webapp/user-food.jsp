<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.food.dao.FoodItemDAO"%>
<%@ page import="com.food.model.FoodItemModel"%>

<%
    // 1️⃣ Read restaurantId from URL
    String rid = request.getParameter("restaurantId");

    if (rid == null) {
        out.println("Restaurant not selected");
        return;
    }

    int restaurantId = Integer.parseInt(rid);

    // 2️⃣ Fetch food items of this restaurant
    FoodItemDAO dao = new FoodItemDAO();
    List<FoodItemModel> foods = dao.getFoodItemsByRestaurant(restaurantId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
.food-card {
    border-radius: 12px;
    box-shadow: 0 10px 20px rgba(0,0,0,0.1);
}
.food-card img {
    height: 180px;
    object-fit: cover;
}
</style>
</head>

<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">🍽️ Available Food Items</h2>

    <div class="row">
        <% if (foods.isEmpty()) { %>
            <div class="alert alert-info">
                No food items available for this restaurant.
            </div>
        <% } %>

        <% for(FoodItemModel f : foods){ %>
            <div class="col-md-4 mb-4">
                <div class="card food-card">
                    <img src="<%= f.getImage() %>" class="card-img-top">
                    <div class="card-body">
                        <h5 class="card-title"><%= f.getName() %></h5>
                        <p class="card-text"><%= f.getDescription() %></p>
                        <p class="fw-bold text-danger">₹ <%= f.getPrice() %></p>
                        <button class="btn btn-danger w-100">Add to Cart</button>
                    </div>
                </div>
            </div>
        <% } %>
    </div>

    <div class="text-center mt-4">
        <a href="user-restaurants.jsp" class="btn btn-outline-secondary">
            ⬅ Back to Restaurants
        </a>
    </div>
</div>

</body>
</html>
