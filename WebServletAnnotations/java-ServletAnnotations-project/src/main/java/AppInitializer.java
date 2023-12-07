import java.util.Set;
import javax.servlet.Filter;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes({
    javax.servlet.http.HttpServlet.class,
    javax.servlet.Filter.class
})
public class AppInitializer implements ServletContainerInitializer {
 
    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext context) throws ServletException {
        if (classes != null) {
            for (Class<?> clazz : classes)
            {
                if (javax.servlet.http.HttpServlet.class.isAssignableFrom(clazz)) 
                {
                    System.out.println("true");
                } 
                else if (javax.servlet.Filter.class.isAssignableFrom(clazz)) 
                {
                System.out.println("false");
                }
            }
        }
    }
}
