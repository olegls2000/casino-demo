package com.bta.casino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bta.casino.model.SimpleBet;
import com.bta.casino.repository.SimpleBetRepository;

@RestController
public class SimpleBetController {

	@Autowired
	private SimpleBetRepository simpleBetRepository;
	//http://localhost:9000/bets
	//@RequestMapping(value = "/bets", method = RequestMethod.GET)

	@GetMapping("/bets")
	public Iterable<SimpleBet> getAllBets() {
		return simpleBetRepository.findAll();
	}
}
