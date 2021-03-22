package com.xworkz.decor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.xworkz.decor.constants.AppConstant;
import com.xworkz.decor.impl.DecorInteriorDAOImpl;
import com.xworkz.interior.dao.InteriorDAO;
import com.xworkz.interior.dto.InteriorDTO;

public class DecorTester {

	public static void main(String[] args) {
		
		Connection con=null;
		
		InteriorDTO dto = new InteriorDTO();
		dto.setHid(1);
		dto.setMestriName("Sharat");
		dto.setForWhat(AppConstant.HOME_INTERIOR);
		dto.setBudget(300000);
		dto.setDimension(1000);
		
		
		InteriorDTO dto1 = new InteriorDTO();
		dto1.setHid(2);
		dto1.setMestriName("Naveed");
		dto1.setForWhat(AppConstant.HOME_INTERIOR);
		dto1.setBudget(400000);
		dto1.setDimension(2000);
		
		InteriorDAO dao=new DecorInteriorDAOImpl();
		dao.create(dto1);

		try{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/x-workz", "root", "root");
			Statement stmt = con.createStatement();

			StringBuffer sql = new StringBuffer("insert into interior values ");
			sql.append("(").append(dto1.getHid()).append(",").append("'").append(dto1.getMestriName()).append("'")
					.append(",").append(dto1.getForWhat()).append(",").append(dto1.getDimension()).append(",")
					.append(dto1.getBudget()).append(")");

			System.out.println(sql.toString());

			boolean isExecute = stmt.execute(sql.toString());

			System.out.println("query executed");
			System.out.println(isExecute);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
