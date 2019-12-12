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

@WebServlet(name = "/ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get User Query
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        String username = request.getParameter("username");
        System.out.println(username);
        ArrayList<String> user = new ArrayList<String>();
        try {
            user = (ArrayList<String>) searcher.getUserInfo(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Get Past, Future, All Flights Query
        List<List<String>> pastFlights = null;
        try {
            pastFlights = searcher.getPastReservation(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<List<String>> futureFlights = null;
        try {
            futureFlights = searcher.getComingReservations(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<List<String>> allFlights = null;
        try {
            allFlights = searcher.getAllReservations(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("pastFlights", pastFlights);
        session.setAttribute("futureFlights", futureFlights);
        session.setAttribute("flights", allFlights);
        session.setAttribute("user", user);

        response.sendRedirect("Profile.jsp");
    }
}
