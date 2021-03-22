package com.xworkz.coupon;


import java.util.ArrayList;
import java.util.List;

import com.xworkz.coupon.dao.CartoonDAO;
import com.xworkz.coupon.dao.CartoonDAOImpl;
import com.xworkz.coupon.entity.CartoonEntity;
import com.xworkz.coupon.entity.CartoonEntity.Channel;

public class CartoonTester {

	public static void main(String[] args) {
		List<CartoonEntity> entity=new ArrayList<CartoonEntity>();
	    CartoonEntity cartoon=new CartoonEntity();
	   // cartoon.setCid(1);
	    cartoon.setName("Tom");
	    cartoon.setChannel(Channel.CN);
	    cartoon.setShow_name("Tom and Jerry");
	    cartoon.setLanguage("English");
	    entity.add(cartoon);
	    entity.add(new CartoonEntity("Mickey Mouse", "Mickey Mouse", Channel.DISNEY, "Eng"));
	    entity.add(new CartoonEntity("Mr.Bean", "Bean", Channel.POGO, "Eng"));
	    entity.add(new CartoonEntity("Doremon", "Doremon", Channel.CN, "Eng"));
	    entity.add(new CartoonEntity("Shinchan", "Shinchan", Channel.HUNGMA, "Eng"));
	    entity.add(new CartoonEntity("Power1", "Power Rangers", Channel.POGO, "Eng"));
	    entity.add(new CartoonEntity("Bheem", "Chota Bheem", Channel.POGO, "Eng"));
	    entity.add(new CartoonEntity("Raju", "Chota Bheem", Channel.POGO, "Eng"));
	    entity.add(new CartoonEntity("Chutki", "Chota Bheem", Channel.POGO, "Eng"));
	    entity.add(new CartoonEntity("Jerry", "Tom and Jerry", Channel.CN, "Eng"));
	    
	    
	    
	    
	    CartoonDAO dao=new CartoonDAOImpl();
	    dao.save(entity);

	}

}
