package com.xworkz.bbc.dao;

import com.xworkz.bbc.entity.BBCEntity;

public interface BBCDAO {
	public void create(BBCEntity entity);

	public BBCEntity getById(int id);

	public BBCEntity updateNoOFTaskAndDaysInById(int id, int noOfTask, int daysIn);
	
	public void deleteById(int id);

}
