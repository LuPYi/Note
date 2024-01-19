package com.note.controller;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Email;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.note.beans.User;
import com.note.dao.UserDaoImplMySQL;

@Controller()
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UserDaoImplMySQL userDaoImplMySQL;

	@GetMapping()
	public String loginPage() {
		return "login";
	}
	
	@PostMapping()
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,Model model, HttpSession session) {
		
		boolean isAuthenticated = authenticateUser(username, password, session);
		
		if (isAuthenticated) {
			return "redirect:/note/";
		}
		
		model.addAttribute("errorMessage", "帳號或密碼輸入錯誤");
		return "login";
	}

	private boolean authenticateUser(String username, String password,HttpSession session) {
		
		User user = userDaoImplMySQL.findUserByNameAndEmail(username, password);

		if(user == null)
			return false;
		
		if(!user.getName().equals(username) || !BCrypt.checkpw(password, user.getPassword())) {
			return false;
		}

		session.setAttribute("user", user);
		return true;
	}
}
