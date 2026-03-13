<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.food.dao.RestaurantDAO"%>
<%@ page import="com.food.model.RestaurantModel"%>
<%@ page import="com.food.model.UserModel"%>
<%
String role = (String) session.getAttribute("role");

// Fetch all restaurants
RestaurantDAO dao = new RestaurantDAO();
List<RestaurantModel> restaurants = dao.getAllRestaurants();
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Restaurants</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	font-family: 'Poppins', sans-serif;
	background: #f4f6f9;
}
.card {
	border-radius: 12px;
	box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
}
.card-header {
	background: #e23744;
	color: #fff;
	font-weight: bold;
	text-align: center;
}
.card img {
	width: 100%;
	height: 180px;
	object-fit: cover;
	border-top-left-radius: 12px;
	border-top-right-radius: 12px;
}
.card-actions a {
	margin-right: 5px;
}
</style>
</head>

<body>

<div class="container mt-5">

	<div class="d-flex justify-content-between mb-4">
		<h2>🍽️ Restaurants</h2>
	</div>

	<div class="row">

	<%
	if (restaurants.isEmpty()) {
	%>
		<div class="alert alert-info w-100">No restaurants found!</div>
	<%
	}

	for (RestaurantModel r : restaurants) {
	%>

		<div class="col-md-4 mb-4">
			<div class="card">

				<img
					src="<%= (r.getImage() != null && !r.getImage().isEmpty())
						? r.getImage()
						: "https://via.placeholder.com/400x180.png?text=No+Image" %>"
					alt="<%= r.getName() %>">

				<div class="card-header">
					<%= r.getName() %>
				</div>

				<div class="card-body">
					<p><strong>Rating:</strong> <%= r.getRating() %> ⭐</p>
					<p><strong>Location:</strong> <%= r.getLocation() %></p>
					<p><strong>Status:</strong> <%= r.getStatus() %></p>

					<div class="card-actions">

					<% if (role != null && role.equalsIgnoreCase("admin")) { %>
					

						<a href="add-restaurant.jsp"
							class="btn btn-success btn-sm">Add</a>

						<a href="EditRestaurantController?restaurantId=<%=r.getRestaurantId()%>"
							class="btn btn-primary btn-sm">Edit</a>

						<a href="DeleteRestaurantController?restaurantId=<%=r.getRestaurantId()%>"
							class="btn btn-danger btn-sm">Delete</a>

						<!-- ✅ ADD FOOD BUTTON -->
						<a href="add-food.jsp?restaurantId=<%=r.getRestaurantId()%>"
							class="btn btn-warning btn-sm">Add Food</a>
							
							<a href="UserSelectRestaurantController?restaurantId=<%=r.getRestaurantId()%>"
							class="btn btn-outline-secondary btn-sm">View Menu</a>

					<% } else { %>

						<a href="UserSelectRestaurantController?restaurantId=<%=r.getRestaurantId()%>"
							class="btn btn-outline-secondary btn-sm">View Menu</a>
							

					<% } %>

					</div>
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
