package com.ok.onlineshop.dao;

import org.hibernate.Session;

import com.ok.onlineshop.util.HibernateUtil;

public abstract class GenericDao {

	/*
	 * Transaction trans = null; try { this.trans = session.beginTransaction(); session.save(user); this.trans.commit(); }
	 * catch (HibernateException e) { if (this.trans != null) { this.trans.rollback(); } this.e.printStackTrace(); }
	 * finally { session.close(); } should I open and close transaction for each
	 */

	public static void save(Object entity) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void merge(Object entity) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.merge(entity);
		session.getTransaction().commit();
		session.close();
	}

	public void delete(Object entity) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

}
