package com.note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.note.beans.User;

@Repository("userDaoImplMySQL")
public class UserDaoImplMySQL implements UserDao {
    
	@Autowired
	DataSource datasource;
	
    @Override
    public boolean registerUser(User user) {
        String query = "insert into user (name, email, password) values (?, ?, ?)";
        try ( Connection connection = datasource.getConnection();
        	  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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

	@Override
	public User findUserByName(String username) {
		String query = "select id, name, email, password from user where name = ?";
        try ( Connection connection = datasource.getConnection();
        	  PreparedStatement ps = connection.prepareStatement(query)) {
        	ps.setString(1, username);
        	ResultSet rs = ps.executeQuery();
        	if(rs.next()) {
        		User user = new User();
        		user.setId(rs.getInt("id"));
        		user.setName(rs.getString("name"));
        		user.setEmail(rs.getString("email"));
        		user.setPassword(rs.getString("password"));
        		return user;
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
	}
     
}
