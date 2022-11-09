package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Exceptions.EngineerException;
import com.Exceptions.HODException;
import com.model.Engineer;
import com.model.HOD;
import com.utility.DButil;

public class HODDaoImpl implements HODDao{

	@Override
	public String loginHOD(String username, String password) throws HODException {
		String message = "Not able to login check Network Connection";
		
		try(Connection conn =DButil.provideConnection()) {
			
		 PreparedStatement ps =	conn.prepareStatement("select * from hod where username=? and password=?");
		 
		 ps.setString(1, username);
		 ps.setString(2, password);
		 
		ResultSet rs= ps.executeQuery();
		
		if(rs.next())
		{
			HOD hod = new HOD(username,password);
			message = "welcome to Our Hardware and software support system "+hod.getUsername()+".....";
		}
		else
		{
			throw new HODException("Invalid username or password...........");
		}
		 
		 
			
			
		} catch (SQLException e) {
			throw new HODException(e.getMessage()); 
		}
		
		return message;
	}

	@Override
	public String AppointAnEngineer(String EnggName, String EnggUserName, String EnggPassword, String EnggCategory)throws EngineerException {
		String message = "Not Added check Connections";
		
		try(Connection conn = DButil.provideConnection()) {
//			
			PreparedStatement ps=conn.prepareStatement(" insert into engineers (EnggName,EnggUserName,EnggPassword,EnggCategory) "
					+ "values('nitesh','nitesh1234','nitesh96','Hardware')");
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				Engineer engg = new Engineer();
				
				engg.setEnggName(EnggName);
				engg.setEnggUserName(EnggUserName);
				engg.setEnggPassword(EnggPassword);
				engg.setEnggCategory(EnggCategory);
				
				message="New Engineer appointed Successfully......";
			}
			
			
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		return message;
	}

	
//	public String AppointAnEngineer(String EnggName,String EnggUserName,String EnggPassword,String EnggCategory) throws  EngineerException {
//	String message = "Not Added check Connections";
//	
//	try(Connection conn = DButil.provideConnection()) {
//		
//		PreparedStatement ps=conn.prepareStatement(" insert into engineers (EnggName,EnggUserName,EnggPassword,EnggCategory) "
//				+ "values('nitesh','nitesh1234','nitesh96','Hardware')");
//		
//		int x=ps.executeUpdate();
//		
//		if(x>0)
//		{
//			Engineer engg = new Engineer();
//			
//			engg.setEnggName(EnggName);
//			engg.setEnggUserName(EnggUserName);
//			engg.setEnggPassword(EnggPassword);
//			engg.setEnggCategory(EnggCategory);
//		}
//		
//		
//		
//	} catch (SQLException e) {
//		throw new EngineerException(e.getMessage());
//	}
//	
//	
//	return message;
//}

	
	
	

}
