package com.rolando.persistence;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings({ "unchecked" })
public abstract class EntityRepository<T extends Serializable> {

	private Class<?> genericClass;

	@Autowired
	private SessionFactory sessionFactory;

	public EntityRepository(Class<?> genericClass) {
		this.genericClass = genericClass;
	}

	public Long save(T entity) {
		Session session = sessionFactory.getCurrentSession();
		Long id = (Long) session.save(entity);
		return id;
	}

	public void update(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public T get(Long id) {
		T entity = (T) sessionFactory.getCurrentSession().get(genericClass, id);
		return entity;
	}

	public Collection<T> list() {
		return sessionFactory.getCurrentSession().createQuery("from " + genericClass.getCanonicalName()).list();
	}

	public void merge(T entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

}
