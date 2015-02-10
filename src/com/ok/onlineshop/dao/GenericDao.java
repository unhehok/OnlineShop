package com.ok.onlineshop.dao;

import java.io.Serializable;

import org.hibernate.Session;

import com.ok.onlineshop.util.HibernateUtil;

public abstract class GenericDao<T, ID extends Serializable> {

	protected Session openSession() {
		return HibernateUtil.openSession();	// should I be opening new sessions each time or getting current sessions?
	}

	public void save(T entity) {
		Session session = this.openSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void merge(T entity) {
		Session session = this.openSession();
		session.merge(entity);
	}

	public void delete(T entity) {
		Session session = this.openSession();
		session.delete(entity);
	}

}
