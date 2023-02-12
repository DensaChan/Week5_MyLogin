package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import manager.AccountService;
import models.User;

/**
 *
 * @author Densa
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
                
        String logout = request.getParameter("logout");
        if (logout != null) {
            request.setAttribute("message", "You have been succesfully logged out!");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            session.invalidate();
            return;
        }
        
        String username = (String) session.getAttribute("username");
        if (username != null) {
            response.sendRedirect("home");
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Attributes
        HttpSession session = request.getSession();
        AccountService service = new AccountService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username != null && password != null) {
            User user = service.login(username, password);
            if (user != null) {
                session.setAttribute("username", username);
                response.sendRedirect("home");
            } else {
                // checks if the user input are correct or not
                request.setAttribute("message", "invalid inputs,");
                // sets the inputs the same from previous input
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            // if the one of the inputs is missing
            request.setAttribute("message", "Please fill all input boxes");
            // keeps the previous inputs
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
    }
}
