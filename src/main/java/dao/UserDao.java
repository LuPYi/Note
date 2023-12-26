package dao;

import beans.User;

public interface UserDao {
    boolean registerUser(User user);
}