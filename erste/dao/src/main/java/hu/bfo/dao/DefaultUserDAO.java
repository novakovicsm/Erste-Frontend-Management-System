package hu.bfo.dao;

import hu.bfo.model.User;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultUserDAO extends DefaultBaseDAO<User> implements UserDAO {

	public DefaultUserDAO() {
		super(User.class);
	}

	@SuppressWarnings("unchecked")
	public List<User> getActiveUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("active", true));
		return criteria.list();
	}

}
