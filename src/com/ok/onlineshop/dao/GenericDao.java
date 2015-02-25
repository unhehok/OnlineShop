package com.ok.onlineshop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDao {

	private static SessionFactory	sessionFactory;

	public GenericDao(SessionFactory sessionFactory) {
		GenericDao.sessionFactory = sessionFactory;
	}

	@Transactional
	protected static void save(Object entity) {
		GenericDao.sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Transactional
	protected static void delete(Object entity) {
		GenericDao.sessionFactory.getCurrentSession().delete(entity);
	}

	@Transactional
	protected static Object findById(Class<?> cl, BigDecimal id) {
		Object obj = GenericDao.sessionFactory.getCurrentSession().get(cl, id);
		return obj;

	}

	@Transactional
	protected static BigDecimal findOne(String sql) {
		BigDecimal id =
				(BigDecimal) GenericDao.sessionFactory.getCurrentSession()
						.createSQLQuery(sql);
		return id;
	}

	@Transactional
	protected static <T> List<T> findAll(Class<?> cl) {
		List<T> obj = new ArrayList<T>();
		obj =
				GenericDao.sessionFactory.getCurrentSession()
						.createQuery("from " + cl.getName()).list();
		return obj;
	}

	@Transactional
	protected static <T> List<T> findList(String hql) {
		List<T> obj = new ArrayList<T>();
		obj = GenericDao.sessionFactory.getCurrentSession().createQuery(hql).list();
		return obj;
	}
}
