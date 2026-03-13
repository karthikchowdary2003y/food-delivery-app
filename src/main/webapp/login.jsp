<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body{
    background: #f8f9fa;
    font-family: 'Poppins', sans-serif;
}
.login-card{
    border-radius: 20px;
}
</style>
</head>

<body>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card login-card shadow p-4">
                <h3 class="text-center mb-3">User Login</h3>

               <form action="<%=request.getContextPath()%>/UserController" method="post">

                    <input type="hidden" name="action" value="login">

                    <div class="mb-3">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control" required>
                    </div>

                    <button class="btn btn-primary w-100">Login</button>
                </form>

                <div class="text-center mt-3">
                    <a href="register.jsp">New user? Register</a>
                </div>

                <% if(request.getParameter("error") != null){ %>
                    <p class="text-danger text-center mt-2">Invalid Email or Password</p>
                <% } %>

            </div>
        </div>
    </div>
</div>

</body>
</html>
