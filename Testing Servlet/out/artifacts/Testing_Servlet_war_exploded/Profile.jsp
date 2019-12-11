<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
    <title>Profile</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<h2>Welcome to your profile <% out.println(session.getAttribute("Full Name"));%>!</h2>
<p> Your email is: <% out.println(session.getAttribute("username"));%></p>
<p> Your date of birth is: <% out.println(session.getAttribute("Date of Birth"));%></p>
<p> Your phone number is: <% out.println(session.getAttribute("Phone Number"));%></p>
<p> You created your profile on: <% out.println(session.getAttribute("Creation"));%></p>
<main>
    <section>
        <h1>Upcoming Flights:</h1>
        <table>
            <tr>
                <th>Flight ID</th>
                <th>Departure Day</th>
                <th>Arrival Day</th>
                <th>Departure Airport</th>
                <th>Arrival Airport</th>
                <th>Airline</th>
                <th>Price</th>
            </tr>
        </table>
    </section>
</main>
</body>
</html>

