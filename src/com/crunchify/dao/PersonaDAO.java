package com.crunchify.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.crunchify.entity.Persona;
import com.crunchify.persistence.HibernateUtil;

public class PersonaDAO {

	public Integer addPerson(Persona persona) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction;
		Integer newId = null;

		try {
			transaction = session.beginTransaction();
			session.save(persona);
			newId = persona.getId();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return newId;

	}

	public Persona getPersonById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Persona person = null;
		try {
			person = (Persona) session.get(Persona.class, id);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return person;

	}

	public Persona updatePersona(Persona person) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction;
		try {
			transaction = session.beginTransaction();
			session.update(person);
			transaction.commit();
		} catch (HibernateException e) {
			System.out.println("Custom 10012: Hibernate transaction error");
		} finally {
			session.close();
		}

		return person;
	}

}
