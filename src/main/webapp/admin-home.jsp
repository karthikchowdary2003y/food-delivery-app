<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.food.model.AdminModel"%>
<%@ page import="com.food.dao.FoodItemDAO"%>
<%@ page import="com.food.model.FoodItemModel"%>

<%
AdminModel currentAdmin = (AdminModel) session.getAttribute("currentAdmin");
if (currentAdmin == null) {
	response.sendRedirect("admin-login.jsp");
	return;
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Dashboard | FoodApp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background: #f8f8f8;
}
.navbar-brand {
	font-weight: bold;
	color: #e23744 !important;
}
.nav-link.active, .nav-link:hover {
	color: #e23744 !important;
}
.restaurant-card img {
	height: 180px;
	object-fit: cover;
}
.restaurant-card:hover {
	transform: scale(1.02);
	transition: 0.3s;
}
</style>
</head>

<body>

<!-- SUCCESS / ERROR MESSAGE -->
<%
String msg = request.getParameter("msg");
if ("deleted".equals(msg)) {
%>
<div class="alert alert-success text-center">Food item deleted successfully</div>
<%
} else if ("error".equals(msg)) {
%>
<div class="alert alert-danger text-center">Failed to delete food item</div>
<%
}
%>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg bg-white shadow-sm">
	<div class="container">
		<a class="navbar-brand" href="admin-home.jsp">FoodApp Admin</a>

		<div class="collapse navbar-collapse">
			<ul class="navbar-nav mx-auto">
				<li class="nav-item">
					<a class="nav-link active" href="admin-home.jsp">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="restaurant-list.jsp">Restaurants</a>
				</li>
			</ul>

			<div class="d-flex align-items-center">
				<span class="me-3">Hello, <%= currentAdmin.getUsername() %></span>
				<a href="LogoutController" class="btn btn-outline-secondary">Logout</a>
			</div>
		</div>
	</div>
</nav>

<!-- HERO SECTION -->
<div class="text-center text-white d-flex align-items-center justify-content-center"
	style="background: url('https://images.unsplash.com/photo-1504674900247-0877df9cc836') center/cover;
	height: 300px;">
	<div>
		<h1>Admin Dashboard 🍔</h1>
		<p>Manage your restaurants and menu items</p>
	</div>
</div>

<!-- FOOD ITEMS SECTION -->
<div class="container my-5">

	<div class="d-flex justify-content-between mb-3">
		<h2>Food Items</h2>

		<!-- ✅ CORRECT BUTTON -->
	
	</div>

	<div class="row g-4">

		<%
		FoodItemDAO dao = new FoodItemDAO();
		for (FoodItemModel f : dao.getAllFoodItems()) {
		%>

		<div class="col-md-3">
			<div class="card restaurant-card shadow-sm">
				<img src="<%= f.getImage() %>" class="card-img-top"
					alt="<%= f.getName() %>">

				<div class="card-body text-center">
					<h5 class="card-title"><%= f.getName() %></h5>
					<p>₹<%= f.getPrice() %></p>

					<a href="EditFoodItemController?foodId=<%= f.getFoodId() %>"
						class="btn btn-warning btn-sm">
						Edit
					</a>

					<a href="DeleteFoodItemController?foodId=<%= f.getFoodId() %>"
						onclick="return confirm('Are you sure you want to delete this food item?')"
						class="btn btn-danger btn-sm">
						Delete
					</a>
				</div>
			</div>
		</div>

		<%
		}
		%>

	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
