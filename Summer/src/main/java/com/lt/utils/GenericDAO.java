package com.lt.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO<T, ID extends Serializable>{
	private Class<T> persistentClass;
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.persistentClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T findById(ID id) {
		return (T) entityManager.find(persistentClass, id);
	}
}
