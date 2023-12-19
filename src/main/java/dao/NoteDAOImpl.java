package dao;

import java.util.ArrayList;
import java.util.List;

public class NoteDAOImpl implements NoteDAO {

    private List<String> notes = new ArrayList<>();

    @Override
    public List<String> getAllNotes() {
        return notes;
    }

    @Override
    public String getNoteById(int id) {
        if (id >= 0 && id < notes.size()) {
            return notes.get(id);
        }
        return null;
    }

    @Override
    public void addNote(String note) {
        notes.add(note);
    }

    @Override
    public void updateNoteById(int id, String updatedNote) {
        if (id >= 0 && id < notes.size()) {
            notes.set(id, updatedNote);
        }
    }

    @Override
    public void deleteNoteById(int id) {
        if (id >= 0 && id < notes.size()) {
            notes.remove(id);
        }
    }
}

