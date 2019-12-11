<%--
  Created by IntelliJ IDEA.
  User: shazi
  Date: 11/16/2019
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<nav>
    <a href="Welcome.jsp">
        <div class="nav-link">Home</div>
    </a>
    <a href="Login.jsp">
        <div class="nav-link">Logout</div>
    </a>
</nav>
<main>
    <section>
        <p class="success">Successful Login!
                ${username};
        </p>
    </section>
</main>
</body>
</html>
