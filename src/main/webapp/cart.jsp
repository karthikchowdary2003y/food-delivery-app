<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.food.model.UserModel, com.food.model.CartModel, com.food.dao.CartDAO, com.food.dao.FoodItemDAO, com.food.model.FoodItemModel"%>
<%@ page import="java.util.List"%>

<%
UserModel currentUser = (UserModel) session.getAttribute("currentUser");
if(currentUser == null){
    response.sendRedirect("login.jsp");
    return;
}

CartDAO cartDAO = new CartDAO();
FoodItemDAO foodDAO = new FoodItemDAO();
List<CartModel> cartItems = cartDAO.getCartItemsByUser(currentUser.getUserId());
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>My Cart | FoodApp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
<style>
body { background: #f2f2f2; font-family: 'Poppins', sans-serif; }
h2 { font-weight: 600; margin-bottom: 30px; }

.cart-card {
    background: #fff;
    border-radius: 20px;
    padding: 20px;
    box-shadow: 0 15px 40px rgba(0,0,0,0.1);
    margin-bottom: 25px;
    display: flex;
    align-items: center;
    transition: transform 0.3s ease;
}
.cart-card:hover { transform: translateY(-5px); }

.cart-card img {
    width: 140px;
    height: 120px;
    object-fit: cover;
    border-radius: 15px;
    box-shadow: 0 5px 20px rgba(0,0,0,0.05);
}

.cart-details {
    flex: 1;
    margin-left: 25px;
}

.cart-details h5 { font-weight: 600; font-size: 1.2rem; margin-bottom: 8px; }
.cart-details p { margin: 5px 0; color: #555; font-size: 0.95rem; }

.quantity-controls {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-top: 10px;
}

.quantity-controls form button {
    border-radius: 50%;
    width: 32px;
    height: 32px;
    padding: 0;
    font-weight: 600;
    transition: all 0.2s;
}

.quantity-controls form button:hover {
    background: #e23744;
    color: #fff;
    border-color: #e23744;
}

.cart-actions {
    text-align: right;
    display: flex;
    flex-direction: column;
    gap: 8px;
}

.cart-actions a {
    padding: 6px 12px;
    border-radius: 8px;
    font-weight: 500;
}

.total-section {
    background: #fff;
    border-radius: 20px;
    padding: 25px;
    box-shadow: 0 15px 40px rgba(0,0,0,0.1);
    text-align: right;
    font-size: 1.1rem;
    margin-top: 20px;
}

.total-section h4 { font-weight: 700; font-size: 1.5rem; color: #e23744; }
.pay-btn {
    background: #e23744;
    color: #fff;
    font-weight: 600;
    padding: 12px 30px;
    border-radius: 12px;
    border: none;
    margin-top: 15px;
    transition: all 0.3s;
}
.pay-btn:hover {
    background: #c52b3f;
    transform: translateY(-2px);
    box-shadow: 0 5px 15px rgba(0,0,0,0.1);
}

.user-home-btn {
    background: #3498db;
    color: white;
    font-weight: 500;
    padding: 10px 20px;
    border-radius: 12px;
    text-decoration: none;
    transition: all 0.3s;
}
.user-home-btn:hover {
    background: #217dbb;
    text-decoration: none;
}
</style>
</head>
<body>

<div class="container my-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>My Cart</h2>
        <!-- User Home Button -->
        <a href="user-home.jsp" class="user-home-btn">Back to Home</a>
    </div>

    <%
    if(cartItems.isEmpty()){
    %>
        <div class="alert alert-info shadow-sm">Your cart is empty!</div>
    <%
    } else {
        double total = 0;
        for(CartModel c : cartItems){
            FoodItemModel f = foodDAO.getFoodItemById(c.getFoodId());
            double subtotal = f.getPrice() * c.getQuantity();
            total += subtotal;
    %>
    <div class="cart-card">
        <img src="<%= f.getImage() %>" alt="<%= f.getName() %>">

        <div class="cart-details">
            <h5><%= f.getName() %></h5>
            <p>Price: ₹<%= f.getPrice() %></p>
            <p>Subtotal: ₹<%= subtotal %></p>

            <div class="quantity-controls">
                <!-- Decrease Quantity -->
                <form action="UpdateCartQuantityController" method="post">
                    <input type="hidden" name="cartId" value="<%= c.getCartId() %>">
                    <input type="hidden" name="quantity" value="<%= c.getQuantity() - 1 %>">
                    <button class="btn btn-outline-secondary btn-sm" <%= (c.getQuantity() <= 1) ? "disabled" : "" %>>-</button>
                </form>

                <span><%= c.getQuantity() %></span>

                <!-- Increase Quantity -->
                <form action="UpdateCartQuantityController" method="post">
                    <input type="hidden" name="cartId" value="<%= c.getCartId() %>">
                    <input type="hidden" name="quantity" value="<%= c.getQuantity() + 1 %>">
                    <button class="btn btn-outline-secondary btn-sm">+</button>
                </form>
            </div>
        </div>

        <div class="cart-actions">
            <a href="RemoveCartItemController?cartId=<%= c.getCartId() %>" class="btn btn-danger btn-sm">Remove</a>
        </div>
    </div>
    <% } %>

    <div class="total-section">
        <h4>Total: ₹<%= total %></h4>
        <a href="checkout.jsp" class="pay-btn">Pay Now</a>
    </div>
    <% } %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
