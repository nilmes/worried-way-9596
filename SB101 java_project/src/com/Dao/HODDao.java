package com.Dao;

import com.Exceptions.EngineerException;
import com.Exceptions.HODException;

public interface HODDao {

	public String loginHOD(String username,String password)throws HODException;
	
	public String AppointAnEngineer(String EnggName,String EnggUserName,String EnggPassword,String EnggCategory) throws EngineerException ;
	
	
}
