<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
            <label id="sort-label" for="sort">Sort by Low to High</label>
            <select id="sort" name="sort" form="searchForm">
                <option value="Price">Price</option>
                <option value="Destination Time">Destination Time</option>
                <option value="Destination Date">Destination Date</option>
                <option value="Departure Date">Destination Date</option>
                <option value="Departure Time">Departure Time</option>
            </select>
        </div>

        <div>
            <label id="date-label" for="date">Date</label>
            <input type="date" name="date" id="date">
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
                    ArrayList<String> airlines = (ArrayList<String>) (session.getAttribute("airlines"));
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
                    ArrayList<String> airportDepart = (ArrayList<String>) session.getAttribute("airportDepart");
                    for (String airport : airportDepart) {
                %>
                <option value="<% out.print(airport);%>"><% out.print(airport);%></option>
                <% }%>
            </select>
        </div>


        <div>
            <label id="airport-dest-label" for="airport-dest">Destination Airport</label>
            <select id="airport-dest" name="airport-dest" form="searchForm">
                <%
                    ArrayList<String> airportDest = (ArrayList<String>) session.getAttribute("airportDest");
                    for (String airport : airportDest) {
                %>
                <option value="<% out.print(airport);%>"><% out.print(airport);%></option>
                <% }%>
            </select>
        </div>

        <select style="display: none;" id="username" name="username" form="searchForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>

        <button type="submit" form="searchForm" value="Search" id="search-button">Search</button>
    </form>
</section>