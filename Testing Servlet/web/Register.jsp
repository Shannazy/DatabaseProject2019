<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/register.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<main>
    <section class="register">
        <form action="RegisterServlet" method="post" id="register-form">
            <label id="email-label" for="email">Email</label>
            <input type="email" name="email" id="email">
            <label id="name-label" for="name">Name</label>
            <input type="text" name = "Full Name" id="name">
            <label id="phone-label" for="phone">Phone</label>
            <input type="tel" name = "Phone Number" pattern="[0-9]{10}" id="phone">
            <label id="date-label" for="date">Todays Date</label>
            <input type="date" name = "Creation" id="date">
            <label id="password-label" for="password">Password</label>
            <input type="password" name = "Password" id="password">
            <label id="dob-label" for="dob">Date of Birth</label>
            <input type="date" name="Date of Birth" id="dob">
            <button type="submit" form="register-form" value="Register" id="register-button">Register</button>
            <div class="login">
                <a href="Login.jsp">Login</a>
            </div>
        </form>
    </section>
</main>
</body>
<script type="text/javascript">
    document.getElementById("date").value = new Date()
        .toJSON()
        .slice(0, 10);
</script>
</html>
