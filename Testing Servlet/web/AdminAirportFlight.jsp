<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: stevenyuan
  Date: 12/11/19
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Airport Flights</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<h1>Flights from Airport <% out.print(session.getAttribute("airport")); %>:</h1>
<table>
    <tr>
        <th>Flight Number</th>
        <th>Departure Date</th>
        <th>Departure Time</th>
        <th>Departure Location</th>
        <th>Destination Date</th>
        <th>Destination Time</th>
        <th>Destination Location</th>
        <th>Class</th>
        <th>Airline</th>
        <th>Flight ID</th>
        <th>Price</th>
    </tr>
    <%
        ArrayList<ArrayList<String>> arrivals = (ArrayList<ArrayList<String>>) session.getAttribute("arrive");
        for (int i = 0; i < arrivals.size(); i++) {
            ArrayList<String> arrival = arrivals.get(i);
    %>
    <tr>
        <%for (int j = 0; j < arrival.size(); j++) {%>
        <td><% out.print(arrival.get(j));%></td>
        <% } %>
    </tr>
    <% } %>
    <%
        ArrayList<ArrayList<String>> departs = (ArrayList<ArrayList<String>>) session.getAttribute("depart");
        for (int i = 0; i < departs.size(); i++) {
            ArrayList<String> depart = departs.get(i);
    %>
    <tr>
        <%for (int j = 0; j < depart.size(); j++) {%>
        <td><% out.print(depart.get(j));%></td>
        <% } %>
    </tr>
    <% } %>
</table>

</body>
</html>
