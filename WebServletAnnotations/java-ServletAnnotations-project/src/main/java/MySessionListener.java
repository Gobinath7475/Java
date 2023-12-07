import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
@WebListener("Session listener for the application")
public class MySessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        System.out.println("attributeAdded");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        System.out.println("attributeRemoved");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        System.out.println("attributeReplaced");
    }

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
         System.out.println("sessionCreated");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("sessionDestroyed");
    }
 
}