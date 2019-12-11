<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<main>
    <% if (session.getAttribute("role").equals("client")) {%>
        <jsp:include page="Search.jsp"/>
    <% } %>

    <jsp:include page="Search.jsp"/>
</main>
</body>
</html>
