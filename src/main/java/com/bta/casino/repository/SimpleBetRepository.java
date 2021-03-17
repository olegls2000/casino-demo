package com.bta.casino.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bta.casino.model.SimpleBet;

@Repository
public interface SimpleBetRepository
		extends CrudRepository<SimpleBet, Long> {

	//select * from simple_bet where active = true;
	List<SimpleBet> findAllByActiveIsTrue();
}
