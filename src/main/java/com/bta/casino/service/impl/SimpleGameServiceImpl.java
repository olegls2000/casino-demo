package com.bta.casino.service.impl;

import static java.lang.Boolean.FALSE;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bta.casino.model.SimpleGameResult;
import com.bta.casino.model.SimpleResult;
import com.bta.casino.model.UserAccount;
import com.bta.casino.repository.SimpleBetRepository;
import com.bta.casino.repository.SimpleGameResultRepository;
import com.bta.casino.repository.UserAccountRepository;
import com.bta.casino.service.SimpleGameService;

@Slf4j
@Service
public class SimpleGameServiceImpl implements SimpleGameService {

	@Autowired
	private SimpleGameResultRepository simpleGameResultRepository;

	@Autowired
	private SimpleBetRepository simpleBetRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public SimpleGameResult spin() {
		log.info("SimpleGameServiceImpl.spin() ....");
		final SimpleGameResult result = simpleGameResultRepository.save(generateSimpleGameResult());
		log.info("Game result: " + result);


		simpleBetRepository.findAllByActiveIsTrue().stream()
				.peek(sb -> sb.setActive(FALSE))
				.peek(sb -> simpleBetRepository.save(sb))
				.filter(sb -> sb.getBet() == result.getResult())
				.forEach(sb -> {
					final UserAccount userAccount = sb.getUserAccount();
					userAccount.setBalance(userAccount.getBalance() + (2 * sb.getBetValue()));
					userAccountRepository.save(userAccount);
				});
		return result;
	}

	private SimpleGameResult generateSimpleGameResult() {
		final SimpleResult[] values = SimpleResult.values();
		final int randomIndex = getRandom(0, values.length);
		final SimpleResult randomResult = values[randomIndex];

		return SimpleGameResult.builder()
					   .result(randomResult)
					   .dateTime(LocalDateTime.now())
					   .build();
	}

	private int getRandom(int from, int till) {
		return (int) (Math.random() * (till - from)) + from;
	}

}
