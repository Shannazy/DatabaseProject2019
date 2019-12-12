<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav>
    <form id="waitListForm" action="WaitingListServlet" method="get">
        <h1>Waiting List</h1>
        <div>
            <label for="wait-number">Flight Number</label>
            <input required type="number" name="wait-number" id="wait-number">
        </div>
        <button type="submit" form="waitListForm" value="WaitList">Get it now!</button>
    </form>

    <form id="addAirportForm" action="AddAirportServlet" method="get">
        <h1>Add an Airport</h1>
        <div>
            <label for="add-airport">Airport</label>
            <input required type="text" name="add-airport" id="add-airport">
        </div>
        <select style="display: none;" name="username" form="addAirportForm">\
            <option value="<% out.print(session.getAttribute("username"));%>"></option>
        </select>
        <button type="submit" form="addAirportForm" value="AirportFlights">Add Airport</button>
    </form>

</nav>
