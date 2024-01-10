package com.note.beans;

public class DeleteNoteBook {

	private int id;
	private String subject;
	private String context;

	public DeleteNoteBook() {

	}

	public DeleteNoteBook(int id, String subject, String context) {
		this.id = id;
		this.subject = subject;
		this.context = context;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
