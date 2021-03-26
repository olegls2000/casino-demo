package com.bta.casino.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.bta.casino.service.SimpleGameService;

@Controller
public class SimpleGameController {

	@Autowired
	private SimpleGameService simpleGameService;

	@GetMapping("/spin")
	public ModelAndView triggerSimpleGame(){
		simpleGameService.spin();

		final Map<String, Object> model = new HashMap<>();
		model.put("bets", simpleBetRepository.findAllByUserAccountUsername(getCurrentUserUsername()));

		return new ModelAndView("bet/all", model);
	}
}
