package com.xworkz.coupon.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.coupon.entity.CartoonEntity;
import com.xworkz.coupon.entity.CartoonEntity.Channel;
import com.xworkz.util.util.SFUtil;

public class CartoonDAOImpl implements CartoonDAO{
	
	
	private SessionFactory factory = SFUtil.getFactory();

	@Override
	public void save(List<CartoonEntity> list) {
		System.out.println("invoked create");
		System.out.println("entity" + list);
		Session session = null;
		try {
			session = factory.openSession();
			int count = 0;
			session.beginTransaction();
			for (CartoonEntity cartoonEntity : list) {
				session.save(cartoonEntity);
				count++;
				if (count == 5) {
					session.flush();
					count = 0;
					System.out.println("flush is used");
				}

			}

			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();

		}

	}

	@Override
	public CartoonEntity findByName(String name) {

		try (Session session = this.factory.openSession()) {
			String hqlSyntax = "SELECT CART FROM CartoonEntity CART WHERE CART.name='" + name + "'";
			Query<CartoonEntity> query = session.createQuery(hqlSyntax);
			CartoonEntity cartoonEntity = query.uniqueResult();
			return cartoonEntity;

		}
	}

	@Override
	public CartoonEntity findByChannelAndLanguage(Channel channel, String lang) {
		try(Session session=this.factory.openSession()){
			String hqlSyntax1="SELECT CART FROM CartoonEntity CART WHERE CART.channel='"+channel+"' AND CART.language='"+lang+"'";
			Query<CartoonEntity> query1=session.createQuery(hqlSyntax1);
			CartoonEntity cartoonEntity = query1.uniqueResult();
			return cartoonEntity;

	
		
		}
		
	}

}
              