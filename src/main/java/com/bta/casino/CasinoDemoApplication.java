package com.bta.casino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bta.casino.service.SimpleGameService;

@SpringBootApplication
public class CasinoDemoApplication implements CommandLineRunner {

	@Autowired
	private SimpleGameService simpleGame;

	public static void main(String[] args) {
		SpringApplication.run(CasinoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int playCount = 10;
		while (playCount > 0) {
			simpleGame.spin();
			playCount--;
			//each hour
			Thread.sleep(5_000);
		}
	}
}
