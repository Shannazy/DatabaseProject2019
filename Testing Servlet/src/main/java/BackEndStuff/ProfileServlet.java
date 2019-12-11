package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "/ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("username");
        DatabaseConnection connector = new DatabaseConnection();
        QueryList register = new QueryList(connector);

        List<String> queryResult = new ArrayList<String>();
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