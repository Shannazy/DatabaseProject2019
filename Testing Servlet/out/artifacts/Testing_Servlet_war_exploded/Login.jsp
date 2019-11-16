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
</head>
<body>
<form action="LoginServlet" method="post">
    Enter User : <input type="text"  name = "User"><br>
    Enter Password : <input type="password" name = "Password"><br>
    <input type = "submit" value="Login">

</form>

</body>
</html>
