// import java.io.IOException;
 
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebInitParam;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
 
// @WebServlet(
//     urlPatterns = "/welcome",
//     initParams = {
//         @WebInitParam(name = "dname", value = "jdbc connection")
//     }
// )
 
// public class MyServlet extends HttpServlet {
//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//     String driver = getInitParameter("dname");
       
//         request.setAttribute("driver", driver);
//         request.getRequestDispatcher("/welcome.jsp").forward(request, response);
// }
// }