package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class UserDaoImplMySQL implements UserDao {

    private Connection connection;

    public UserDaoImplMySQL() {
        // 在构造函数中进行数据库连接
        establishConnection();
    }

    private void establishConnection() {
        try {
            // 用你的 MySQL 数据库凭据替换这些详细信息
            String jdbcUrl = "jdbc:mysql://localhost:3306/note";
            String dbUser = "web";
            String dbPassword = "12345678";

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean registerUser(User user) {
        // 在使用 connection 之前确保它不为 null
        if (connection == null) {
            System.err.println("資料庫連接錯誤。");
            return false;
        }

        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // 获取自动生成的键（id）
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // 将生成的 id 设置回 User 对象
                        user.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    @Override
//    public boolean registerUser1(User user) {
//        // TODO Auto-generated method stub
//        return false;
//    }

    // 如果需要，添加 UserDao 接口的其他方法
}