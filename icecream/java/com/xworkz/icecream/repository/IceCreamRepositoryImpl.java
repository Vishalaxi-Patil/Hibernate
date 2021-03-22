package com.xworkz.icecream.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.xworkz.entityManagerFactory.util.EMFUtil;
import com.xworkz.icecream.entity.IceCreamEntity;

public class IceCreamRepositoryImpl implements IceCreamRepository {
	
	private EntityManagerFactory factory=EMFUtil.getFactory();
	
	@Override
	public void persist(IceCreamEntity entity) {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		manager.close();
		}catch (Exception e) {
	        e.printStackTrace();
	        manager.getTransaction().rollback();
		}
	}

	@Override
	public void deleteByName(String name) {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Query q=manager.createNamedQuery("deleteByName");
		q.setParameter("nm", name);
		q.executeUpdate();
		manager.getTransaction().commit();
		}finally {
			manager.close();
		}
		
	}

	@Override
	public void updatePriceByName(String name, double price) {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		manager.getTransaction().begin();
		Query q=manager.createNamedQuery("updatePriceByName");
		q.setParameter("nm", name);
		q.setParameter("pr", price);
		q.executeUpdate();
		manager.getTransaction().commit();
		}finally {
			manager.close();
		}
		
	}

	@Override
	public List<IceCreamEntity> getAll() {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("getAll");
		List<IceCreamEntity> list=q.getResultList();
		return list;
		}finally {
			manager.close();
		}
	}

	@Override
	public Object findByNameAndPrice(String name, double price) {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("findByNameAndPrice");
		q.setParameter("nm", name);
		q.setParameter("pr", price);
		Object entity=q.getSingleResult();
		return entity;
		}finally {
			manager.close();
		}
		
	}

	@Override
	public Object getMaxPrice() {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("getMaxPrice");
		Object entity=q.getSingleResult();
		return entity;
		}finally {
			manager.close();
		}
	}

	@Override
	public Object getMinPrice() {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("getMinPrice");
		Object entity=q.getSingleResult();
		return entity;
		}finally {
			manager.close();
		}
	}

	@Override
	public Object getBySumPrice() {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("getBySumPrice");
		Object entity=q.getSingleResult();
		return entity;
		}finally {
			manager.close();
		}
	}

	@Override
	public Object getPriceByName(String name) {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("getPriceByName");
		q.setParameter("nm", name);
		Object entity=q.getSingleResult();
		return entity;
		}finally {
			manager.close();
		}
	}

	@Override
	public List<Object[]> getNameAndFlavourByPrice(double price) {
		EntityManager manager=null;
		try {
		manager=factory.createEntityManager();
		Query q=manager.createNamedQuery("getNameAndFlavourByPrice");
		q.setParameter("pr", price);
		List<Object[]> entity=q.getResultList();
		return entity;
		}finally {
			manager.close();
		}
	}

}
