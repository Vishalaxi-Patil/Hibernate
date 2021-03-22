package com.xworkz.icecream.repository;

import java.util.List;

import com.xworkz.icecream.entity.IceCreamEntity;

public interface IceCreamRepository {

	public void persist(IceCreamEntity entity);
	
	public void deleteByName(String name);
	
	public void updatePriceByName(String name,double price);
	
	public List<IceCreamEntity> getAll();
	
	public Object findByNameAndPrice(String name,double price);
	
	public Object getMaxPrice();
	
	public Object getMinPrice();
	
	public Object getBySumPrice();
	
	public Object getPriceByName(String name);
	
	public List<Object[]> getNameAndFlavourByPrice(double price);
	
	
	
}
