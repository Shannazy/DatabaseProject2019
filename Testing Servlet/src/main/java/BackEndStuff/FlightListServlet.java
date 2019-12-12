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

@WebServlet(name = "/FlightListServlet", urlPatterns = {"/FlightListServlet"})
public class FlightListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        String flight = request.getParameter("flight-list");
        String customer = request.getParameter("customer-flight");
        List<List<String>> flightList = null;

        // Get Flights list
        HttpSession session = request.getSession(true);
        try {
            if (!flight.equals("")) {
                flightList = searcher.getSpecificReservations("Flight", flight);
                session.setAttribute("query", "Flight: " + flight);
            } else if (!customer.equals("")) {
                flightList = searcher.getSpecificReservations("Client", customer);
                session.setAttribute("query", "Client: " + customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("flightList", flightList);

        response.sendRedirect("AdminFlightList.jsp");
    }
}
