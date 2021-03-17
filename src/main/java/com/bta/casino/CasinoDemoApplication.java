package com.bta.casino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bta.casino.service.GameTrigger;

@SpringBootApplication
public class CasinoDemoApplication implements CommandLineRunner {

	@Autowired
	private GameTrigger gameTrigger;

	public static void main(String[] args) {
		SpringApplication.run(CasinoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//gameTrigger.startGames(10_000l, 3);
	}
}
