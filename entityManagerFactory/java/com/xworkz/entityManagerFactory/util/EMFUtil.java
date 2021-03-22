package com.xworkz.entityManagerFactory.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.xworkz.entityManagerFactory.exception.EMFConnectionException;

public class EMFUtil {
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
	static {
		try {
			factory=Persistence.createEntityManagerFactory("com.xworkz.jpa");
		if(factory!=null) {
			System.out.println("can load factory");
		}else {
			throw new EMFConnectionException("Factory not loaded");
		}
	}catch (EMFConnectionException e) {
		System.out.println("Entity Manager Factory not loaded"+e.getMessage());
	}
	
	}

}
