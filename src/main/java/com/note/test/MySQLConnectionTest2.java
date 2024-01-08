package com.note.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MySQLConnectionTest2 {
    public static void main(String[] args) {
        // JDBC连接参数
        String url = "jdbc:mysql://localhost:3306/note";
        String username = "web";
        String password = "12345678";

        // 要插入的数据
        String Subject = "Test Subject";
        String Context = "Test Context";
        
        // 尝试建立连接
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL插入语句
            String insertQuery = "INSERT INTO notebook (subject, context ) VALUES (?, ?)";

            // 使用PreparedStatement预编译SQL语句，防止SQL注入攻击
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                // 设置参数
                preparedStatement.setString(1, Subject);
                preparedStatement.setString(2, Context);
                

                // 执行插入操作
                int rowsAffected = preparedStatement.executeUpdate();

                // 获取自动生成的ID
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        long generatedId = generatedKeys.getLong(1);
                        System.out.println("Generated ID: " + generatedId);
                    }
                }

                // 输出插入结果
                if (rowsAffected > 0) {
                    System.out.println("Insert successful. " + rowsAffected + " row(s) affected.");
                } else {
                    System.out.println("Insert failed.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Insert failed. Error message: " + e.getMessage());
        }
    }
}
