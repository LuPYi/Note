package Servlet;



import dao.UserDao;
import dao.UserDaoImplMySQL;
import User.User; // Import the User class if needed

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private UserDao userDao = new UserDaoImplMySQL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        if (userDao.registerUser(user)) {
            // Registration successful, redirect to a success page
            response.sendRedirect("registration-success.jsp");
        } else {
            // Registration failed, set error message and forward to the registration page
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            //request.getRequestDispatcher("registration.jsp").forward(request, response);
        }
    }
}
