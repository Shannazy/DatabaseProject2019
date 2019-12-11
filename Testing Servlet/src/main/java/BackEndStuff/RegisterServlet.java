package BackEndStuff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "/RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String name = request.getParameter("Full Name");
        String Phone = request.getParameter("Phone Number");
        String CreationDate = request.getParameter("Creation");
        String pass = request.getParameter("Password");
        String DOB = request.getParameter("Date of Birth");
        DatabaseConnection connector = new DatabaseConnection();
        QueryList register = new QueryList(connector);

        if(register.registerClient(email, name, Phone, CreationDate, pass, DOB)){
         response.sendRedirect("Login.jsp");
        }
        else{
            response.sendRedirect("Page404.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
