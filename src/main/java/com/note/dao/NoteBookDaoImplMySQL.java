package com.note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.note.beans.NoteBook;
import com.note.beans.User;

@Repository("notebookDaoImplMySQL")
public class NoteBookDaoImplMySQL implements NoteBookDao{
	@Autowired
	DataSource datasource;

	@Override
	public boolean AddNoteBook(NoteBook notebook) {
		 String query = "insert into user (subject, context) values (?, ?)";
	        try ( Connection connection = datasource.getConnection();
	        	  PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, notebook.getSubject());
	            preparedStatement.setString(2, notebook.getContext());

	            int rowsAffected = preparedStatement.executeUpdate();

	            return rowsAffected > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	}
	
}
