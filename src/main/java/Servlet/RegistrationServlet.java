package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;
import dao.UserDaoImplMySQL;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取表单参数
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        // 验证密码是否匹配
        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "密码不匹配，请重新输入。");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }

        // 创建用户对象
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // 调用DAO层进行用户注册
        UserDao userDao = new UserDaoImplMySQL();
        try {
            if (userDao.registerUser(user)) {
                // 注册成功，显示成功消息
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('註冊成功！'); window.location.href='Register.jsp';</script>");
            } else {
                request.setAttribute("errorMessage", "註冊失敗，請稍後重試。");
                request.getRequestDispatcher("/Register.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "註冊過程中出現資料庫錯誤。");
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        }
    }
}
