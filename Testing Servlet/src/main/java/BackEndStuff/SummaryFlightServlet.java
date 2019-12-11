package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "/SummaryFlightServlet", urlPatterns = {"/SummaryFlightServlet"})
public class SummaryFlightServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String flightNumber = request.getParameter("summary-flight");
        String airline = request.getParameter("summary-airline");
        String user = request.getParameter("summary-user");

        // Get Summary Listing
        ArrayList<ArrayList<String>> summaryListing = new ArrayList<ArrayList<String>>();

        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("summaryListing", summaryListing);

        response.sendRedirect("AdminSummaryListing.jsp");
    }
}
