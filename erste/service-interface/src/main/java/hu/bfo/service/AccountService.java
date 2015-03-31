package hu.bfo.service;

import hu.bfo.model.Account;
import hu.bfo.model.AccountType;

import java.util.List;

public interface AccountService {

	double increaseBalance(double newAmount);
	
	void createAccount(Account acc);
	
	List<Account> getCreditAccounts(AccountType type);
}
