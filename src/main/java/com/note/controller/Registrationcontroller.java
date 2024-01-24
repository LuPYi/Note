package com.note.controller;

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

@Controller
@RequestMapping("/register")
public class Registrationcontroller {

	@Autowired
	UserDaoImplMySQL userDaoImplMySQL;

	@GetMapping
	public String registerPage() {
		return "Register";
	}

	@PostMapping
	public String register(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("confirm_password") String confirmPassword,
			Model model) {

		// 簡單的密碼驗證
		if (!password.equals(confirmPassword)) {
			model.addAttribute("errorMessage", "密碼不匹配");
			return "Register";
		}


		// 檢查帳號是否已註冊
		User user = userDaoImplMySQL.findUserByName(name);
		if(user!=null) {
			model.addAttribute("errorMessage", "此帳號已註冊");
			return "Register";
		}
		
		// 密碼加密
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		// 註冊
		User newUser = new User(name, email, hashedPassword);
		if (userDaoImplMySQL.registerUser(newUser)) {
			return "login";
		}

		// 註冊失敗
		model.addAttribute("errorMessage", "註冊失敗");
		return "Register";
	}
}
