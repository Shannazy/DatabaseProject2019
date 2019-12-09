<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section>
    <h1>Flights</h1>
    <form id="reserveForm">

    <select id="flights" name="flights" form="reserveForm">

    <table>
        <c:forEach var="flight" items="${session.getAttribute('flights')}">
            <tr>
                <td><c:out value="${flight.id}"/></td>
                <td><c:out value="${flight.departDay}"/></td>
                <td><c:out value="${flight.arriveDay}"/></td>
                <td><c:out value="${flight.departAirport}"/></td>
                <td><c:out value="${flight.arriveAirport}"/></td>
                <td><c:out value="${flight.airline}"/></td>
                <td><c:out value="${flight.price}"/></td>
                <td><c:out value="${flight.capacity}"/></td>
            </tr>
        </c:forEach>
    </table>

    <button type="submit" form="reserveForm" value="Register" id="reserve-button">Reserve</button>

    </select>
    </form>
</section>