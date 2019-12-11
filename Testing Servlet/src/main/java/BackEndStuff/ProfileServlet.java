package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "/ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String email = request.getParameter("email");
//        String name = request.getParameter("Full Name");
//        String Phone = request.getParameter("Phone Number");
//        String CreationDate = request.getParameter("Creation");
//        String pass = request.getParameter("Password");
//        String DOB = request.getParameter("Date of Birth");
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("username");
        DatabaseConnection connector = new DatabaseConnection();
        QueryList register = new QueryList(connector);

        UserInfo queryResult = null;
        try {
            queryResult = register.getUserInfo(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("userInfoResult", queryResult);
        request.getRequestDispatcher("profile.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}