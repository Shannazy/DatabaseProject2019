<%--
  Created by IntelliJ IDEA.
  User: shazi
  Date: 11/17/2019
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="RegisterServlet" method="post">
    Email : <input type="text" name="email">
    Name : <input type="text" name = "Full Name">
    Phone(No hypens)  : <input type="text" name = "Phone Number">
    Todays Date(YYYY-MM-DD) :<input type = "text" name = "Creation">
    Password : <input type = "text" name = "Password">
    Date of Birth(YYYY-MM-DD) :<input type = text" name="Date of Birth">
    <input type="submit", value = "Register">
</form>

</body>
</html>
