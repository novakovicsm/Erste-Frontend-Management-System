package hu.bfo.dao;

import hu.bfo.model.Account;
import hu.bfo.model.AccountType;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultAccountDAO extends DefaultBaseDAO<Account> implements
		AccountDAO {

	public DefaultAccountDAO() {
		super(Account.class);
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAccountByAccountType(AccountType type) {
		Criteria criteria = getSession().createCriteria(Account.class);
		criteria.add(Restrictions.eq("accountType", type));
		return criteria.list();
	}
}
