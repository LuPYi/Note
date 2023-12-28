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
    String jdbcUrl = "jdbc:mysql://localhost:3306/note";
    String dbUser = "web";
    String dbPassword = "12345678";

    private Connection connection;

    public UserDaoImplMySQL() {
        establishConnection();
    }

    private void establishConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
            System.out.println("Connected to the database!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean registerUser(User user) {
        if (connection == null) {
            System.err.println("Database connection error!");
            return false;
        }

        String query = "insert into user (name, email, password) values (?, ?, ?)";

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
