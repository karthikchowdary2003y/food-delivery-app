<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Food Item</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body { background: #f4f6f9; }
.card { border-radius: 12px; }
.card-header {
    background: #e23744;
    color: white;
    font-weight: bold;
}
</style>
</head>

<body>

<div class="container mt-5">
<div class="row justify-content-center">
<div class="col-md-6">

<div class="card shadow">
<div class="card-header text-center">🍔 Add Food Item</div>

<div class="card-body">

<form action="AddFoodItemController" method="post">

    <!-- ✅ ONLY ONE hidden input -->
    <input type="hidden" name="restaurantId"
           value="<%= request.getParameter("restaurantId") %>">

    <label>Category</label>
    <select name="categoryId" class="form-control" required>
        <option value="">Select Category</option>
        <option value="1">Biryani</option>
        <option value="2">Pizza</option>
        <option value="3">Burger</option>
        <option value="4">Drinks</option>
    </select>
    


<input type="hidden" name="restaurantId"
       value="<%= request.getParameter("restaurantId") %>">

    <label>Food Name</label>
    <input type="text" name="name" class="form-control" required>

    <label>Price</label>
    <input type="number" step="0.01" name="price" class="form-control" required>

    <label>Image URL</label>
    <input type="text" name="image" class="form-control" required>

    <label>Description</label>
    <textarea name="description" class="form-control"></textarea>

    <button type="submit" class="btn btn-danger mt-3">Add Food</button>

</form>
</div>
</div>

</div>
</div>
</div>

</body>
</html>
