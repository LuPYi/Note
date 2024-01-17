package com.note.beans;

public class UpdateNoteBook {
	
	private String NewSubject;
    
    private String NewContext;
    
    public UpdateNoteBook() {
		
	}
    
    public UpdateNoteBook(String NewSubject, String NewContext) {
		this.NewSubject = NewSubject;
		this.NewContext = NewContext;
	}
	
	public String getNewSubject() {
		return NewSubject;
	}

	public void setNewSubject(String newSubject) {
		NewSubject = newSubject;
	}

	public String getNewContext() {
		return NewContext;
	}

	public void setNewContext(String newContext) {
		NewContext = newContext;
	}



}
