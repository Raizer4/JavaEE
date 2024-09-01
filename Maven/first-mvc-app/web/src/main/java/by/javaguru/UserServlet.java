package by.javaguru;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       var user = service.getUser(1L);
       resp.setContentType("text/html");
       var writer = resp.getWriter();
       writer.write("<html><body>");
       writer.write("<h1> Пользователь </h1>");
       writer.write("<h2>"+ user.get().getUser() +"</h2>");
       writer.write("</html></body>");
       writer.close();
    }
}
