<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<nav>
    <a href="Welcome.jsp">
        <div class="nav-link">Home</div>
    </a>
    <a href="Profile.jsp">
        <div class="nav-link">Profile</div>
    </a>
    <%
        try {
            if (session.getAttribute("role").equals("admin")) {
                out.print("<a href=\"Admin.jsp\"><div class=\"nav-link\">Admin</div>\n</a>");
            }
        } catch (Exception e) {
            out.println("error");
        }
    %>
    <%
        try {
            if (session.getAttribute("role").equals("customerRep") || session.getAttribute("role").equals("admin")) {
                out.print("<a href=\"Representative.jsp\"><div class=\"nav-link\">Representative</div>\n</a>");
            }
        } catch (Exception e) {
            out.println("error");
        }
    %>
    <a href="Login.jsp">
        <div class="nav-link">Logout</div>
    </a>
</nav>