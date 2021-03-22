package com.bta.casino.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bta.casino.model.Role;
import com.bta.casino.model.UserAccount;
import com.bta.casino.repository.RoleRepository;
import com.bta.casino.repository.UserAccountRepository;
import com.bta.casino.service.UserAccountService;

@Slf4j
@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserAccount registration(UserAccount userAccount) {
		checkUniqueByUsername(userAccount.getUsername());
		checkUniqueByEmail(userAccount);
		checkUniqueByTaxNumber(userAccount);

		encodePassword(userAccount);
		final UserAccount result = userAccountRepository.save(userAccount);

		Role userRole = getRole("ROLE_USER");
		userRole.getUserAccounts().add(result);
		roleRepository.save(userRole);

		log.info("User Account created: " + result);

		return result;
	}

	private void encodePassword(UserAccount userAccount) {
		userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
	}

	private Role getRole(String role) {
		Role userRole = roleRepository.findByRole(role);
		if (userRole == null) {
			userRole = roleRepository.save(Role.builder().role(role).build());
		}
		return userRole;
	}

	private void checkUniqueByUsername(String username) {
		final UserAccount fromDB = userAccountRepository.findByUsername(username);
		if (fromDB != null) {
			log.warn("User Account with username: " + username + " already exists");
			throw new RuntimeException("User Account with such Username already exists");
		}
	}

	private void checkUniqueByEmail(UserAccount userAccount) {
		final UserAccount fromDB = userAccountRepository.findByEmail(userAccount.getEmail());
		if (fromDB != null) {
			throw new RuntimeException("User Account with such email already exists");
		}
	}

	private void checkUniqueByTaxNumber(UserAccount userAccount) {
		final UserAccount fromDB = userAccountRepository.findByTaxNumber(userAccount.getTaxNumber());
		if (fromDB != null) {
			throw new RuntimeException("User Account with such Tax Number already exists");
		}
	}
}
