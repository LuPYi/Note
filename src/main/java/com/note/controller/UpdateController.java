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

import com.note.beans.NoteBook;
import com.note.beans.UpdateNoteBook;
import com.note.beans.User;
import com.note.dao.NoteBookDaoImplMySQL;

@Controller
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    NoteBookDaoImplMySQL notebookDaoImplMySQL;

    @GetMapping("/{bookId}")
    public String showUpdateForm(HttpSession session,@PathVariable int bookId, Model model) {
        
    	// 從 session 去拿 登入者資訊
    	User user = (User)session.getAttribute("user");
    	
    	// 根據bookId查找要修改的記事本
    	NoteBook noteBook = notebookDaoImplMySQL.getNoteBookByUserIdAndBookId(user.getId(),bookId);

        if (noteBook == null) {
            model.addAttribute("errorMessage", "查無此記事本");
            return "redirect:/index"; // 或者導向其他頁面
        }

        // 將查找到的記事本傳遞到前端表單
        model.addAttribute("noteBook", noteBook);
        return "update_note"; // 這裡是你的修改表單頁面的名稱
    }

    @PostMapping("/{bookId}")
    public String updateNotebook(HttpSession session,
    		                     @PathVariable("bookId") Integer bookId,
                                 @RequestParam("subject") String newSubject,
                                 @RequestParam("context") String newContext,
                                 Model model) {
        // 根據bookId查找要修改的記事本
    	User user = (User)session.getAttribute("user");
    	
    	// 根據bookId查找要修改的記事本
    	NoteBook noteBook = notebookDaoImplMySQL.getNoteBookByUserIdAndBookId(user.getId(),bookId);

        if (noteBook == null) {
            model.addAttribute("errorMessage", "查無此記事本");
            return "update_note"; // 或者導向其他頁面
        }

        noteBook.setSubject(newSubject);
        noteBook.setContext(newContext);

        // 嘗試更新記事本
        boolean updateSuccess = notebookDaoImplMySQL.updateNoteBook(noteBook);

        if (updateSuccess) {
            model.addAttribute("successMessage", "記事本更新成功");
        } else {
            model.addAttribute("errorMessage", "記事本更新失敗");
        }

        return "redirect:/note/"; // 或者導向其他頁面
    }
}

