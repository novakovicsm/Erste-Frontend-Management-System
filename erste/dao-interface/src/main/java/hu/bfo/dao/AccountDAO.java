package hu.bfo.dao;

import hu.bfo.model.Account;
import hu.bfo.model.AccountType;

import java.util.List;

public interface AccountDAO extends BaseDAO<Account> {

	List<Account> getAccountByAccountType(AccountType type);
}
