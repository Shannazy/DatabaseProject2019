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

@WebServlet(name = "/SummaryFlightServlet", urlPatterns = {"/SummaryFlightServlet"})
public class SummaryFlightServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flightNumber = request.getParameter("summary-flight");
        String airline = request.getParameter("summary-airline");
        String user = request.getParameter("summary-user");

        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        List<List<String>> summaryListing = null;
        HttpSession session = request.getSession(true);
        System.out.println(flightNumber + airline + user);
        try {
            if (!flightNumber.equals("")) {
                summaryListing = searcher.getSalesReport("flight", flightNumber);
                session.setAttribute("query", "Flight: " + flightNumber);
            } else if (!airline.equals("")) {
                summaryListing = searcher.getSalesReport("airline", airline);
                session.setAttribute("query",  "Airline: " + airline);
            } else if (!user.equals("")) {
                summaryListing = searcher.getSalesReport("customer", user);
                session.setAttribute("query", "Customer: " + user);
            }
            System.out.println(summaryListing.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("summaryListing", summaryListing);

        response.sendRedirect("AdminSummaryListing.jsp");
    }
}
