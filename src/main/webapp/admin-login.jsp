<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Admin Login | FoodApp</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: linear-gradient(to right, #343a40, #495057);
    font-family: 'Poppins', sans-serif;
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
}
.card{
    border-radius: 15px;
}
.btn-custom{
    font-size: 16px;
    padding: 10px;
}
</style>
</head>

<body>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card shadow p-4">
                <h3 class="text-center mb-4 text-dark">Admin Login</h3>

                <form action="AdminController" method="post">
                    <input type="hidden" name="action" value="login">

                    <div class="mb-3">
                        <label class="form-label">Username</label>
                        <input type="text" name="username" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label class="form-label">Password</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>

                    <button class="btn btn-dark w-100 btn-custom">Login</button>
                </form>

                <% if(request.getParameter("error") != null){ %>
                    <p class="text-danger text-center mt-2">Invalid Username or Password</p>
                <% } %>

                <div class="text-center mt-3">
                    <a href="index.jsp" class="text-decoration-none text-white">Back to Home</a>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
