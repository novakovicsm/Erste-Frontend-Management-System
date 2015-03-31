package hu.bfo.service;

import hu.bfo.dao.AccountDAO;
import hu.bfo.model.Account;
import hu.bfo.model.AccountType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultAccountService implements AccountService {

	@Autowired
	AccountDAO dao;

	public double increaseBalance(double newAmount) {
		return newAmount;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false, timeout = 3000, rollbackFor = Exception.class)
	public void createAccount(Account acc) {
		dao.save(acc);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = false, timeout = 3000, rollbackFor = Exception.class)
	public List<Account> getCreditAccounts(AccountType type) {
		return dao.getAccountByAccountType(type);
	}

}
