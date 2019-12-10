<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<section>
    <form id="searchForm" action="SearchServlet" method="get">

        <label id="type-label" for="type">Trip Type</label>
        <select id="type" name="type" form="searchForm">
            <option value="oneWay">One Way</option>
            <option value="round">Round Trip</option>
        </select>

        <label id="flex-label" for="flex">Flexibility</label>
        <select id="flex" name="flex" form="searchForm">
            <option value="-3">-3</option>
            <option value="-2">-2</option>
            <option value="-1">-1</option>
            <option value="0">0</option>
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>

        <label id="sort-label" for="sort">Sort by</label>
        <select id="sort" name="sort" form="searchForm">
            <option value="priceDescending">Price High to Low</option>
            <option value="priceAscending">Price Low to High</option>
            <option value="lateTakeoffTime">Takeoff Time Latest to Earliest</option>
            <option value="earlyTakeoffTime">Takeoff Time Earliest to Latest</option>
            <option value="lateLandingTime">Landing Time Latest to Earliest</option>
            <option value="earlyLandingTime">Landing Time Earliest to Latest</option>
        </select>

        <label id="price-label">Price Range</label>
        <label id="low-price-label">Low</label>
        <input type="number" name="low-price" id="low-price">
        <label id="high-price-label">High</label>
        <input type="number" name="high-price" id="high-price">

        <label id="stops-label">Number of Stops</label>
        <label id="low-stops-label">Low</label>
        <input type="number" name="low-stops" id="low-stops">
        <label id="high-stops-label">High</label>
        <input type="number" name="high-stops" id="high-stops">

        <label id="airline-label" for="airline">Airlines</label>
        <select multiple id="airline" name="airline" form="searchForm">
            <c:forEach var="airline" items="${session.getAttribute('airlines')}">
                <option value="${airline}"><c:out value = "${airline}"/><</option>
            </c:forEach>
        </select>

        <label id="aiport-depart-label" for="airport-depart">Departing Airport</label>
        <select id="airport-depart" name="airport-depart" form="searchForm">
            <c:forEach var="airport" items="${session.getAttribute('airports')}">
                <option value="${airport}"><c:out value = "${airport}"/><</option>
            </c:forEach>
        </select>

        <label id="aiport-dest-label" for="airport-dest">Destination Airport</label>
        <select id="airport-dest" name="airport-dest" form="searchForm">
            <c:forEach var="airport" items="${session.getAttribute('airports')}">
                <option value="${airport}"><c:out value = "${airport}"/><</option>
            </c:forEach>
        </select>

        <button type="submit" form="searchForm" value="Register" id="search-button">Search</button>
    </form>
</section>