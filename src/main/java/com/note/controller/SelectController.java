package com.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.note.beans.NoteBook;
import com.note.dao.NoteBookDao;

@Controller
public class SelectController {

    @Autowired
    private NoteBookDao notebookDao;

    @GetMapping("/query/{userId}")
    public String queryNotes(@PathVariable Integer userId, Model model) {
        List<NoteBook> notes = notebookDao.getNotesByUserId(userId);

        model.addAttribute("notes", notes);

        return "queryResult";
    }
}

