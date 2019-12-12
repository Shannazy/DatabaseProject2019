<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: stevenyuan
  Date: 12/11/19
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h2>Welcome to the Waiting List</h2>
<main>
    <section>
        <h2>Current Waiting List</h2>
        <table>
            <tr>
                <th>Client Email</th>
                <th>Departure Date</th>
                <th>Departure Time</th>
                <th>Departure Location</th>
                <th>Class</th>
                <th>Destination Date</th>
                <th>Destination Location</th>
                <th>Destination Time</th>
                <th>Airline</th>
                <th>Flight Number</th>
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
