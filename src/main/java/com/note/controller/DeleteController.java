package com.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.note.dao.NoteBookDaoImplMySQL;

@Controller
@RequestMapping("/delete")
public class DeleteController {
	
	@Autowired
	NoteBookDaoImplMySQL notebookDaoImplMySQL;
	
	@GetMapping("/{bookId}")
	public String deleteNotebook(@PathVariable("bookId") Integer bookId, Model model) {

		int deleteSuccess = notebookDaoImplMySQL.deleteNoteBook(bookId);

		if (deleteSuccess == 0) {
			model.addAttribute("errorMessage", "記事本刪除失敗");
		}
		
		return "redirect:/note/";
	}
}
