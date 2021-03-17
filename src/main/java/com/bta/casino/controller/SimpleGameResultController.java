package com.bta.casino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bta.casino.model.SimpleBet;
import com.bta.casino.model.SimpleGameResult;
import com.bta.casino.repository.SimpleBetRepository;
import com.bta.casino.repository.SimpleGameResultRepository;

@RestController
public class SimpleGameResultController {

	@Autowired
	private SimpleGameResultRepository simpleGameResultRepository;
	//http://localhost:9000/bets
	//@RequestMapping(value = "/bets", method = RequestMethod.GET)

	@GetMapping("/simple-game/results")
	public Iterable<SimpleGameResult> getAllResults() {
		return simpleGameResultRepository.findAll();
	}
}
