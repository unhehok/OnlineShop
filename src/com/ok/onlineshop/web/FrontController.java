package com.ok.onlineshop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ok.onlineshop.manager.UserManager;

@Controller
public class FrontController {

	// @RequestMapping("/index")
	// public ModelAndView index(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView model = new ModelAndView("index");
	// HttpSession session = request.getSession(false);
	// if (session == null) {
	// session = request.getSession();
	// }
	// else {
	// User user = (User) session.getAttribute("user");
	// model.addObject("username", user.getUsername());
	// }
	// return model;
	// }

	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		request
		String message = "Hello Spring MVC World!";
		ModelAndView model = new ModelAndView("login", "message", message);
		// model.addObject("username", "JohnDoe");
		return model;
	}

	@RequestMapping("/newuser.do")
	public ModelAndView newUser(HttpServletRequest request,
			HttpServletResponse response) {
		String newEmail = request.getParameter("newEmail");
		String newUsername = request.getParameter("newUsername");
		String newPassword = request.getParameter("newPassword");
		UserManager um = new UserManager();
		if (!um.isUsernameUnique(newUsername)) {
			String errorMsg = newUsername + " already exists.";
			return new ModelandView("index", "errorMsg", errorMsg);
		}
		if (!um.isEmailUnique(newEmail)) {
			String errorMsg = newEmail + " already exists.";
			return new ModelandView("index", "errorMsg", errorMsg);
		}
		// else create new user, log in, and direct to account.jsp
		return new ModelAndView("index");
	}
}
