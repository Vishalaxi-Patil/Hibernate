package com.xworkz.product.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xworkz.product.exception.SFConnectionException;


public class SFUtil {
	
	private static SessionFactory factory;
	
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
	
	static {
		try {
			Configuration conf=new Configuration();
			conf.configure();
			factory=conf.buildSessionFactory();
			if(factory!=null) {
				System.out.println("can load factory");
			}else {
				throw new SFConnectionException("Session Factory not loaded");
			}
			
		}catch (SFConnectionException e) {
			System.out.println("Session Factory not loaded"+e.getMessage());
		}
	}

}
