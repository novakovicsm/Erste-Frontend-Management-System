package hu.bfo.dao;

import hu.bfo.model.BusinessObject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultBaseDAO<T extends BusinessObject> implements BaseDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	private Class<?> clazz;

	public DefaultBaseDAO() {
	}

	public DefaultBaseDAO(Class<T> clazz) {
		this.clazz = clazz;
	}

	public void save(T obj) {
		getSession().saveOrUpdate(obj);
	}

	@SuppressWarnings("unchecked")
	public T getById(Integer id) {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllItem() {
		return getSession().createCriteria(clazz).list();
	}

	public void delete(T obj) {

		BusinessObject o = (BusinessObject) obj;
		o.setActive(Boolean.FALSE);
		getSession().update(o);

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
