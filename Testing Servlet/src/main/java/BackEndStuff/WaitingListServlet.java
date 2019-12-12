package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WaitingListServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        HttpSession session = request.getSession(true);
        String flightNumber = request.getParameter("wait-number");
        String username = session.getAttribute("username").toString();
        System.out.println("username: " + username);
        session.setAttribute("username", request.getParameter("username"));
        List<List<String>> user = null;
        user = searcher.getCustomersOnWaitlist(flightNumber);
        session.setAttribute("flights", user);
        response.sendRedirect("RepGetWaitingList.jsp");
    }
}