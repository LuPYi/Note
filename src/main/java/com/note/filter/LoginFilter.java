package com.note.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.note.beans.User;

@WebFilter(value = { "/*" })
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String urlString = request.getRequestURL().toString();

		if (urlString.endsWith("login.jsp") 
				|| urlString.endsWith("/login")
				|| urlString.indexOf("/images") >= 0
				|| urlString.endsWith(".css") 
				|| urlString.endsWith(".js")) {
			chain.doFilter(request, response); // 放行
			return;
		}

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/note/login"); // 導回登入頁
			return;
		}

		chain.doFilter(request, response); // 放行

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
