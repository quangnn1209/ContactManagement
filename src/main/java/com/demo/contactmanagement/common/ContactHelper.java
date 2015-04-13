package com.demo.contactmanagement.common;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.demo.contactmanagement.hibernate.HibernateUtility;
import com.demo.contactmanagement.persisted.Contact;

public class ContactHelper {
	public static Contact getPersistantObject(Contact employee) {
		Session hibernateSession = null;
		Transaction transaction = null;
		try {
			hibernateSession = HibernateUtility.getSessionFactory()
					.openSession();
			transaction = hibernateSession.beginTransaction();
			employee = (Contact) hibernateSession.get(Contact.class,
					employee.getId());

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("object not saved  - " + e.getMessage());
		} finally {
			hibernateSession.close();
		}
		return employee;
	}

	public static long saveOrUpdate(Contact employee) {
		Session hibernateSession = null;
		Transaction transaction = null;
		try {
			hibernateSession = HibernateUtility.getSessionFactory()
					.openSession();
			transaction = hibernateSession.beginTransaction();
			hibernateSession.saveOrUpdate(employee);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("object not saved  - " + e.getMessage());
		} finally {
			hibernateSession.close();
		}
		return employee.getId();
	}

	@SuppressWarnings("unchecked")
	public static List<Contact> getAllEmployeess() {
		Session hibernateSession = null;
		Transaction transaction = null;
		List<Contact> objectList = new ArrayList<Contact>();
		try {
			hibernateSession = HibernateUtility.getSessionFactory()
					.openSession();
			transaction = hibernateSession.beginTransaction();
			objectList = hibernateSession.createCriteria(Contact.class).list();
			transaction.commit();
		} catch (HibernateException he) {
			if (transaction != null)
				transaction.rollback();
			System.err.println(he.getMessage());
		}
		return objectList;
	}

	// @SuppressWarnings("unchecked")
	// public static List<Contact> searchEmployees(Contact employee) {
	// Session hibernateSession = null;
	// Transaction transaction = null;
	// List<Contact> objectList = new ArrayList<Contact>();
	// try {
	// hibernateSession = HibernateUtility.getSessionFactory()
	// .openSession();
	// transaction = hibernateSession.beginTransaction();
	// Criteria criteria = hibernateSession.createCriteria(Contact.class);
	// criteria.add(Restrictions.like("empFullName",
	// employee.getEmpFullName(), MatchMode.ANYWHERE));
	// objectList = criteria.list();
	// transaction.commit();
	// } catch (HibernateException he) {
	// if (transaction != null)
	// transaction.rollback();
	// System.err.println(he.getMessage());
	// }
	// return objectList;
	// }

	public static void delete(Contact Contact) {
		Session hibernateSession = null;
		Transaction transaction = null;
		try {
			hibernateSession = HibernateUtility.getSessionFactory()
					.openSession();
			transaction = hibernateSession.beginTransaction();
			Contact = (Contact) hibernateSession.createCriteria(Contact.class)
					.add(Restrictions.eq("id", Contact.getId())).uniqueResult();
			hibernateSession.delete(Contact);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			System.out.println("Could not delete node - " + e.getMessage());
		} finally {
			hibernateSession.close();
		}
	}
}
