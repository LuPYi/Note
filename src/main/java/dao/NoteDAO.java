package dao;

import java.util.List;

public interface NoteDAO  {
    List<String> getAllNotes();
    String getNoteById(int id);
    void addNote(String note);
    void updateNoteById(int id, String updatedNote);
    void deleteNoteById(int id);
}

