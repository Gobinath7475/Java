import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        PrintWriter out = resp.getWriter();

        String name = req.getParameter("username");
        String password = req.getParameter("userpass");

        if (name == null && password == null) {
            out.print("Please enter a valid username and password");
        } else if (LoginDao.validate(name, password)) {
            HttpSession session = ((HttpServletRequest) req).getSession();
            session.setAttribute("username", name);
            RequestDispatcher rd = req.getRequestDispatcher("servlet2");
            rd.forward(req, resp);
        } else {
            out.print("Sorry, username or password error");
        }

    }

    public void destroy() {
    }

}