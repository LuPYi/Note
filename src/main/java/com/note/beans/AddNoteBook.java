package com.note.beans;

public class AddNoteBook {

    private String subject;
    
    private String context;

    public AddNoteBook() {
    	
    }
    
	public AddNoteBook(String subject, String context) {
		this.subject = subject;
		this.context = context;
	}
    
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
