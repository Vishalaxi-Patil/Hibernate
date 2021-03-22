package com.xworkz.bbc;

import com.xworkz.bbc.dao.BBCDAO;
import com.xworkz.bbc.dao.BBCDAOImpl;
import com.xworkz.bbc.entity.BBCEntity;

public class BBCTester {

	public static void main(String[] args) {

		BBCEntity entity = new BBCEntity();
		// entity.setId(1);
		entity.setName("Divya Urudga");
		entity.setSeason(8);
		entity.setGender("female");
		entity.setNoOfTasks(0);
		entity.setTypeOfContestent("Celebraty");
		entity.setDaysIn(1);

		BBCDAO dao = new BBCDAOImpl();
		dao.create(entity);

		BBCEntity entity2 = new BBCEntity();
		// entity2.setId(2);
		entity2.setName("Manju Pavgad");
		entity2.setGender("Male");
		entity2.setNoOfTasks(0);
		entity2.setTypeOfContestent("Comedian");
		entity2.setDaysIn(1);
		entity2.setSeason(8);

		BBCDAO dao2 = new BBCDAOImpl();
		dao2.create(entity2);

		BBCEntity bbcEntity = dao.getById(3);
		System.out.println(bbcEntity.getName());
		System.out.println(bbcEntity);

		BBCEntity ent = dao.updateNoOFTaskAndDaysInById(3, 2, 2);
		System.out.println(ent);
		
		dao.deleteById(6);
	}

}
