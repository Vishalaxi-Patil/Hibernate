package com.xworkz.bbc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.xworkz.bbc.constants.AppliConstant;
import com.xworkz.bbc.entity.BBCEntity;

public class BBCDAOImpl implements BBCDAO {

	public BBCDAOImpl() {
		System.out.println("invoked BBCDAOImpl");
	}

	@Override
	public void create(BBCEntity entity) {
		System.out.println("invoked create");
		System.out.println("entity: " + entity);
		Configuration cfg = new Configuration();
		cfg.configure(AppliConstant.HIBERNATE_CONFIG_XML_CONST);
		cfg.addAnnotatedClass(BBCEntity.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(entity);
		transaction.commit();
		session.close();
		sf.close();

	}

	@Override
	public BBCEntity getById(int id) {
		Configuration cfg = new Configuration();
		cfg.configure(AppliConstant.HIBERNATE_CONFIG_XML_CONST);
		cfg.addAnnotatedClass(BBCEntity.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		BBCEntity entity = session.get(BBCEntity.class, id);
		transaction.commit();
		session.close();
		sf.close();
		return entity;
	}

	@Override
	public BBCEntity updateNoOFTaskAndDaysInById(int id, int noOfTask, int daysIn) {
		SessionFactory sf = new Configuration().configure(AppliConstant.HIBERNATE_CONFIG_XML_CONST).addAnnotatedClass(BBCEntity.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		BBCEntity entityFromDB = session.get(BBCEntity.class, id);
		if (entityFromDB != null) {
			System.out.println("can update DB");
			entityFromDB.setNoOfTasks(noOfTask);
			entityFromDB.setDaysIn(daysIn);
			session.update(entityFromDB);
			tr.commit();
		} else {
			System.out.println("can not update DB");
		}
		session.close();
		sf.close();
		return entityFromDB;
	}

	@Override
	public void deleteById(int id) {
		SessionFactory sf = new Configuration().configure(AppliConstant.HIBERNATE_CONFIG_XML_CONST).addAnnotatedClass(BBCEntity.class).buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		BBCEntity entityFromDB = session.get(BBCEntity.class, id);
		if (entityFromDB != null) {
			session.delete(entityFromDB);
			tr.commit();
			System.out.println("deleted successfully");
		} else {
			System.out.println("can not delete");
		}
		session.close();
		sf.close();
	}
}
