import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("/process")
// @ServletSecurity
// public class MyServlet extends HttpServlet {
//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         resp.getWriter().println("Process runs");
//     }
// }

import javax.servlet.annotation.ServletSecurity.EmptyRoleSemantic;

// @WebServlet("/manage")
// @ServletSecurity(@HttpConstraint(rolesAllowed = "admin"))
// public class AdminServlet extends HttpServlet {
//     @Override
//     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         resp.getWriter().println("manage runs");
//     }
// }

@WebServlet("/manage")
@ServletSecurity(
 httpMethodConstraints = {
  @HttpMethodConstraint(value = "GET", rolesAllowed = "admin"),
  @HttpMethodConstraint(value = "POST", rolesAllowed = "admin",
                        transportGuarantee = TransportGuarantee.CONFIDENTIAL),      
 }
)
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("security runs get");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("security runs post");
    }
}

// @WebServlet("/process")
// @ServletSecurity(
//         httpMethodConstraints = @HttpMethodConstraint(value = "GET", emptyRoleSemantic = EmptyRoleSemantic.DENY))
// public class MyServlet extends HttpServlet {
//     @Override
//     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//         resp.getWriter().println("security runs");
//     }
// }
