package com.note.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.note.beans.AddNoteBook;
import com.note.beans.NoteBook;
import com.note.beans.User;
import com.note.dao.NoteBookDaoImplMySQL;

@Controller
@RequestMapping("/addNote")
public class AddNotecontroller{
	
	@Autowired
	NoteBookDaoImplMySQL notebookDaoImplMySQL;
	
	@GetMapping
	public String addnotebook() {
		return "NewNote";
	}
	
	@PostMapping(produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String addNote(@RequestBody AddNoteBook addNoteBook,HttpSession session) {
		// 從 Session 拿 User，再從 User 拿 user id
		User user = (User)session.getAttribute("user");
		
		System.out.println("user_id:"+ user.getId());
		System.out.println("subject:" + addNoteBook.getSubject());
		System.out.println("context:" + addNoteBook.getContext());

		if (addNoteBook.getSubject() ==null) {
			return new Gson().toJson("請輸入subject");
		}
		
		NoteBook noteBook = new NoteBook();
		noteBook.setUserId(user.getId());
		noteBook.setSubject(addNoteBook.getSubject());
		noteBook.setContext(addNoteBook.getContext());

		notebookDaoImplMySQL.addNoteBook(noteBook);
		
		return new Gson().toJson("success中文");
  
	}
}
