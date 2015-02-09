package com.ok.onlineshop.dao;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.Session;

import com.ok.onlineshop.util.HibernateUtil;

public abstract class GeneralDao<T, ID extends Serializable> {

	protected Session openSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

	protected Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public void save(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.saveOrUpdate(entity);
	}

	public void merge(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.merge(entity);
	}

	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.delete(entity);
	}

	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	public T findByID(Class clazz, BigDecimal id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(clazz, id);
		return t;
	}

	@Override
	public List findAll(Class clazz) {
		Session hibernateSession = this.getSession();
		List T = null;
		Query query = hibernateSession.createQuery("from " + clazz.getName());
		T = query.list();
		return T;
	}

}
