package com.ok.onlineshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FrontController {

	@RequestMapping("/index.jsp")
	public ModelAndView helloworld() {

		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("username", "JohnDoe");
		return model;
	}
}
