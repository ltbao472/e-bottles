package org.e.bottles.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Transactional
public abstract class GenericDAO<T, ID extends Serializable> {
	private Class<T> persitentClass;
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.persitentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	T getModel(ID id) {
		Session session = sessionFactory.getCurrentSession();
		T model = (T) session.get(this.persitentClass, id);
		return model;
	}
}
