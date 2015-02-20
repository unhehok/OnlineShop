package com.ok.onlineshop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ok.onlineshop.util.HibernateUtil;

public abstract class GenericDao {

	protected static void save(Object entity) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	protected static void delete(Object entity) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			session.delete(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	protected static Object findById(Class<?> cl, BigDecimal id) {
		Session session = null;
		Transaction tx = null;
		Object obj = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			obj = session.get(cl, id);
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;

	}

	protected static BigDecimal findOne(String sql) {
		Session session = null;
		Transaction tx = null;
		BigDecimal id = null;
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			SQLQuery q = session.createSQLQuery(sql);
			id = (BigDecimal) q.uniqueResult();
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return id;
	}

	protected static <T> List<T> findAll(Class cl) {
		Session session = null;
		Transaction tx = null;
		List<T> obj = new ArrayList<T>();
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("from " + cl.getName());
			obj = query.list();
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	protected static <T> List<T> findList(String hql) {
		Session session = null;
		Transaction tx = null;
		List<T> obj = new ArrayList<T>();
		try {
			session = HibernateUtil.openSession();
			tx = session.beginTransaction();
			obj = session.createQuery(hql).list();
			tx.commit();
		}
		catch (RuntimeException e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}
}
