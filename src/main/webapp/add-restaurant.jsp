<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Add Restaurant</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
<style>
body { font-family: 'Poppins', sans-serif; background: #f2f2f2; }
.container { max-width: 600px; margin-top: 50px; }
.card { padding: 30px; border-radius: 20px; box-shadow: 0 15px 40px rgba(0,0,0,0.1); }
</style>
</head>
<body>

<div class="container">
    <div class="card">
        <h2 class="mb-4 text-center">Add New Restaurant</h2>
        <form action="AddRestaurantController" method="post">
            <div class="mb-3">
                <label class="form-label">Restaurant Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Image URL</label>
                <input type="text" name="image" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Rating</label>
                <input type="number" name="rating" class="form-control" step="0.1" min="0" max="5">
            </div>
            <div class="mb-3">
                <label class="form-label">Location</label>
                <input type="text" name="location" class="form-control">
            </div>
            <div class="mb-3">
                <label class="form-label">Status</label>
                <select name="status" class="form-select">
                    <option value="OPEN">OPEN</option>
                    <option value="CLOSED">CLOSED</option>
                </select>
            </div>
            <button type="submit" class="btn btn-danger w-100">Add Restaurant</button>
        </form>
    </div>
</div>

</body>
</html>
