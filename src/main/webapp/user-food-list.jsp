<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.food.dao.FoodItemDAO"%>
<%@ page import="com.food.model.FoodItemModel"%>

<%
    // 1️⃣ Get selected restaurantId from session
    Integer restaurantId = (Integer) session.getAttribute("selectedRestaurantId");
    if (restaurantId == null) {
        response.sendRedirect("user-restaurant-list.jsp");
        return;
    }

    // 2️⃣ Get categoryId from request (optional)
    String catParam = request.getParameter("categoryId");
    Integer categoryId = null;
    if (catParam != null && !catParam.isEmpty()) {
        categoryId = Integer.parseInt(catParam);
    }

    // 3️⃣ Fetch food items for this restaurant (filtered by category if selected)
    FoodItemDAO dao = new FoodItemDAO();
    List<FoodItemModel> foods;
    if (categoryId != null) {
        foods = dao.getFoodItemsByRestaurantAndCategory(restaurantId, categoryId);
    } else {
        foods = dao.getFoodItemsByRestaurant(restaurantId);
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body { background: #f4f6f9; }
.food-card {
    border-radius: 12px;
    box-shadow: 0 10px 20px rgba(0,0,0,0.1);
    margin-bottom: 20px;
}
.food-card img {
    height: 180px;
    object-fit: cover;
    border-top-left-radius: 12px;
    border-top-right-radius: 12px;
}
.category-btns {
    margin-bottom: 20px;
    text-align: center;
}
.category-btns a {
    margin: 5px;
}
</style>
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="mb-4 text-center">🍽️ Menu</h2>

    <!-- 🔹 Category Buttons -->
    <div class="category-btns">
        <a href="user-food-list.jsp?categoryId=1" class="btn btn-outline-danger">Pizza</a>
        <a href="user-food-list.jsp?categoryId=2" class="btn btn-outline-primary">Drinks</a>
        <a href="user-food-list.jsp?categoryId=3" class="btn btn-outline-warning">Burger</a>
        <a href="user-food-list.jsp" class="btn btn-outline-secondary">All</a>
    </div>

    <% if (foods.isEmpty()) { %>
        <div class="alert alert-info w-100 text-center">
            No food items available for this category.
        </div>
    <% } else { %>
        <div class="row">
            <% for(FoodItemModel f : foods) { %>
            <div class="col-md-4">
                <div class="card food-card">
                    <img src="<%= f.getImage() != null && !f.getImage().isEmpty() ? f.getImage() : "https://via.placeholder.com/400x180.png?text=No+Image" %>" 
                         alt="<%= f.getName() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= f.getName() %></h5>
                        <p class="fw-bold text-danger">₹ <%= f.getPrice() %></p>
                        <p><%= f.getDescription() %></p>
                    </div>
                </div>
            </div>
            <% } %>
        </div>
    <% } %>

    <div class="text-center mt-4">
        <a href="user-restaurant-list.jsp" class="btn btn-outline-secondary">⬅ Back to Restaurants</a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
