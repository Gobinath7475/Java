<a href="login.jsp">Login</a> | <a href="profile.jsp">Profile</a> | <a href="logout.jsp">Logout</a>

<%
if (session.getAttribute("session") != null) {
    %>
    <h3>Welcome to Your Profile</h3>
    <p>This is a protected page that can only be accessed when you are logged in.</p>
    <%
} else {
    response.sendRedirect("login.jsp");
}
%>
