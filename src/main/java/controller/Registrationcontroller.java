package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import dao.UserDaoImplMySQL;
import beans.User;

@WebServlet("/Registrationcontroller")
public class Registrationcontroller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 獲取表單數據
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        // 簡單的密碼驗證
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "密碼不匹配");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            return;
        }

        // 使用 UserDao 進行註冊
        UserDao userDao = new UserDaoImplMySQL();
        User user = new User(name, email, password);

        try {
            if (userDao.registerUser(user)) {
                response.sendRedirect("Register.jsp");
            } else {
                request.setAttribute("errorMessage", "註冊失敗");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
        } finally {
        	
    }
}
}