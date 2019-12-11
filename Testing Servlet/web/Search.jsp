<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<section>
    <form id="searchForm" action="SearchServlet" method="get">

        <div>
            <label id="type-label" for="type">Trip Type</label>
            <select id="type" name="type" form="searchForm">
                <option value="oneWay">One Way</option>
                <option value="round">Round Trip</option>
            </select>
        </div>

        <div>
            <label id="flex-label" for="flex">Flexibility</label>
            <select id="flex" name="flex" form="searchForm">
                <option value="true">true</option>
                <option value="false">false</option>
            </select>
        </div>

        <div>
            <label id="sort-label" for="sort">Sort by</label>
            <select id="sort" name="sort" form="searchForm">
                <option value="priceDescending">Price High to Low</option>
                <option value="priceAscending">Price Low to High</option>
                <option value="lateTakeoffTime">Takeoff Time Latest to Earliest</option>
                <option value="earlyTakeoffTime">Takeoff Time Earliest to Latest</option>
                <option value="lateLandingTime">Landing Time Latest to Earliest</option>
                <option value="earlyLandingTime">Landing Time Earliest to Latest</option>
            </select>
        </div>

        <div>
            <label id="price-label">Price Range</label>
            <label id="low-price-label">Low</label>
            <input type="number" name="low-price" id="low-price">
            <label id="high-price-label">High</label>
            <input type="number" name="high-price" id="high-price">
        </div>

        <div>
            <label id="stops-label">Number of Stops</label>
            <label id="low-stops-label">Low</label>
            <input type="number" name="low-stops" id="low-stops">
            <label id="high-stops-label">High</label>
            <input type="number" name="high-stops" id="high-stops">
        </div>

        <div>
            <label id="airline-label" for="airline">Airlines</label>
            <select id="airline" name="airline" form="searchForm">
                <%
                    List<String> airlines = (List<String>) session.getAttribute("airlines");
                    for (int i = 0; i < airlines.size(); i++) {
                %>
                <option value="<% out.print(airlines.get(i));%>"><% out.print(airlines.get(i));%></option>
                <% }%>
            </select>
        </div>

        <div>
            <label id="airport-depart-label" for="airport-depart">Departing Airport</label>
            <select id="airport-depart" name="airport-depart" form="searchForm">
                <%
                    List<String> airportDepart = (List<String>) session.getAttribute("airportDepart");
                    for (int i = 0; i < airportDepart.size(); i++) {
                %>
                <option value="<% out.print(airportDepart.get(i));%>"><% out.print(airportDepart.get(i));%></option>
                <% }%>
            </select>
        </div>


        <div>
            <label id="airport-dest-label" for="airport-dest">Destination Airport</label>
            <select id="airport-dest" name="airport-dest" form="searchForm">
                <%
                    List<String> airportDest = (List<String>) session.getAttribute("airportDest");
                    for (int i = 0; i < airportDest.size(); i++) {
                %>
                <option value="<% out.print(airportDest.get(i));%>"><% out.print(airportDest.get(i));%></option>
                <% }%>
            </select>
        </div>

        <select style="display: none;" id="username" name="username" form="searchForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>

        <button type="submit" form="searchForm" value="Search" id="search-button">Search</button>
    </form>
</section>