package com.note.dao;

import com.note.beans.User;

public interface UserDao {
    
	boolean registerUser(User user);
	
	User findUserByNameAndEmail(String username, String email);

}