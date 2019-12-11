package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "/LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("User");
        String pass = request.getParameter("Password");
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        ArrayList<String> tempAirlines = new ArrayList<String>();
        tempAirlines.add("AA");
        tempAirlines.add("AC");
        tempAirlines.add("AZ");
        ArrayList<String> tempAirports = new ArrayList<String>();
        tempAirports.add("ABR");
        tempAirports.add("ABI");
        tempAirports.add("ADL");
        if(searcher.searchAdmins(username, pass)){
            HttpSession session = request.getSession(true);
            session.setAttribute("airlines", tempAirlines);
            session.setAttribute("airportDepart", tempAirports);
            session.setAttribute("airportDest", tempAirports);
            session.setAttribute("username", username);
            session.setAttribute("role", "admin");
            response.sendRedirect("Welcome.jsp");
        }
        else if (searcher.searchclients(username, pass)){
            HttpSession session = request.getSession(true);
            session.setAttribute("airlines", tempAirlines);
            session.setAttribute("airportDepart", tempAirports);
            session.setAttribute("airportDest", tempAirports);
            session.setAttribute("username", username);
            session.setAttribute("role", "client");
            response.sendRedirect("Welcome.jsp");
        }
        else{
            response.sendRedirect("Page404.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
