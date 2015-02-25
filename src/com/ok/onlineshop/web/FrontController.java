package com.ok.onlineshop.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ok.onlineshop.manager.UserManager;
import com.ok.onlineshop.model.User;

@Controller
public class FrontController {

	// @RequestMapping("/index")
	// public ModelAndView index(HttpServletRequest request,
	// HttpServletResponse response) {
	// // HttpSession session = request.getSession(false);
	// // if (session == null) {
	// // session = request.getSession();
	// // return new ModelAndView("index");
	// // }
	// // else {
	// // User user = (User) session.getAttribute("user");
	// // ModelAndView model = new ModelAndView("index");
	// // model.addObject("message", "Welcome " + user.getUsername() + "!");
	// // return model;
	// // }
	// return new ModelAndView("index");
	// }

	// @RequestMapping("/login.do")
	// public ModelAndView login(HttpServletRequest request,
	// HttpServletResponse response) {
	// request
	// String message = "Hello Spring MVC World!";
	// ModelAndView model = new ModelAndView("login", "message", message);
	// // model.addObject("username", "JohnDoe");
	// return model;
	// }

	@RequestMapping("/newuser")
	public ModelAndView newUser(HttpServletRequest request) {
		String newEmail = request.getParameter("newEmail");
		String newUsername = request.getParameter("newUsername");
		String newPassword = request.getParameter("newPassword");
		System.out.println("processing new user");
		UserManager um = new UserManager();
		User newUser = um.newUser(newUsername, newPassword, newEmail);
		if (newUser == null) {
			String errorMsg = um.invalidUsername(newUsername);
			if (errorMsg == null) {
				errorMsg = um.invalidEmail(newEmail);
			}
			return new ModelAndView("error_newuser", "errorMsg", errorMsg);
		}
		ModelAndView model = new ModelAndView("home");
		model.addObject("user", newUser);
		return model;
	}

	// @RequestMapping("/home")
	// public ModelAndView home(HttpServletRequest request,
	// HttpServletResponse response) {
	//
	// }
}
