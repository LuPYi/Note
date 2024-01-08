package com.note.dao;

import java.util.List;

import com.note.beans.NoteBook;
import com.note.beans.User;

public interface NoteBookDao {
	boolean AddNoteBook(NoteBook notebook);
	
	//List<NoteBook> getAllNotes();
}
