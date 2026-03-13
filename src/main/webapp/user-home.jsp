<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.food.model.UserModel"%>
<%@ page import="com.food.model.FoodItemModel"%>
<%@ page import="com.food.model.CategoryModel"%>
<%@ page import="com.food.dao.FoodItemDAO"%>
<%@ page import="com.food.dao.CategoryDAO"%>

<%
UserModel currentUser = (UserModel) session.getAttribute("currentUser");
if (currentUser == null) {
    response.sendRedirect("login.jsp");
    return;
}

CategoryDAO categoryDAO = new CategoryDAO();
List<CategoryModel> categories = categoryDAO.getAllCategories();

FoodItemDAO foodDAO = new FoodItemDAO();
List<FoodItemModel> foods;

String categoryIdParam = request.getParameter("categoryId");
if (categoryIdParam != null) {
    int categoryId = Integer.parseInt(categoryIdParam);
    foods = foodDAO.getFoodItemsByCategory(categoryId);
} else {
    foods = foodDAO.getAllFoodItems();
}
%>

<!DOCTYPE html>
<html>
<head>
<title>User Home | FoodApp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">

<style>
body { background:#f8f8f8; font-family:Arial; }
.navbar-brand { color:#e23744 !important; font-weight:bold; }
.food-card { background:#fff; padding:15px; border-radius:10px; box-shadow:0 5px 20px rgba(0,0,0,.1); text-align:center; }
.food-card img { width:100%; height:200px; object-fit:cover; border-radius:10px; }
</style>
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg bg-white shadow-sm">
  <div class="container">
    <a class="navbar-brand" href="user-home.jsp">FoodApp</a>

    <div class="collapse navbar-collapse">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item"><a class="nav-link active" href="user-home.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="restaurant-list.jsp">Restaurants</a></li>
        <li class="nav-item">
          <a class="nav-link" href="cart.jsp">
            <i class="bi bi-cart-fill"></i> Cart
          </a>
        </li>
      </ul>

      <span class="me-3">Hello, <%=currentUser.getName()%></span>
      <a href="LogoutController" class="btn btn-outline-secondary">Logout</a>
    </div>
  </div>
</nav>

<!-- HERO -->
<div style="background:url('https://images.unsplash.com/photo-1504674900247-0877df9cc836') center/cover;
height:300px; display:flex; align-items:center; justify-content:center; color:white;">
  <div class="text-center">
    <h1>Welcome, <%=currentUser.getName()%> 🍔</h1>
    <p>Discover the best food & drinks</p>
  </div>
</div>

<!-- CATEGORIES -->
<!-- CATEGORIES -->
<div class="container my-5">
<h2>Categories</h2>
<div class="row">
<% for(CategoryModel c : categories){ %>
  <div class="col-md-3 mb-3">
    <div class="card">
      <img src="<%=c.getImage()%>" style="height:150px;object-fit:cover">
      <div class="card-body text-center">
        <h5><%=c.getCategoryName()%></h5>
        <a href="user-home.jsp?categoryId=<%=c.getCategoryId()%>" class="btn btn-danger btn-sm">View</a>
      </div>
    </div>
  </div>
<% } %>
</div>
</div>


<!-- FOOD ITEMS -->
<div class="container my-5">
<h2>Available Dishes</h2>
<div class="row g-4">
<% for(FoodItemModel f : foods){ %>
  <div class="col-md-3">
    <div class="food-card">
      <img src="<%=f.getImage()%>">
      <h5><%=f.getName()%></h5>
      <p>₹<%=f.getPrice()%></p>
      <a href="AddToCartController?foodId=<%=f.getFoodId()%>" class="btn btn-outline-danger btn-sm">Add to Cart</a>
    </div>
  </div>
<% } %>
</div>
</div>

</body>
</html>
