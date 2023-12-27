package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import beans.User;

@Repository("UserDaoImplMySQL")
public class UserDaoImplMySQL implements UserDao {
    String URL = "jdbc:mysql://localhost:3306/note";
    String USER = "web";
    String PASSWORD = "12345678";

    private Connection connection;

    public UserDaoImplMySQL() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean registerUser(User user) {
        if (connection == null) {
            System.err.println("資料庫連接錯誤!!!");
            return false;
        }

        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}