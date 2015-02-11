package com.ok.onlineshop.dao;

import org.hibernate.Session;

import com.ok.onlineshop.util.HibernateUtil;

public abstract class GenericDao<T> {

	/*
	 * Transaction trans = null; try { this.trans = session.beginTransaction(); session.save(user); this.trans.commit(); }
	 * catch (HibernateException e) { if (this.trans != null) { this.trans.rollback(); } this.e.printStackTrace(); }
	 * finally { session.close(); } should I open and close transaction for each
	 */

	public void save(T entity) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void merge(T entity) {
		Session session = HibernateUtil.openSession();
		session.merge(entity);
	}

	public void delete(T entity) {
		Session session = HibernateUtil.openSession();
		session.delete(entity);
	}

}
