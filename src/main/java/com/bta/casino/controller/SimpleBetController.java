package com.bta.casino.controller;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bta.casino.model.SimpleBet;
import com.bta.casino.model.UserAccount;
import com.bta.casino.repository.SimpleBetRepository;
import com.bta.casino.repository.UserAccountRepository;
import com.bta.casino.service.UserBetService;

@Slf4j
@Controller
@RequestMapping("/bet")
public class SimpleBetController {

	@Autowired
	private UserBetService userBetService;

	@Autowired
	private SimpleBetRepository simpleBetRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	//    localhost:9090/bet/new
	@GetMapping("/new")
	public String getNewBetView() {
		return "bet/new";
	}

	@PostMapping("/new")
	public ResponseEntity<SimpleBet> saveBet(
			@ModelAttribute SimpleBet bet) {
		final UserAccount userAccount = userAccountRepository.findByUsername(getCurrentUserUsername());
		userBetService.bet(userAccount, bet.getBetValue(), bet.getBet());
		return new ResponseEntity<>(bet, HttpStatus.OK);
	}

	//     localhost:9090/bet/all
	@GetMapping("/all")
	public ModelAndView getAllBetView() {
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
