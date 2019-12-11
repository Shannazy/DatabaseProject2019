package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "/AirportFlightsServlet", urlPatterns = {"/AirportFlightsServlet"})
public class AirportFlightsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String airport = request.getParameter("airport-flights");

        // Get List of Flights from Airport
        ArrayList<ArrayList<String>> airportFlights = new ArrayList<ArrayList<String>>();

        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("airportFlights", airportFlights);

        response.sendRedirect("AdminAirportFlight.jsp");
    }
}
