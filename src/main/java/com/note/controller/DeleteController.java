package com.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.note.dao.NoteBookDaoImplMySQL;

@Controller
@RequestMapping("/delete")
public class DeleteController {
	@Autowired
	NoteBookDaoImplMySQL notebookDaoImplMySQL;
	
	@GetMapping
	public String deleteNoteBook() {
		return "index";
	}

	@PostMapping
	public String deleteNotebook(@PathVariable int bookId, Model model) {
		// 嘗試刪除記事本
		int deleteSuccess = notebookDaoImplMySQL.deleteNoteBook(bookId);

		if (deleteSuccess == 0) {
			model.addAttribute("successMessage", "記事本刪除成功");
		} else {
			model.addAttribute("errorMessage", "記事本刪除失敗");
		}

		return "redirect:/index"; // 重定向到首頁或其他頁面
	}
}
