package com.note.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.note.beans.NoteBook;
import com.note.beans.User;
import com.note.dao.NoteBookDao;

@Controller
public class SelectController {

    @Autowired
    private NoteBookDao notebookDao;

    @GetMapping("/query")
    public String queryNotes(HttpSession session,@RequestParam("keyword") String keyword, Model model) {
        
    	User user = (User)session.getAttribute("user");
    	
    	List<NoteBook> notes;
    	
    	if("".equals(keyword)) {
    		notes = notebookDao.getAllNotesByUserId(user.getId());
    	} else {
    		notes = notebookDao.getNotesByUserIdAndKeyWord(user.getId(),keyword);
    	}
    	
        model.addAttribute("notes", notes);
        
        if (notes.isEmpty()) {
            model.addAttribute("message", "查無記事本");
        } else {
            model.addAttribute("notes", notes);
        }
        model.addAttribute("isEmpty", notes.isEmpty());
        return "search_list";
    }
}

