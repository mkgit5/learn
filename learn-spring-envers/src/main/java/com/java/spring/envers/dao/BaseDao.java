package com.java.spring.envers.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<E extends Serializable> {

	@PersistenceContext
	protected EntityManager entityManager;

	@Autowired
	protected DataSource datasource;

	private Class<E> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
			this.entityClass = (Class<E>) genericSuperClass.getActualTypeArguments()[0];
		}
	}

	public Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}

	public <K> E findById(K id) {
		return this.entityManager.find(entityClass, id);
	}

	public E insert(E entity) {
		this.entityManager.persist(entity);
		this.entityManager.flush();
		return entity;
	}

	public E update(E entity) {
		this.entityManager.clear();
		this.entityManager.merge(entity);
		this.entityManager.flush();
		return entity;
	}

	public void delete(E entity) {
		this.entityManager.remove(entity);
		this.entityManager.flush();
	}

	public <K> void deleteById(K id) {
		E entity = this.findById(id);
		this.delete(entity);
	}

	public Query createNamedQuery(String sql) {
		return this.entityManager.createNamedQuery(sql);
	}

}
