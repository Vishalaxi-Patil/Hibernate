package com.xworkz.coupon.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.coupon.entity.CouponEntity;
import com.xworkz.util.util.SFUtil;

public class CouponDAOImpl implements CouponDAO {

	private SessionFactory factory = SFUtil.getFactory();

	@Override
	public void create(CouponEntity entity) {
		System.out.println("invoked create");
		System.out.println("entity: " + entity);
		try (Session session = factory.openSession()) {
			Transaction tr = session.beginTransaction();
			session.save(entity);
			tr.commit();
		}

	}

	@Override
	public void updateValidMonthsById(int id, int validMonths) {
		System.out.println("invoked updateValidMonthsById");
		try (Session session = factory.openSession()) {
			Transaction tr = session.beginTransaction();
			CouponEntity entityFromDB = session.get(CouponEntity.class, id);
			if (entityFromDB != null) {
				entityFromDB.setValidMonths(validMonths);
				session.update(entityFromDB);
				tr.commit();
			}
		}

	}

	@Override
	public CouponEntity getById(int id) {
		System.out.println("invoked getById");
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		CouponEntity entityFromDB = session.get(CouponEntity.class, id);
		tr.commit();
		return entityFromDB;

	}

	@Override
	public void deleteById(int id) {
		System.out.println("invoked getById");
		try (Session session = factory.openSession()) {
			Transaction tr = session.beginTransaction();
			CouponEntity entityFromDB = session.get(CouponEntity.class, id);
			if (entityFromDB != null) {
				session.delete(entityFromDB);
				tr.commit();
			}
		}
	}

	@Override
	public void createAll(List<CouponEntity> entities) {
		System.out.println("invoked createAll");
		int count = 0;
		Transaction tr = null;
		try {
			Session session = factory.openSession();
			tr = session.beginTransaction();
			for (CouponEntity couponEntity : entities) {
				session.save(couponEntity);
				count++;
				if (count == 2) {
					session.flush();
					count = 0;
					System.out.println("flushed");
				}
			}

			tr.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tr.rollback();
		}
	}
}
