package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "/SalesReportServlet", urlPatterns = {"/SalesReportServlet"})
public class SalesReportServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get Sales Report Query
        ArrayList<ArrayList<String>> salesReport = new ArrayList<ArrayList<String>>();

        HttpSession session = request.getSession(true);
        session.setAttribute("username", request.getParameter("username"));
        session.setAttribute("salesReport", salesReport);

        response.sendRedirect("AdminSalesReport.jsp");
    }
}
