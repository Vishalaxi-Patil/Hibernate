package com.xworkz.decor.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.xworkz.interior.dao.InteriorDAO;
import com.xworkz.interior.dto.InteriorDTO;

public class DecorInteriorDAOImpl implements InteriorDAO {

	
	public DecorInteriorDAOImpl() {
		System.out.println("Created DecorInteriorDAOImpl");
	}
	@Override
	public void create(InteriorDTO dto) {
		System.out.println("invoked create DecorInteriorDAOImpl");
		System.out.println("arg1: "+dto);
		Connection con=null;
			
			try{
				con=DriverManager.getConnection("jdbc:mysql://localhost:3360/x-workz","root","root");
				Statement stmt=con.createStatement();
				
				StringBuffer sql=new StringBuffer("insert into interior values ");
				sql.append("(").append(dto.getHid()).append(",").append("'").append(dto.getMestriName()).append("'")
				.append(",").append(dto.getForWhat()).append(",").append(dto.getDimension()).append(",").append(dto.getBudget())
				.append(")");
				
				System.out.println(sql.toString());
				
				boolean isExecute=stmt.execute(sql.toString());
				
				System.out.println("query executed");
				System.out.println(isExecute);
		}catch (SQLException e) {
			e.printStackTrace();
		} 

	}

	@Override
	public void deleteById(int id) {
		System.out.println("invoked deleteById");
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3360/x-workz","root","root")){
			PreparedStatement stmt=con.prepareStatement("delete from interior where INTERIOR_ID=?");
			stmt.setInt(1, id);
			int sql=stmt.executeUpdate();
			System.out.println(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public InteriorDTO fetchByMestriName(String name) {
		InteriorDTO dto=new InteriorDTO();
		System.out.println("invoked fetchByMestriName");
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3360/x-workz","root","root")){
			Statement stmt=con.createStatement();
			ResultSet resultset=stmt.executeQuery("select * from interior where MESTRI_NAME='"+name+"'");
			resultset.next();
			dto.setHid(resultset.getInt(1));
			dto.setMestriName(resultset.getString(2));
			dto.setForWhat(resultset.getInt(3));
			dto.setDimension(resultset.getDouble(4));
			dto.setBudget(resultset.getDouble(5));
			
			System.out.println(dto);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int total() {
		int count=0;
		System.out.println("invoked total method");
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3360/x-workz","root","root")){
			Statement stmt=con.createStatement();
			ResultSet resultset=stmt.executeQuery("select count(*) from interior");
			resultset.next();
			count=resultset.getInt(1);
			
			System.out.println(count);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public InteriorDTO updateByMestriName(String name, int id) {
		InteriorDTO dto=new InteriorDTO();
		System.out.println("invoked updateByMestriName");
		try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3360/x-workz","root","root")){
			PreparedStatement stmt=con.prepareStatement("update interior set MESTRI_NAME=? where INTERIOR_ID=?");
			stmt.setString(1, name);
			stmt.setInt(2, id);
			int result=stmt.executeUpdate();
			System.out.println(result);
			
			ResultSet resultSet=stmt.executeQuery("select * from interior where INTERIOR_ID="+id);
			resultSet.next();
			dto.setHid(resultSet.getInt(1));
			dto.setMestriName(resultSet.getString(2));
			dto.setForWhat(resultSet.getInt(3));
			dto.setDimension(resultSet.getDouble(4));
			dto.setBudget(resultSet.getDouble(5));
			
			System.out.println(dto);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
