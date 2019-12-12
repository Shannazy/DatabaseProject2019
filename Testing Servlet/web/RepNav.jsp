<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <form id="editUserForm" action="EditUserServlet" method="get">
        <h1>Edit User</h1>
        <div>
            <label id="edit-user-label" for="edit-user">Username</label>
            <input required type="text" name="edit-user" id="edit-user">
        </div>
        <div>
            <label id="edit-name-label" for="edit-name">Nickname</label>
            <input required type="text" name="edit-name" id="edit-name">
        </div>
        <select style="display: none;" name="username" form="editUserForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="editUserForm" value="EditUser" id="edit-button">Edit</button>
    </form>

    <form id="salesReportForm" action="SalesReportServlet" method="get">
        <h1>Sales Report</h1>
        <div>
            <label id="month-label" for="month">Month</label>
            <select name="month" form="salesReportForm" id="month">\
                <option value="January">January</option>
                <option value="February">January</option>
                <option value="March">March</option>
                <option value="April">April</option>
                <option value="May">May</option>
                <option value="June">June</option>
                <option value="July">July</option>
                <option value="August">August</option>
                <option value="September">September</option>
                <option value="October">October</option>
                <option value="November">November</option>
                <option value="December">December</option>
            </select>
        </div>
        <select style="display: none;" name="username" form="salesReportForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="salesReportForm" value="SalesReport" id="sales-report-button">Get Report</button>
    </form>

    <form id="flightListForm" action="FlightListServlet" method="get">
        <h1>Get Reservations for Flight</h1>
        <div>
            <label id="flight-list-label" for="flight-list">Flight Number</label>
            <input type="number" name="flight-list" id="flight-list">
        </div>
        <div>
            <label for="customer-flight">Username</label>
            <input type="text" name="customer-flight" id="customer-flight">
        </div>
        <select style="display: none;" name="username" form="flightListForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="flightListForm" value="FlightList" id="flight-list-button">Get Reservations</button>
    </form>

    <form id="summaryFlightForm" action="SummaryFlightServlet" method="get">
        <h1>Summary Flight</h1>
        <div>
            <label for="summary-flight">Flight Number</label>
            <input type="text" name="summary-flight" id="summary-flight">
        </div>
        <div>
            <label for="summary-airline">Airline</label>
            <input type="text" name="summary-airline" id="summary-airline">
        </div>
        <div>
            <label for="summary-user">Username</label>
            <input type="text" name="summary-user" id="summary-user">
        </div>
        <select style="display: none;" name="username" form="summaryFlightForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="summaryFlightForm" value="SummaryFlight">Get Revenue</button>
    </form>

    <form id="mostRevenueForm" action="MostRevenueServlet" method="get">
        <h1>Most Revenue Customer</h1>
        <select style="display: none;" name="username" form="mostRevenueForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="mostRevenueForm" value="mostRevenue">Get User</button>
    </form>

    <form id="mostActiveForm" action="MostActiveServlet" method="get">
        <h1>Most Active Flights</h1>
        <select style="display: none;" name="username" form="mostActiveForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="mostActiveForm" value="mostRevenue">Get Flights</button>
    </form>

    <form id="airportFlightsForm" action="AirportFlightsServlet" method="get">
        <h1>Get All Flights at an Airport</h1>
        <div>
            <label for="airport-flights">Airport</label>
            <input required type="text" name="airport-flights" id="airport-flights">
        </div>
        <select style="display: none;" name="username" form="airportFlightsForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="airportFlightsForm" value="AirportFlights">Get Flights</button>
    </form>
</nav>
