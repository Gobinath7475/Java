import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/uploadFiles", initParams = {
                @WebInitParam(name = "location", value = "D:/Uploads"),
                @WebInitParam(name = "maxUploadSize", value = "9900000")
})
public class FileUploadServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String location = getInitParameter("location");
                resp.getWriter().println(location);
                doPost(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String maxUploadSize = getInitParameter("maxUploadSize");
                resp.getWriter().println(maxUploadSize);
        }
}