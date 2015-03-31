package hu.bfo.dao;

import hu.bfo.model.BusinessObject;

import java.util.List;

public interface BaseDAO<T extends BusinessObject> {

	void save(T obj);

	BusinessObject getById(Integer id);

	List<T> getAllItem();

	void delete(T obj);
}
