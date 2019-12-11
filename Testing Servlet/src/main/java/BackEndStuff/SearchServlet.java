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
        String type = request.getParameter("type").equals("")
                ? null
                : request.getParameter("type");
        String date = request.getParameter("date");
        String flex = request.getParameter("flex").equals("")
                ? null
                : request.getParameter("flex");
        String sort = request.getParameter("sort").equals("")
                ? null
                : request.getParameter("sort");
        String lowPrice = request.getParameter("low-price").equals("")
                ? null
                : request.getParameter("low-price");
        String highPrice = request.getParameter("high-price").equals("")
                ? null
                : request.getParameter("high-price");
        String lowStops = request.getParameter("low-stops").equals("")
                ? null
                : request.getParameter("low-stops");
        String highStops = request.getParameter("high-stops").equals("")
                ? null
                : request.getParameter("high-stops");
        String airline = request.getParameter("airline").equals("")
                ? null
                : request.getParameter("airline");
        String airportDepart = request.getParameter("airport-depart").equals("")
                ? null
                : request.getParameter("airport-depart");
        String airportDest = request.getParameter("airport-dest").equals("")
                ? null
                : request.getParameter("airport-dest");


        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        List<List<String>> flights = searcher.dynamicQuery(
                date,
                airportDepart,
                airportDest,
                lowPrice,
                highPrice,
                airline,
                flex.equals("true"),
                sort
        );

        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("flights", flights);

        response.sendRedirect("Reserve.jsp");
    }
}
