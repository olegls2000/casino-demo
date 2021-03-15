package com.bta.casino.service.impl;

import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bta.casino.model.SimpleGameResult;
import com.bta.casino.model.SimpleResult;
import com.bta.casino.repository.SimpleGameResultRepository;
import com.bta.casino.service.SimpleGameService;

@Slf4j
@Service
public class SimpleGameServiceImpl implements SimpleGameService {

	@Autowired
	private SimpleGameResultRepository repository;

	@Override
	public SimpleGameResult spin() {
		log.info("SimpleGameServiceImpl.spin() ....");
		final SimpleResult[] values = SimpleResult.values();
		final int randomIndex = getRandom(0, values.length);
		final SimpleResult randomResult = values[randomIndex];

		final SimpleGameResult result = SimpleGameResult.builder()
												.result(randomResult)
												.dateTime(LocalDateTime.now())
												.build();
		repository.save(result);



		// Results Match .....

		return result;
	}

	private int getRandom(int from, int till) {
		return (int) (Math.random() * (till - from)) + from;
	}

}
