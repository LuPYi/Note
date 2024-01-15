package com.note.dao;

import java.util.List;

import com.note.beans.NoteBook;

public interface NoteBookDao {
	
	boolean addNoteBook(NoteBook notebook);
	
	List<NoteBook> getAllNotesByUserId(Integer userId);
	
	int deleteNoteBook(Integer bookId);

	boolean updateNoteBook(NoteBook notebook);
}
