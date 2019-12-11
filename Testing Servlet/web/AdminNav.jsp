<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <form id="editUserForm" action="EditUserServlet" method="get">
        <h1>Edit User</h1>
        <div>
            <label id="edit-user-label" for="edit-user">Username</label>
            <input required type="text" name="edit-user" id="edit-user">
        </div>
        <div>
            <label id="edit-name-label" for="edit-user">Nickname</label>
            <input required type="text" name="edit-name" id="edit-name">
        </div>
        <button type="submit" form="editUserForm" value="EditUser" id="edit-button">Edit</button>
    </form>
    <form id="salesReportForm" action="SalesReportServlet" method="get">
        <h1>Sales Report</h1>
        <button type="submit" form="salesReportForm" value="SalesReport" id="sales-report-button">Get Report</button>
    </form>
    <form id="flightListForm" action="FlightListServlet" method="get">
        <h1>Get Reservations for Flight</h1>
        <div>
            <label id="flight-list-label" for="flight-list">Flight Number</label>
            <input required type="number" name="flight-list" id="flight-list">
        </div>
        <button type="submit" form="flightListForm" value="FlightList" id="flight-list-button">Get Reservations</button>
    </form>
    <form id="customerFlightForm" action="CustomerFlightServlet" method="get">
        <h1>Get Reservations for Customer</h1>
        <div>
            <label for="customer-flight">Flight Number</label>
            <input required type="text" name="customer-flight" id="customer-flight">
        </div>
        <button type="submit" form="customerFlightForm" value="CustomerFlight">Get Reservations</button>
    </form>
    <a href="AdminSummaryListing.jsp">
        <div class="nav-link">Summary Lists</div>
    </a>
    <a href="AdminMostRevenue.jsp">
        <div class="nav-link">Most Revenue Client</div>
    </a>
    <a href="AdminMostActive.jsp">
        <div class="nav-link">Most Active Flights</div>
    </a>
    <a href="AdminAirportFlight.jsp">
        <div class="nav-link">Airport Flights</div>
    </a>
</nav>
