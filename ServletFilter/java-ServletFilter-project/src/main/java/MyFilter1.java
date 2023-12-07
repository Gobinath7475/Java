import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.*;  
  
public class MyFilter1 implements Filter{  
  
public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
          
    PrintWriter out=resp.getWriter();  
          
    String password=req.getParameter("password");  
    if(password.equals("admin")){  
    chain.doFilter(req, resp);
    }  
    else{  
    out.print("username or password error!");  
    // RequestDispatcher rd=req.getRequestDispatcher("/welcome1.html");  
    // rd.include(req, resp);  
    // }  
    }
          
}  
    public void destroy() {}  
  
}  