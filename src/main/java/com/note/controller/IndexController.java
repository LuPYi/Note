package com.note.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.note.beans.NoteBook;
import com.note.beans.User;
import com.note.dao.NoteBookDao;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	NoteBookDao noteBookDao;
	
	@GetMapping
	public String indexPage(HttpSession session,Model model) {
		
		User user = (User)session.getAttribute("user");
		
		List<NoteBook> noteBooks = noteBookDao.getAllNotesByUserId(user.getId());
		
		model.addAttribute("noteBooks", noteBooks);
		
		return "index";
	}
}
