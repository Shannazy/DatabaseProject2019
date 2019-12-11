package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "/ReserveServlet", urlPatterns = {"/ReserveServlet"})
public class ReserveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Update Client_Has Table

        HttpSession session = request.getSession(true);
        String flightNumber = request.getParameter("flightNumber");
        String username = session.getAttribute("username").toString();
        System.out.println("flightNumber: " + flightNumber);
        System.out.println("username: " + username);
        session.setAttribute("username", request.getParameter("username"));
        session.removeAttribute("flights");

        response.sendRedirect("Welcome.jsp");
    }
}
