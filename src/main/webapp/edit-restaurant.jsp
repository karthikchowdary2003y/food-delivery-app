<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.food.model.RestaurantModel" %>

<%
    RestaurantModel restaurant = (RestaurantModel) request.getAttribute("restaurant");
    if (restaurant == null) {
        response.sendRedirect("admin-restaurants.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Restaurant</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<style>
body { font-family:'Poppins', sans-serif; background:#f4f6f9; }
.card { border-radius:12px; box-shadow:0 10px 25px rgba(0,0,0,0.1); padding:30px; max-width:600px; margin:50px auto; background:#fff;}
.btn-update { background:#e23744; color:#fff; border-radius:30px; width:100%; }
.btn-update:hover { opacity:0.9; }
</style>
</head>
<body>

<div class="card">
    <h3 class="text-center mb-4">Edit Restaurant</h3>
    <form action="UpdateRestaurantController" method="post">
        <input type="hidden" name="restaurantId" value="<%= restaurant.getRestaurantId() %>">

        <div class="mb-3">
            <label class="form-label">Name</label>
            <input type="text" name="name" class="form-control" value="<%= restaurant.getName() %>" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Image URL</label>
            <input type="text" name="image" class="form-control" value="<%= restaurant.getImage() %>">
        </div>
        <div class="mb-3">
        <input type="number" name="rating" class="form-control" step="0.1" min="0" max="5" 
       value="<%= restaurant.getRating() %>" required>
        
        </div>
        <div class="mb-3">
            <label class="form-label">Location</label>
            <input type="text" name="location" class="form-control" value="<%= restaurant.getLocation() %>">
        </div>
        <div class="mb-3">
            <label class="form-label">Status</label>
            <select name="status" class="form-select">
                <option value="OPEN" <%= "OPEN".equals(restaurant.getStatus()) ? "selected" : "" %>>OPEN</option>
                <option value="CLOSED" <%= "CLOSED".equals(restaurant.getStatus()) ? "selected" : "" %>>CLOSED</option>
            </select>
        </div>

        <button type="submit" class="btn btn-update">Update Restaurant</button>
    </form>
</div>

</body>
</html>
