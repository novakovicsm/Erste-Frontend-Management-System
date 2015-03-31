package hu.bfo.dao;

import hu.bfo.model.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User> {

	List<User> getActiveUsers();
}
