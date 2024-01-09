package com.note.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		 String query = "insert into notebook (subject, context) values (?, ?)";
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



//	 @Override
//	    public List<NoteBook> getAllNotes() {
//	        List<NoteBook> notes = new ArrayList<>();
//	        String query = "SELECT * FROM notebook";
//	        try (Connection connection = datasource.getConnection();
//	             PreparedStatement preparedStatement = connection.prepareStatement(query);
//	             ResultSet resultSet = preparedStatement.executeQuery()) {
//
//	            while (resultSet.next()) {
//	            	NoteBook note = new NoteBook();
//	                note.setBookId(resultSet.getInt("book_id"));
//	                note.setUserId(resultSet.getInt("user_id"));
//	                note.setSubject(resultSet.getString("subject"));
//	                note.setContext(resultSet.getString("context"));
//	                note.setCreateTime(resultSet.getTimestamp("create_time"));
//	                note.setUpdateTime(resultSet.getTimestamp("update_time"));
//
//	                notes.add(note);
//	            }
//
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//
//	        return notes;
//	    }
	
}
