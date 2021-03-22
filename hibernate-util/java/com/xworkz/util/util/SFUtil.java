package com.xworkz.util.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.xworkz.util.exception.SFCreationException;

public class SFUtil {
	
	private static SessionFactory factory;

	public static SessionFactory getFactory() {
		return factory;
	}

	static {
		try {
			Configuration cfg = new Configuration();
			cfg.configure();
		    factory = cfg.buildSessionFactory();
			if (factory != null) {
				System.out.println("SFUtil created successfully");
			} else {
				throw new SFCreationException("SFUtil can not be created");
			}

		} catch (Exception e) {
			throw new SFCreationException(e.getMessage());
		}
	}


}
