package com.bta.casino.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bta.casino.model.SimpleGameResult;

@Repository
public interface SimpleGameResultRepository
		extends CrudRepository<SimpleGameResult, Long> {
}
