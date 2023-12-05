<a href="login.jsp">Login</a> | <a href="profile.jsp">Profile</a> | <a href="logout.jsp">Logout</a>

<%
session.invalidate();
out.print("You have been logged out. <a href='login.jsp'>Click here to log in again</a>");
%>
