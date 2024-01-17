package com.note.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        // JDBC连接参数
        String url = "jdbc:mysql://localhost:3306/note";
        String username = "web";
        String password = "12345678";

        // 要插入的数据
        String userNameToInsert = "John Doe";
        String emailToInsert = "john.doe@example.com";
        String passwordToInsert = "secret123";

        // 尝试建立连接
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String insertQuery = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, userNameToInsert);
                preparedStatement.setString(2, emailToInsert);
                preparedStatement.setString(3, passwordToInsert);

                int rowsAffected = preparedStatement.executeUpdate();

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
