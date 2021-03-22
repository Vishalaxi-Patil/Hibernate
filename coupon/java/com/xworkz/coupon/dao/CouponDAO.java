package com.xworkz.coupon.dao;

import java.util.List;

import com.xworkz.coupon.entity.CouponEntity;

public interface CouponDAO {
	
	
	public void create(CouponEntity entity);
	
	public void updateValidMonthsById(int id,int validMonths);
	
	public CouponEntity getById(int id);
	
	public void deleteById(int id);
	
	public void createAll(List<CouponEntity> entities);
	

}
