<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: stevenyuan
  Date: 12/11/19
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Most Active Flights</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<%
    List<String> mostActive = (List<String>) session.getAttribute("mostActive");
%>
<p>
    Name: <% out.print(mostActive.get(0));%>
</p>
<p>
    Most Revenue: <% out.print(mostActive.get(1));%>
</p>
</body>
</html>
