<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/login.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<main>
    <section class="login">
        <form action="LoginServlet" method="post" class="login-form" id="login-form">
            <label id="user-name-label" for="username">Username</label>
            <input type="text" id="username" name = "User">
            <label id="password-label" for="password">Password</label>
            <input type="password" id="password" name = "Password">
            <button type="submit" form="login-form" value="Login" id="login-button">Login</button>
            <div class="register">
                <a href="Register.jsp">Register</a>
            </div>
        </form>
    </section>
</main>
</body>
</html>
