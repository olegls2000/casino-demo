package com.bta.casino.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@GetMapping("/")
	public String getIndexView() {
		return "index";
	}

	@GetMapping("/index.html")
	public String getIndexHtmlView() {
		return "index";
	}
}
