package com.ok.onlineshop.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ok.onlineshop.util.HibernateUtil;

public abstract class GenericDao {

	protected static void save(Object entity) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.saveOrUpdate(entity);
		session.getTransaction().commit();
		session.close();
	}

	protected static void merge(Object entity) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.merge(entity);
		session.getTransaction().commit();
		session.close();
	}

	protected static void delete(Object entity) {
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
	}

	protected static Object findById(String entityname, Long id) {
		Object obj = null;
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		obj = session.get(entityname, id);
		session.getTransaction().commit();
		session.close();
		return obj;

	}

	protected List<Object> findAll(Class cl) {
		List<Object> obj = null;
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from " + cl.getName());
		obj = query.list();
		session.getTransaction().commit();
		session.close();
		return obj;
	}
}
