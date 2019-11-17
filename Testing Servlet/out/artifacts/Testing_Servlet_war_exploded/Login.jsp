<%--
  Created by IntelliJ IDEA.
  User: shazi
  Date: 11/16/2019
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="./css/login.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<main>
    <section class="login">
        <form action="LoginServlet" method="post" class="login-form" id="login-form">
            <label id="user-name-label" for="user-name">Username: </label>
            <input type="text" id="user-name" name = "User">
            <label id="password-label" for="password">Password: </label>
            <input type="password" id="password" name = "Password">
            <button type="submit" form="login-form" value="Login" id="login-button">Login</button>
        </form>
    </section>
</main>
</body>
</html>
