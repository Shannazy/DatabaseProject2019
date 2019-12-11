package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "/SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type  = request.getParameter("type");
        String flex  = request.getParameter("flex");
        String sort = request.getParameter("sort");
        String lowPrice = request.getParameter("low-price");
        String highPrice = request.getParameter("high-price");
        String lowStops = request.getParameter("low-stops");
        String highStops = request.getParameter("high-stops");
        String airline = request.getParameter("airline");
        String airportDepart = request.getParameter("airport-depart");
        String airportDest = request.getParameter("airport-dest");

        System.out.println("type: " + type);
        System.out.println("flex: " + flex);
        System.out.println("sort: " + sort);
        System.out.println("lowPrice: " + lowPrice);
        System.out.println("highPrice: " + highPrice);
        System.out.println("lowStops: " + lowStops);
        System.out.println("highStops: " + highStops);
        System.out.println("Airline: " + airline);
        System.out.println("airportDepart: " + airportDepart);
        System.out.println("airportDest: " + airportDest);
        System.out.println("username: " + request.getParameter("username"));

        final ArrayList<String> flight1 = new ArrayList<String>(){
            {
                add("1");
                add("May 10");
                add("May 10");
                add("ABC");
                add("XYZ");
                add("AA");
                add("365");
            }
        };
        final ArrayList<String> flight2 = new ArrayList<String>(){
            {
                add("2");
                add("May 11");
                add("May 11");
                add("XYZ");
                add("ABC");
                add("BB");
                add("366");
            }
        };
        final ArrayList<String> flight3 = new ArrayList<String>(){
            {
                add("3");
                add("May 12");
                add("May 12");
                add("WTY");
                add("YTW");
                add("CC");
                add("563");
            }
        };
        // Query Flights that match the sort/filter
        ArrayList<ArrayList<String>> tempFlights = new ArrayList<ArrayList<String>>(){
            {
                add(flight1);
                add(flight2);
                add(flight3);
            }
        };

        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("flights", tempFlights);

        response.sendRedirect("Reserve.jsp");
    }
}
