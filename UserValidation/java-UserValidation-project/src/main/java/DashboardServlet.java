import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        //session.setAttribute("uname", "xyz");
        String username = (String) session.getAttribute("username");

        if (username != null) {
            response.getWriter().println("Welcome, " + username + "!");
        }
        else {
            response.sendRedirect("/index.jsp");
        }
    }
}