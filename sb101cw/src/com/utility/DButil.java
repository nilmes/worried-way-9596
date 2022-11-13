package com.utility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
     
	public static Connection provideConnection(){
	Connection conn = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	String url="jdbc:mysql://localhost:3306/sb101_project";
	
	try {
	  conn =DriverManager.getConnection(url,"root","Nitesh96#");
	
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return conn;
	
//	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("driver found");
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//		}
//		
//		String url="jdbc:mysql://localhost:3306/sb101_project";
//		
//		try {
//		Connection  conn =DriverManager.getConnection(url,"root","Nitesh96#");
//		if(conn!=null)
//		{
//			System.out.println("connected");
//		}
//		
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
	}
}

