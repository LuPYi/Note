package com.note.controller;

import java.util.List;

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
import com.note.dao.NoteBookDaoImplMySQL;

@Controller
@RequestMapping("/update")
public class UpdateController {

    @Autowired
    NoteBookDaoImplMySQL notebookDaoImplMySQL;

    @GetMapping("/update/{bookId}")
    public String showUpdateForm(@PathVariable int bookId, Model model) {
        // 根據bookId查找要修改的記事本
        List<NoteBook> noteBook = notebookDaoImplMySQL.getAllNotesByUserId(bookId);

        if (noteBook == null) {
            model.addAttribute("errorMessage", "查無此記事本");
            return "redirect:/index"; // 或者導向其他頁面
        }

        // 將查找到的記事本傳遞到前端表單
        model.addAttribute("noteBook", noteBook);
        return "update-form"; // 這裡是你的修改表單頁面的名稱
    }

    @PostMapping("/update/{bookId}")
    public String updateNotebook(@PathVariable int bookId,
                                 @RequestParam("newSubject") String newSubject,
                                 @RequestParam("newContext") String newContext,
                                 Model model) {
        // 根據bookId查找要修改的記事本
        List<NoteBook> noteBook = notebookDaoImplMySQL.getAllNotesByUserId(bookId);

        if (noteBook == null) {
            model.addAttribute("errorMessage", "查無此記事本");
            return "redirect:/index"; // 或者導向其他頁面
        }

        UpdateNoteBook updateNoteBook = new UpdateNoteBook();
        // 更新記事本的主題和內容
        updateNoteBook.setNewSubject(newSubject);
        updateNoteBook.setNewContext(newContext);

        // 嘗試更新記事本
        boolean updateSuccess = notebookDaoImplMySQL.updateNoteBook(null);

        if (updateSuccess) {
            model.addAttribute("successMessage", "記事本更新成功");
        } else {
            model.addAttribute("errorMessage", "記事本更新失敗");
        }

        return "redirect:/index"; // 或者導向其他頁面
    }
}

