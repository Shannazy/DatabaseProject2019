<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: stevenyuan
  Date: 12/11/19
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Summary Listing</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<h1>Query <% out.print(session.getAttribute("query")); %></h1>
<table>
    <tr>
        <th>Ticket Number</th>
        <th>Client</th>
        <th>Flight Number</th>
        <th>Total Price</th>
        <th>Ref</th>
    </tr>
    <%
        ArrayList<ArrayList<String>> summary =
                (ArrayList<ArrayList<String>>) (session.getAttribute("summaryListing"));
        for (int i = 0; i < summary.size(); i++) {
            ArrayList<String> sum = summary.get(i);
    %>
    <tr>
        <%for (int j = 0; j < sum.size(); j++) {%>
        <td><% out.print(sum.get(j));%></td>
        <% } %>
    </tr>
    <% } %>
</table>

</body>
</html>
