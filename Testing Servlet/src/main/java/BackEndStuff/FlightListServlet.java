package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "/FlightListServlet", urlPatterns = {"/FlightListServlet"})
public class FlightListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        String user = request.getParameter("flight-list");
        String nickname = request.getParameter("customer-flight");

        // Get Flights list
        ArrayList<ArrayList<String>> flightList = null;
        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("flightList", flightList);

        response.sendRedirect("AdminFlightList.jsp");
    }
}
