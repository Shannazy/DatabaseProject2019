<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<nav>
    <a href="Welcome.jsp">
        <div class="nav-link">Home</div>
    </a>
    <a href="Profile.jsp">
        <div class="nav-link">Profile</div>
    </a>
    <c:if test = "${session.getAttribute('role').equals('admin')}">
        <a href="Admin.jsp">
            <div class="nav-link">Admin</div>
        </a>
    </c:if>
    <c:if test = "${session.getAttribute('role').equals('admin') || session.getAttribute('role').equals('rep')}">
        <a href="Representative.jsp">
            <div class="nav-link">Customer Representative</div>
        </a>
    </c:if>
    <a href="Login.jsp">
        <div class="nav-link">Logout</div>
    </a>
</nav>