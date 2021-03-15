package com.bta.casino.service;

import com.bta.casino.model.SimpleResult;
import com.bta.casino.model.UserAccount;

public interface UserBetService {
	void bet(UserAccount userAccount, int betValue, SimpleResult betResult);
}
