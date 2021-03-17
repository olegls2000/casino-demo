package com.bta.casino.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bta.casino.model.UserAccount;
import com.bta.casino.repository.UserAccountRepository;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserAccountController {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@GetMapping("/registration")
	public String getRegistrationView() {
		return "page";
	}

	@PostMapping("/registration")
	public ResponseEntity<UserAccount> registrationUser(
			@ModelAttribute UserAccount userAccount) {
		userAccountRepository.save(userAccount);
		log.info("User created.");

		return new ResponseEntity<>(userAccount, HttpStatus.OK);
	}
}
