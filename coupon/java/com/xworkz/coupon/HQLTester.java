package com.xworkz.coupon;

import com.xworkz.coupon.dao.CartoonDAO;
import com.xworkz.coupon.dao.CartoonDAOImpl;
import com.xworkz.coupon.entity.CartoonEntity;
import com.xworkz.coupon.entity.CartoonEntity.Channel;

public class HQLTester {

	public static void main(String[] args) {

		CartoonDAO cartoonDao = new CartoonDAOImpl();
		CartoonEntity entityFromDb = cartoonDao.findByName("Jerry");
		System.out.println(entityFromDb);
		CartoonEntity entity1 = cartoonDao.findByChannelAndLanguage(Channel.HUNGMA, "Eng");
		System.out.println(entity1);

	}

}
