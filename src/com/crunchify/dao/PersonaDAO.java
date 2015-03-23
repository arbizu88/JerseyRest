package com.crunchify.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crunchify.entity.Persona;
import com.crunchify.persistence.HibernateUtil;

public class PersonaDAO {

	public void addPerson(Persona persona) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction;

		try {
			transaction = session.beginTransaction();
			session.save(persona);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

	}

}
