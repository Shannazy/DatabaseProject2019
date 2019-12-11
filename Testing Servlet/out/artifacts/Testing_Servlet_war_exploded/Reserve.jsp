<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.ArrayList" %>
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
    <section>
        <h1>Flights</h1>
        <form id="reserveForm" action="ReserveServlet" method="post">
            <p><% out.print(session.getAttribute("username")); %></p>
            <select style="display: none;" id="username" name="username" form="reserveForm">\
                <option value="<% out.print(session.getAttribute("username"));%>"></option>
            </select>
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
                            (ArrayList<ArrayList<String>>) session.getAttribute("flights");
                    for (int i = 0; i < flights.size(); i++) {
                        ArrayList<String> flight = flights.get(i);
                %>
                <tr>
                    <%for (int j = 0; j < flight.size(); j++) {%>
                    <td><% out.print(flight.get(j));%></td>
                    <% } %>
                    <td>
                        <button type="submit"
                                form="reserveForm"
                                name="flightNumber"
                                value="<%out.print(flight.get(0));%>"
                                id="reserve-button">Reserve</button>
                    </td>
                </tr>
                <% } %>
            </table>
        </form>
    </section>
</main>
</body>
</html>