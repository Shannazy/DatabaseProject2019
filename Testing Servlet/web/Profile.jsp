<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Profile</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<%
    ArrayList<String> user = (ArrayList<String>) (session.getAttribute("user"));
%>
<h2>Welcome to your profile <% out.println(user.get(1));%>!</h2>
<p> Your email is: <% out.println(user.get(0));%></p>
<p> Your date of birth is: <% out.println(user.get(4));%></p>
<p> Your phone number is: <% out.println(user.get(2));%></p>
<p> You created your profile on: <% out.println(user.get(3));%></p>
<main>
    <section>
        <h1>Upcoming Flights:</h1>
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
                ArrayList<ArrayList<String>> flights =
                        (ArrayList<ArrayList<String>>) (session.getAttribute("flights"));
                for (int i = 0; i < flights.size(); i++) {
                    ArrayList<String> flight = flights.get(i);
            %>
            <tr>
                <%for (int j = 0; j < flight.size(); j++) {%>
                <td><% out.print(flight.get(j));%></td>
                <% } %>
            </tr>
            <% } %>
        </table>
    </section>
</main>
</body>
</html>

