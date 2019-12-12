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

@WebServlet(name = "/AddAirportServlet", urlPatterns = {"/AddAirportServlet"})
public class AddAirportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String airport = request.getParameter("add-airport");
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        searcher.addToAirport(airport);
        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        response.sendRedirect("Representative.jsp");
    }
}