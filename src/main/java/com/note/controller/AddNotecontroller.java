package com.note.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AddNotecontroller")
public class AddNotecontroller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 獲取表單輸入
        String subject = request.getParameter("subject");
        String context = request.getParameter("context");

        // 在實際應用中，你應該優先使用連接池而不是在Servlet中直接建立連接
        String jdbcUrl = "jdbc:mysql://localhost:3306/note";
        String username = "web";
        String password = "12345678";

        try {
            // 載入JDBC驅動
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立資料庫連接
            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                // 準備SQL語句
                String sql = "INSERT INTO notebook (subject, context) VALUES (?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    // 設定參數值
                	preparedStatement.setString(1, subject);
                    preparedStatement.setString(2, context);

                    // 執行SQL語句
                    preparedStatement.executeUpdate();
                }
            }
         // 新增成功，發送通知
            String notificationMessage = "新增成功！";
            request.setAttribute("notificationMessage", notificationMessage);
        
         // 重新導向到成功頁面或其他適當的操作
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}

