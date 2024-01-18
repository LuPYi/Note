package com.note.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.note.beans.NoteBook;
import com.note.beans.User;
import com.note.dao.NoteBookDaoImplMySQL;

@Controller
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    NoteBookDaoImplMySQL notebookDaoImplMySQL;

    @GetMapping("/{bookId}")
    public String showUpdateForm(HttpSession session,@PathVariable int bookId, Model model) {

    	User user = (User)session.getAttribute("user");

    	NoteBook noteBook = notebookDaoImplMySQL.getNoteBookByUserIdAndBookId(user.getId(),bookId);

        if (noteBook == null) {
            model.addAttribute("errorMessage", "查無此記事本");
            return "redirect:/index";
        }

        model.addAttribute("noteBook", noteBook);
        return "update_note";
    }

    @PostMapping("/{bookId}")
    public String updateNotebook(HttpSession session,
    		                     @PathVariable("bookId") Integer bookId,
                                 @RequestParam("subject") String newSubject,
                                 @RequestParam("context") String newContext,
                                 Model model) {

    	User user = (User)session.getAttribute("user");

    	NoteBook noteBook = notebookDaoImplMySQL.getNoteBookByUserIdAndBookId(user.getId(),bookId);

        if (noteBook == null) {
            model.addAttribute("errorMessage", "查無此記事本");
            return "update_note";
        }

        noteBook.setSubject(newSubject);
        noteBook.setContext(newContext);

        boolean updateSuccess = notebookDaoImplMySQL.updateNoteBook(noteBook);

        if (updateSuccess) {
            model.addAttribute("successMessage", "記事本更新成功");
            //return new Gson().toJson("記事本更新成功" 
            //        + "\nsubject: " + noteBook.getSubject() 
            //        + "\ncontext: " + noteBook.getContext());
        } else {
            model.addAttribute("errorMessage", "記事本更新失敗");
        }

        return "redirect:/note/";

    }
}

