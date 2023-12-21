package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import User.User;

public class UserDaoImplMySQL implements UserDao {
    
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private Connection connection;

    public UserDaoImplMySQL() {
        // 在構造函數中初始化數據庫連接
        try {
            // 用你的 MySQL 數據庫凭据替换这些详细信息
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
        // 在使用 connection 之前確保它不為 null
        if (connection == null) {
            System.err.println("連接為空。請檢查數據庫連接。");
            return false;
        }

        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // 獲取自動生成的鍵（id）
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        // 將生成的 id 設置回 User 對象
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

	@Override
	public boolean registerUser1(User user) {
		// TODO Auto-generated method stub
		return false;
	}

    // 如果需要，添加 UserDao 接口的其他方法
}

