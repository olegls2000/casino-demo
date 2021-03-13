package com.bta.casino;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bta.casino.model.UserAccount;
import com.bta.casino.repository.UserAccountRepository;

@SpringBootApplication
public class CasinoDemoApplication implements CommandLineRunner {

	@Autowired
	private UserAccountRepository userAccountRepository;

	public static void main(String[] args) {
		SpringApplication.run(CasinoDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final UserAccount userAccount = UserAccount.builder()
										  .firstName("Ivan")
										  .lastName("Ivanov")
										  .taxNumber(395L)
										  .birthday(LocalDate.of(1995, Month.OCTOBER, 15))
										  .username("ivaniv")
										  .password("secret")
										  .email("ivan.i@mail.com")
										  .build();

		userAccountRepository.save(userAccount);

		long usersCount = userAccountRepository.count();
		System.out.println("usersCount: " + usersCount);
	}
}
