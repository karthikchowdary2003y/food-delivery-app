<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.food.model.UserModel" %>
<%@ page import="com.food.model.AdminModel" %>

<%
    // Get user/admin from session
    UserModel currentUser = (UserModel) session.getAttribute("currentUser");
    AdminModel currentAdmin = (AdminModel) session.getAttribute("currentAdmin");
%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>FoodApp | Order Food Online</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- BOOTSTRAP 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet" />

<style>
body { background: #f8f8f8; font-family: Arial, Helvetica, sans-serif; }
a { text-decoration: none; }
.navbar-brand { font-weight: bold; color: #e23744 !important; }
.nav-link { font-weight: 500; }
.nav-link.active, .nav-link:hover { color: #e23744 !important; }

.hero {
    background: url("https://images.unsplash.com/photo-1504674900247-0877df9cc836") center/cover;
    height: 350px;
    display: flex;
    align-items: center;
    justify-content: center;
    color: white;
    text-align: center;
}
.hero h1 { font-size: 42px; font-weight: bold; }
.hero input { max-width: 500px; }

.restaurant-card img { height: 180px; object-fit: cover; }
.restaurant-card:hover { transform: scale(1.02); transition: 0.3s; }

.footer { background: #1c1c1c; color: #ccc; padding: 40px 0; }
.footer h5 { color: white; }
.footer a { color: #ccc; display: block; margin-bottom: 6px; }
.footer a:hover { color: #e23744; }
.footer-bottom { border-top: 1px solid #333; margin-top: 20px; padding-top: 10px; text-align: center; font-size: 14px; }
</style>
</head>

<body>

<!-- ================= NAVBAR ================= -->
<nav class="navbar navbar-expand-lg bg-white shadow-sm">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">FoodApp</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainNav">
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="restaurant-list.jsp">Restaurants</a></li>
            </ul>

            <div class="d-flex align-items-center">
                <% if(currentUser != null) { %>
                    <!-- Logged-in User -->
                    <span class="me-3">Hello, <%= currentUser.getName() %></span>
                    <a href="LogoutController" class="btn btn-outline-secondary">Logout</a>
                <% } else if(currentAdmin != null) { %>
                    <!-- Logged-in Admin -->
                    <span class="me-3">Hello Admin, <%= currentAdmin.getUsername() %></span>
                    <a href="LogoutController" class="btn btn-outline-secondary me-2">Logout</a>
                    <a href="admin-dashboard.jsp" class="btn btn-danger">Dashboard</a>
                <% } else { %>
                    <!-- No one logged in -->
                    <a href="login.jsp" class="btn btn-outline-danger me-2">User Login</a>
                    <a href="register.jsp" class="btn btn-danger me-2">Sign Up</a>
                    <a href="admin-login.jsp" class="btn btn-dark">Admin Login</a>
                <% } %>
            </div>
        </div>
    </div>
</nav>

<!-- ================= HERO ================= -->
<div class="hero">
    <div>
        <h1>Discover the best food & drinks 🍔</h1>
        <input type="text" class="form-control mt-3" placeholder="Search for restaurant or dish">
    </div>
</div>

<!-- ================= POPULAR RESTAURANTS ================= -->
<div class="container my-5">
    <h2 class="mb-4">Popular Restaurants</h2>
    <div class="row g-4">
        <div class="col-md-4">
            <div class="card restaurant-card">
                <img src="https://images.unsplash.com/photo-1604908554027-06c9f3d6dbb8" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">Spice Hub</h5>
                    <p>⭐ 4.5 • Indian</p>
                    <a href="food-list.jsp" class="btn btn-danger w-100">View Menu</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card restaurant-card">
                <img src="https://images.unsplash.com/photo-1550547660-d9450f859349" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">Burger House</h5>
                    <p>⭐ 4.3 • Fast Food</p>
                    <a href="food-list.jsp" class="btn btn-danger w-100">View Menu</a>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card restaurant-card">
                <img src="https://images.unsplash.com/photo-1540189549336-e6e99c3679fe" class="card-img-top">
                <div class="card-body">
                    <h5 class="card-title">Pasta Palace</h5>
                    <p>⭐ 4.4 • Italian</p>
                    <a href="food-list.jsp" class="btn btn-danger w-100">View Menu</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- ================= POPULAR DISHES ================= -->
<div class="container my-5">
    <h2 class="mb-4">Popular Dishes</h2>
    <div class="row g-4">
        <div class="col-md-3">
            <div class="card">
                <div class="card-body text-center">
                    <h5>Biryani</h5>
                    <p>₹250</p>
                    <button class="btn btn-outline-danger btn-sm">Add to Cart</button>
                </div>
            </div>
        </div>
        <!-- Add more dishes similarly -->
    </div>
</div>

<!-- ================= FOOTER ================= -->
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h5>FoodApp</h5>
                <p>Order food online from your favorite restaurants.</p>
            </div>
            <div class="col-md-3">
                <h5>About</h5>
                <a href="#">About Us</a>
                <a href="#">Careers</a>
                <a href="#">Team</a>
            </div>
            <div class="col-md-3">
                <h5>Order</h5>
                <a href="#">My Orders</a>
                <a href="#">Track Order</a>
                <a href="#">Help</a>
            </div>
            <div class="col-md-3">
                <h5>Contact</h5>
                <a href="mailto:support@foodapp.com">support@foodapp.com</a>
                <a href="#">+91 98765 43210</a>
            </div>
        </div>
        <div class="footer-bottom">© 2026 FoodApp. All rights reserved.</div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
