<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.food.model.FoodItemModel" %>



<%
    FoodItemModel food = (FoodItemModel) request.getAttribute("food");
    if (food == null) {
        response.sendRedirect("admin-home.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Food Item</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(120deg, #ff6a00, #ee0979);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .edit-card {
            background: #fff;
            border-radius: 15px;
            padding: 30px;
            width: 100%;
            max-width: 500px;
            box-shadow: 0 15px 40px rgba(0,0,0,0.2);
        }

        .edit-card h3 {
            font-weight: 600;
            margin-bottom: 20px;
            text-align: center;
            color: #333;
        }

        .form-control {
            border-radius: 10px;
        }

        .btn-update {
            background: linear-gradient(135deg, #ff6a00, #ee0979);
            border: none;
            color: white;
            font-weight: 500;
            border-radius: 30px;
            padding: 10px;
        }

        .btn-update:hover {
            opacity: 0.9;
        }

        .food-preview {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 10px;
            margin-bottom: 15px;
        }
    </style>
</head>

<body>

<div class="edit-card">

    <h3>🍽️ Edit Food Item</h3>

    <!-- Image Preview -->
    <img src="<%= food.getImage() %>" class="food-preview" alt="Food Image">

    <form action="UpdateFoodItemController" method="post">

        <!-- Hidden ID -->
        <input type="hidden" name="foodId" value="<%= food.getFoodId() %>">

        <!-- Food Name -->
        <div class="mb-3">
            <label class="form-label">Food Name</label>
            <input type="text" name="name" class="form-control"
                   value="<%= food.getName() %>" required>
        </div>

        <!-- Price -->
        <div class="mb-3">
            <label class="form-label">Price (₹)</label>
            <input type="number" name="price" class="form-control" step="0.01"
                   value="<%= food.getPrice() %>" required>
        </div>

        <!-- Image URL -->
        <div class="mb-3">
            <label class="form-label">Image URL</label>
            <input type="text" name="image" class="form-control"
                   value="<%= food.getImage() %>">
        </div>

        <!-- Description -->
        <div class="mb-3">
            <label class="form-label">Description</label>
            <textarea name="description" class="form-control" rows="3"><%= food.getDescription() %></textarea>
        </div>

        <!-- Buttons -->
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-update">Update Food</button>
            <a href="admin-home.jsp" class="btn btn-outline-secondary">Cancel</a>
        </div>

    </form>

</div>

</body>
</html>
