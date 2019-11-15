<%--
  Created by IntelliJ IDEA.
  User: shazi
  Date: 11/15/2019
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="BackEndCode.*" contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <% DatabaseConnection testingConnection = new DatabaseConnection(); %>
  <% out.println(testingConnection.getUserName());%>
  </body>
</html>
