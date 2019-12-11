package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "/ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get User Query
        ArrayList<String> user = new ArrayList<String>();
        user.add("Email");
        user.add("Name");
        user.add("Phone");
        user.add("creationDate");
        user.add("DOB");
        // Get Past, Future, All Flights Query
        ArrayList<ArrayList<String>> pastFlights = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> futureFlights = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allFlights = new ArrayList<ArrayList<String>>();

        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("pastFlights", pastFlights);
        session.setAttribute("futureFlights", futureFlights);
        session.setAttribute("flights", allFlights);
        session.setAttribute("user", user);

        response.sendRedirect("Profile.jsp");
    }
}
