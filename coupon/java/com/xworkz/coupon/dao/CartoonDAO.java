package com.xworkz.coupon.dao;

import java.util.List;

import com.xworkz.coupon.entity.CartoonEntity;
import com.xworkz.coupon.entity.CartoonEntity.Channel;

public interface CartoonDAO {
	
		public void save(List<CartoonEntity> list);
		
		
		public CartoonEntity findByName(String name);
		
		
		public CartoonEntity findByChannelAndLanguage(Channel channel,String lang);

	}
	

