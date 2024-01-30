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
public class AllNoteBookController {
	@Autowired
    private NoteBookDao notebookDao;

    @GetMapping("/all")
    public String queryNotes(HttpSession session, Model model) {
        
        User user = (User)session.getAttribute("user");
        
        List<NoteBook> notes = notebookDao.getAllNotesByUserId(user.getId());

        if (notes.isEmpty()) {
            model.addAttribute("message", "查無記事本");
        } else {
            model.addAttribute("notes", notes);
        }

        model.addAttribute("isEmpty", notes.isEmpty());
        
		return "Note_list";
	}

}
