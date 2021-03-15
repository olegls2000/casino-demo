package com.bta.casino.service.impl;

import static java.lang.Boolean.TRUE;

import javax.transaction.Transactional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bta.casino.model.SimpleBet;
import com.bta.casino.model.SimpleResult;
import com.bta.casino.model.UserAccount;
import com.bta.casino.repository.SimpleBetRepository;
import com.bta.casino.repository.UserAccountRepository;
import com.bta.casino.service.UserBetService;

@Slf4j
@Service
public class UserBetServiceImpl implements UserBetService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private SimpleBetRepository simpleBetRepository;

	@Transactional
	@Override
	public void bet(UserAccount userAccount, int betValue, SimpleResult betResult) {
		log.info("UserBetServiceImpl.bet(" + userAccount +
						 ", " + betValue + ", " + betResult + ")...");

		final long userId = userAccount.getId();
		final UserAccount userAccountFromDB = userAccountRepository.findById(userId)
									  .orElseThrow(() -> new RuntimeException("User with id = "
									  + userId + "doesn't exist!"));
		userBalanceCheck(userAccountFromDB, betValue);
		final SimpleBet bet = SimpleBet.builder()
									  .bet(betResult)
									  .betValue(betValue)
									  .active(TRUE)
									  .userAccount(userAccountFromDB)
									  .build();
		simpleBetRepository.save(bet);
		userAccountFromDB.setBalance(userAccountFromDB.getBalance() - betValue);
		userAccountRepository.save(userAccountFromDB);
	}

	private void userBalanceCheck(UserAccount userAccount, int betValue) {
		int remain = userAccount.getBalance() - betValue;
		if (remain < 0) {
			throw new RuntimeException("User doesn't have enough money to make a bet!");
		}
	}

}
