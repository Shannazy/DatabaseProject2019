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
<<<<<<< HEAD
    <section>
        <p class="success">Successful Login!
                ${username}
        </p>
    </section>
=======
    <% if (session.getAttribute("role").equals("client")) {%>
        <jsp:include page="Search.jsp"/>
    <% } %>

    <jsp:include page="Search.jsp"/>
>>>>>>> cf4e9caf97ade975a8fc20455e9b262a7dc41281
</main>
</body>
</html>
