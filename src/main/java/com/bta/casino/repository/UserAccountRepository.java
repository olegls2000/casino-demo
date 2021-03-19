package com.bta.casino.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bta.casino.model.UserAccount;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
	//select * from User_Account where username = ?
	UserAccount findByUsername(String username);
}
