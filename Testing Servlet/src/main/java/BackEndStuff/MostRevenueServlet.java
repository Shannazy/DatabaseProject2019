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

@WebServlet(name = "/MostRevenueServlet", urlPatterns = {"/MostRevenueServlet"})
public class MostRevenueServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Most Revenue Customer
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        String username = request.getParameter("username");
        System.out.println(username);
        ArrayList<String> mostRevenue = new ArrayList<String>();
        try {
            mostRevenue = (ArrayList<String>) searcher.getGreatestTotalRevenue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("mostRevenue", mostRevenue);

        response.sendRedirect("AdminMostRevenue.jsp");
    }
}