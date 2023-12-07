import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
        urlPatterns = "/filter",
        initParams = @WebInitParam(name = "fileTypes", value = "doc;xls;zip")
)
public class UploadFilter implements Filter {


     public void init(FilterConfig filterConfig) throws ServletException {
        String fileTypes = filterConfig.getInitParameter("fileTypes");
        System.out.println(fileTypes);
    }

    @Override
    public boolean accept(Object entry) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }
}

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(
        urlPatterns = "/uploadFilter",
        initParams = @WebInitParam(name = "fileTypes", value = "doc;xls;zip")
)
public class UploadFilter implements Filter {
    private String fileTypes;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialize the filter, retrieve the "fileTypes" parameter from the configuration
        this.fileTypes = filterConfig.getInitParameter("fileTypes");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if (request.getParameter("fileType") != null) {
            String fileType = request.getParameter("fileType");
            if (!fileTypes.contains(fileType)) {
                response.getWriter().write("File type not allowed.");
                return; 
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
       System.out.println("Destroyed");
    }
}