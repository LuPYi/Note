package com.note.beans;

import java.sql.Timestamp;

public class NoteBook {
    private int bookId;
    private int userId;
    private String subject;
    private String context;
    private Timestamp createTime;
    private Timestamp updateTime;

    public NoteBook() {
       
    }

    public NoteBook(String subject, String context) {
		this.subject = subject;
		this.context = context;
	}

	public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
    
    @Override
	public String toString() {
		return "NoteBook [bookId=" + bookId + ", userId=" + userId + ", subject=" + subject + ", context=" + context + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}
}
