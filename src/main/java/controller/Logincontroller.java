package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logincontroller")
public class Logincontroller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve username and password from the form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Your authentication logic here (e.g., check against a database)
        boolean isAuthenticated = authenticateUser(username, password);

        if (isAuthenticated) {
            // Successful login
            // Redirect to the home page or any other page you want
            response.sendRedirect("index.jsp");
        } else {
            // Failed login
            // Set an error message as a request attribute
            request.setAttribute("errorMessage", "帳號或密碼輸入錯誤");
            // Forward the request to the login page
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Your authentication logic goes here
    private boolean authenticateUser(String username, String password) {
        // Add your authentication logic here (e.g., check against a database)
        // For simplicity, we'll assume a hardcoded username and password
        return "user".equals(username) && "1234".equals(password);
    }
}
