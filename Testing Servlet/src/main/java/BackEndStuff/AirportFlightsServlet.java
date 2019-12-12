package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "/AirportFlightsServlet", urlPatterns = {"/AirportFlightsServlet"})
public class AirportFlightsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String airport = request.getParameter("airport-flights");
        System.out.println(airport);
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);

        // Get List of Flights from Airport
        List<List<String>> arrivalFlights = null;
        List<List<String>> departFlights = null;
        try {
            arrivalFlights = searcher.getArrivalToAirport(airport);
            departFlights = searcher.getDeparturesFromAirport(airport);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("airport", airport);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("arrive", arrivalFlights);
        session.setAttribute("depart", departFlights);

        response.sendRedirect("AdminAirportFlight.jsp");
    }
}
