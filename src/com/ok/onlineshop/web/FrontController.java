package com.ok.onlineshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

	/*
	 * @RequestMapping("/index") public ModelAndView index() { ModelAndView model = new ModelAndView("index.jsp"); //
	 * model.addObject("username", "JohnDoe"); return model; }
	 */

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login");
		System.out.println(model);
		model.addObject("username", "JohnDoe");
		return model;
	}

}
