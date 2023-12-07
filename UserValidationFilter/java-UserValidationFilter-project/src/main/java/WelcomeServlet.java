import java.io.IOException;    
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
  
public class WelcomeServlet extends HttpServlet {  

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
public void doPost(HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException {  
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
 
        if (username != null) {
            response.getWriter().println("Welcome, " + username + "!");
        } else {
            response.sendRedirect("/index.html");
        }
  
    // response.setContentType("text/html");  
    // PrintWriter out = response.getWriter();  
          
    // String n=request.getParameter("username");  
    // out.print("Welcome "+n);  
          
    // out.close();  
    }  
  
}