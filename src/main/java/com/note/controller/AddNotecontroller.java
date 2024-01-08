package com.note.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.note.beans.NoteBook;
import com.note.beans.User;
import com.note.dao.NoteBookDaoImplMySQL;
import com.note.dao.UserDaoImplMySQL;

@Controller
@RequestMapping("/addNote")
public class AddNotecontroller{
	
	@Autowired
	NoteBookDaoImplMySQL notebookDaoImplMySQL;
	
	@GetMapping
	public String addnotebook() {
		return "NewNote";
	}
	
	@PostMapping
	public String addNote(@RequestParam("subject") String subject, 
						   @RequestParam("context") String context,
			               Model model) {
		
		System.out.println("subject:" + subject);
		System.out.println("context:" + context);
		
		if (subject==null) {
			model.addAttribute("errorMessage", "請輸入subject");
			return "NewNote";
		}
		return "NewNote";
  
}
}
