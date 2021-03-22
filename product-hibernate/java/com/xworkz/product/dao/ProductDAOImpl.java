package com.xworkz.product.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.xworkz.product.entity.ProductEntity;
import com.xworkz.product.entity.ProductEntity.ProductType;
import com.xworkz.product.util.SFUtil;

public class ProductDAOImpl implements ProductDAO {

	private SessionFactory factory=SFUtil.getFactory();
	
	@Override
	public void persist(ProductEntity entity) {
		Transaction tr=null;
		Session session=null;
		int count=0;
		try{
			session=factory.openSession();
			tr=session.beginTransaction();
			session.save(entity);
			count++;
			if(count==3) {
				session.flush();
				count=0;
			}
			tr.commit();
		}catch (HibernateException e) {
			tr.rollback();
		}finally {
			session.close();
		}

	}

	@Override
	public ProductEntity findByNameAndManufacturer(String name, String manufacturer) {
	    try(Session session=factory.openSession()){
           String hql="select product from ProductEntity product where name=:nm and manufacturer=:mf";
           Query<ProductEntity> qr=session.createQuery(hql);
           qr.setParameter("nm", name);
           qr.setParameter("mf", manufacturer);
           ProductEntity ent=qr.uniqueResult();
	       return ent;	
	    }
	}

	@Override
	public ProductEntity findByTypeAndBrandAndName(String name, String brand, ProductType type) {
		try(Session session=factory.openSession()){
	           String hql="select product from ProductEntity product where name=:nm and brand=:brand and type=:type";
	           Query<ProductEntity> qr=session.createQuery(hql);
	           qr.setParameter("nm", name);
	           qr.setParameter("brand", brand);
	           qr.setParameter("type", type);
	           ProductEntity ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public Double findPriceByTypeAndBrandAndName(String name, String brand, ProductType type) {
		try(Session session=factory.openSession()){
	           String hql="select product.price from ProductEntity product where name=:nm and brand=:brand and type=:type";
	           Query<Double> qr=session.createQuery(hql);
	           qr.setParameter("nm", name);
	           qr.setParameter("brand", brand);
	           qr.setParameter("type", type);
	           Double ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public Object[] findPriceAndQuantityByTypeAndBrandAndName(String name, String brand, ProductType type) {
		try(Session session=factory.openSession()){
	           String hql="select product.price,product.quantity from ProductEntity product where name=:nm and brand=:brand and type=:type";
	           Query<Object[]> qr=session.createQuery(hql);
	           qr.setParameter("nm", name);
	           qr.setParameter("brand", brand);
	           qr.setParameter("type", type);
	           Object[] ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public ProductEntity findByTypeAndBrandAndQuality(String name, String brand, boolean quality) {
		try(Session session=factory.openSession()){
	           String hql="select product from ProductEntity product where name=:nm and brand=:brand and quality=:quality";
	           Query<ProductEntity> qr=session.createQuery(hql);
	           qr.setParameter("nm", name);
	           qr.setParameter("brand", brand);
	           qr.setParameter("quality", quality);
	           ProductEntity ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public Object[] findNameAndTypeById(int id) {
		try(Session session=factory.openSession()){
	           String hql="select product.name,product.type from ProductEntity product where id=:id";
	           Query<Object[]> qr=session.createQuery(hql);
	           qr.setParameter("id", id);
	           Object[] ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public int findMaxId() {
		try(Session session=factory.openSession()){
	           String hql="select max(product.id) from ProductEntity product";
	           Query<Integer> qr=session.createQuery(hql);
	           int ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public long findSize() {
		try(Session session=factory.openSession()){
	           String hql="select count(product) from ProductEntity product";
	           Query<Long> qr=session.createQuery(hql);
	           long ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public double findMaxPrice() {
		try(Session session=factory.openSession()){
	           String hql="select max(product.price) from ProductEntity product";
	           Query<Double> qr=session.createQuery(hql);
	           double ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public double findSumOfPrice() {
		try(Session session=factory.openSession()){
	           String hql="select sum(product.price) from ProductEntity product";
	           Query<Double> qr=session.createQuery(hql);
	           double ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public int findMinId() {
		try(Session session=factory.openSession()){
	           String hql="select min(product.id) from ProductEntity product";
	           Query<Integer> qr=session.createQuery(hql);
	           int ent=qr.uniqueResult();
		       return ent;	
		    }
	}

	@Override
	public List<ProductEntity> findDistinct() {
		try(Session session=factory.openSession()){
	           String hql="select distinct product.name from ProductEntity product";
	           Query<ProductEntity> qr=session.createQuery(hql);
	           List<ProductEntity> ent=qr.getResultList();
		       return ent;	
		    }
	}

}
