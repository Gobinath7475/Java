import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
 
// import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
 
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
@WebServlet("/book/*")
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO = new BookDAO();
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        System.out.println(req.getServletPath());
 
        if (pathInfo != null && pathInfo.length() > 1) {
            pathInfo = pathInfo.substring(1); // Remove the leading slash
            System.out.println("PathInfo: " + pathInfo);
        } else
            try {
 
                System.out.println("No PathInfo provided");
                List<Book> listBook = bookDAO.listAllBooks();
                req.setAttribute("listBook", listBook);
                System.out.println(listBook);
                String json = new Gson().toJson(listBook);
 
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(json);
                // RequestDispatcher dispatcher = req.getRequestDispatcher("BookList.jsp");
                // dispatcher.forward(req, resp);
 
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }
 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        System.out.println(requestData);
        Book newBook = new Gson().fromJson(requestData, Book.class);
        System.out.println(newBook.getTitle()+" "+newBook.getAuthor());
        try {
            bookDAO.insertBook(newBook);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
    }
 
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        System.out.println(requestData);
        Book newBook = new Gson().fromJson(requestData, Book.class);
        System.out.println(newBook.getTitle()+" "+newBook.getAuthor());
        try {
            bookDAO.updateBook(newBook);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestData = req.getReader().lines().collect(Collectors.joining());
        System.out.println(requestData);
        Book newBook = new Gson().fromJson(requestData, Book.class);
        System.out.println(newBook.getTitle()+" "+newBook.getAuthor());
        try {
            bookDAO.deleteBook(newBook);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}