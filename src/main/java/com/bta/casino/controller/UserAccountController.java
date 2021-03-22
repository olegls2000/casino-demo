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

import com.bta.casino.model.UserAccount;
import com.bta.casino.service.UserAccountService;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserAccountController {

	@Autowired
	private UserAccountService userAccountService;

	@GetMapping("/registration")
	public String getRegistrationView() {
		return "user/registration";
	}

	@PostMapping("/registration")
	public ResponseEntity<UserAccount> registrationUser(
			@ModelAttribute UserAccount userAccount) {
		UserAccount createdUserAccount = userAccountService.registration(userAccount);
		return new ResponseEntity<>(createdUserAccount, HttpStatus.OK);
	}
}
