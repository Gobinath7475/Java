import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/admin/*")
public class FilterTwo implements Filter {
 
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("Initialized ");
    }
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("FilterTwo before chain");
        chain.doFilter(request, response);
        System.out.println("FilterTwo after chain");
    }
     
    @Override
    public void destroy() {
        System.out.println("Destroyed");
    }
}
