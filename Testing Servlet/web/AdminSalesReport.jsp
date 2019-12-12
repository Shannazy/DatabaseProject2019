<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sales Report</title>
    <link href="./css/index.css" rel="stylesheet" type="text/css">
    <link href="./css/welcome.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<h1>Sales report for <% out.print(session.getAttribute("month"));%></h1>
<table>
    <tr>
        <th>Flight Number</th>
        <th>Tickets Sold</th>
        <th>Total Revenue</th>
    </tr>
    <%
        ArrayList<ArrayList<String>> salesReport=
                (ArrayList<ArrayList<String>>) (session.getAttribute("salesReport"));
        for (int i = 0; i < salesReport.size(); i++) {
            ArrayList<String> report = salesReport.get(i);
    %>
    <tr>
        <%for (int j = 0; j < report.size(); j++) {%>
        <td><% out.print(report.get(j));%></td>
        <% } %>
    </tr>
    <% } %>
</table>

</body>
</html>
