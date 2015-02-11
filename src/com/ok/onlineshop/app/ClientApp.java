package com.ok.onlineshop.app;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ok.onlineshop.model.User;
import com.ok.onlineshop.util.HibernateUtil;

public class ClientApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trans = null;

		try {
			trans = session.beginTransaction();
			User user = new User();
			user.setUserid(1);
			user.setUsername("test");
			user.setPassword("test");
			user.setEmail("test@hoop.com");

			session.save(user);
			// session.flush();
			trans.commit();
		}
		catch (HibernateException e) {
			if (trans != null) {
				trans.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
}
