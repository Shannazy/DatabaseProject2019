package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/ReserveServlet", urlPatterns = {"/ReserveServlet"})
public class ReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String flightNumber = request.getParameter("flightNumber");
        String username = session.getAttribute("username").toString();
        System.out.println("flightNumber: " + flightNumber);
        System.out.println("username: " + username);
        session.setAttribute("username", request.getParameter("username"));

        // Update Client_Has Table
        DatabaseConnection myConnection = new DatabaseConnection();
        QueryList searcher = new QueryList(myConnection);
        List<List<String>> flightInfo = searcher.querySpecFlight(flightNumber);
        System.out.println(flightInfo.get(0).toString());
        searcher.addTicketentry(
                username,
                flightInfo.get(0).get(0),
                flightInfo.get(0).get(10),
                "One-Way",
                null
        );


        response.sendRedirect("Welcome.jsp");
    }
}
