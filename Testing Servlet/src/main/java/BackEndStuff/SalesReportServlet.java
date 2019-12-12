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

@WebServlet(name = "/SalesReportServlet", urlPatterns = {"/SalesReportServlet"})
public class SalesReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String month = request.getParameter("month");
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        // Get Sales Report Query
        List<List<String>> salesReport = null;
        try {
            salesReport = searcher.getSalesReportForMonth(month);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("month", request.getParameter("month"));
        session.setAttribute("salesReport", salesReport);

        response.sendRedirect("AdminSalesReport.jsp");
    }
}
