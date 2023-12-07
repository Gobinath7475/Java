import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class UserValidationListener implements ServletContextListener {
    // This map will store authenticated user sessions.
    private Map<String, String> authenticatedUsers;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        authenticatedUsers = new HashMap<>();
        context.setAttribute("authenticatedUsers", authenticatedUsers);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context destroyed");
    }
}