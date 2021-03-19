package com.bta.casino.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bta.casino.model.SimpleBet;
import com.bta.casino.model.UserAccount;
import com.bta.casino.repository.UserAccountRepository;
import com.bta.casino.service.UserBetService;

@Slf4j
@Controller
@RequestMapping("/bet")
public class SimpleBetController {

	@Autowired
	private UserBetService userBetService;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@GetMapping
	public String getNewBetView() {
		return "bet/new";
	}

	@PostMapping
	public ResponseEntity<SimpleBet> saveBet(
			@ModelAttribute SimpleBet bet) {
		final UserAccount userAccount = userAccountRepository.findByUsername("oleg.pasichnyk");
		userBetService.bet(userAccount, bet.getBetValue(), bet.getBet());
		return new ResponseEntity<>(bet, HttpStatus.OK);
	}
}
