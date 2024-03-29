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

@Repository("notebookDaoImplMySQL")
public class NoteBookDaoImplMySQL implements NoteBookDao {

	@Autowired
	DataSource datasource;

	@Override
	public boolean addNoteBook(NoteBook notebook) {
		String query = "insert into notebook (user_id,subject, context) values ( ?, ?, ?)";
		try (Connection connection = datasource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, notebook.getUserId());
			preparedStatement.setString(2, notebook.getSubject());
			preparedStatement.setString(3, notebook.getContext());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<NoteBook> getAllNotesByUserId(Integer userId) {
		List<NoteBook> notes = new ArrayList<>();
		String query = "SELECT book_id, user_id, subject, context, create_time, update_time FROM notebook where user_id=?";
		try (Connection connection = datasource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				NoteBook note = new NoteBook();
				note.setBookId(resultSet.getInt("book_id"));
				note.setUserId(resultSet.getInt("user_id"));
				note.setSubject(resultSet.getString("subject"));
				note.setContext(resultSet.getString("context"));
				note.setCreateTime(resultSet.getTimestamp("create_time"));
				note.setUpdateTime(resultSet.getTimestamp("update_time"));
				notes.add(note);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}

	@Override
	public int deleteNoteBook(Integer bookId) {
		String query = "DELETE FROM notebook WHERE book_id = ?";
		try (Connection connection = datasource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			preparedStatement.setInt(1, bookId);
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public boolean updateNoteBook(NoteBook notebook) {
		String query = "UPDATE notebook SET subject = ?, context = ? WHERE book_id = ?";
		try (Connection connection = datasource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, notebook.getSubject());
			preparedStatement.setString(2, notebook.getContext());
			preparedStatement.setInt(3, notebook.getBookId());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public NoteBook getNoteBookByUserIdAndBookId(Integer userId, Integer bookId) {
		String query = "SELECT book_id, user_id, subject, context, create_time, update_time FROM notebook WHERE user_id=? and book_id=?";
		try (Connection connection = datasource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, bookId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				NoteBook note = new NoteBook();
				note.setBookId(rs.getInt("book_id"));
				note.setUserId(rs.getInt("user_id"));
				note.setSubject(rs.getString("subject"));
				note.setContext(rs.getString("context"));
				note.setCreateTime(rs.getTimestamp("create_time"));
				note.setUpdateTime(rs.getTimestamp("update_time"));
				return note;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<NoteBook> getNotesByUserIdAndKeyWord(Integer userId, String keyword) {
		List<NoteBook> notes = new ArrayList<>();
		String query = "SELECT book_id, user_id, subject, context, create_time, update_time FROM note.notebook where user_id=? and (context like ? OR subject like ?)";
		try (Connection connection = datasource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, userId);
		    preparedStatement.setString(2, "%" + keyword + "%");
		    preparedStatement.setString(3, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				NoteBook note = new NoteBook();
				note.setBookId(rs.getInt("book_id"));
				note.setUserId(rs.getInt("user_id"));
				note.setSubject(rs.getString("subject"));
				note.setContext(rs.getString("context"));
				note.setCreateTime(rs.getTimestamp("create_time"));
				note.setUpdateTime(rs.getTimestamp("update_time"));
				notes.add(note);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}

}
