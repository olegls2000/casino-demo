package com.bta.casino.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bta.casino.repository.SimpleBetRepository;
import com.bta.casino.service.SimpleGameService;

@Controller
public class SimpleGameController {

	@Autowired
	private SimpleGameService simpleGameService;

	@Autowired
	private SimpleBetRepository simpleBetRepository;

	@GetMapping("/spin")
	public ModelAndView triggerSimpleGame() {
		simpleGameService.spin();

		final Map<String, Object> model = new HashMap<>();
		model.put("bets", simpleBetRepository.findAllByUserAccountUsername(getCurrentUserUsername()));

		return new ModelAndView("bet/all", model);
	}

	private String getCurrentUserUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			UserDetails userDetails = (UserDetails) principal;
			return userDetails.getUsername();
		}
		throw new RuntimeException("Issue with Spring Security Configuration. Principal has wrong type!!!");
	}
}
