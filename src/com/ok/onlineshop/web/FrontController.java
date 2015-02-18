package com.ok.onlineshop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) {
		String message = "Hello Spring MVC World!";
		ModelAndView model = new ModelAndView("login", "message", message);
		// model.addObject("username", "JohnDoe");
		return model;
	}

}
