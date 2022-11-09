package com.usecases;

import java.sql.SQLException;
import java.util.Scanner;

import com.Dao.HODDao;
import com.Dao.HODDaoImpl;
import com.Exceptions.EngineerException;
import com.Exceptions.HODException;


public class MainUseCase {

	public static void main(String[] args) {
		Scanner sc  =new Scanner(System.in);
		
		
		
			System.out.println("Welcome to Our SYSTEM ENGINEERS DEPARTMENT");
			System.out.println("Please Enter your Choice");
			System.out.println("Enter 1. for HOD Services..");
			System.out.println("Enter 2. for Engineers Services...");
			System.out.println("Enter 3. for Employee Services....");
			System.out.println("Enter 4. for Exit");
			
			
			int choice = sc.nextInt();
			
			switch(choice)
			{
			   case 1:
			       {
				    System.out.println("Welcome to HOD Administration... ");
				    System.out.println("Please Enter your username...");
				    String username = sc.next();
				    System.out.println("Please Enter your password...");
				    String password = sc.next();
				    
				    HODDao dao = new HODDaoImpl();
				    try {
						 String message=dao.loginHOD(username, password);
						 System.out.println(message);
						 System.out.println("please enter your choice");
						 System.out.println("Enter 1. To appoint a new Engineer...");
						System.out.println("Enter 2. To listout all engineers working in departments....");
						System.out.println("Enter 3. To terminate engineer from work.... ");
						System.out.println("Enter 4. To see all problems  raised by employees.... ");
						System.out.println("Enter 5. To assign problems to Engineers.... ");
						int choiceOfhod = sc.nextInt();
						
						switch(choiceOfhod)
						{
						case 1:
						   {
							  while(true)
							  {
								  System.out.println("Enter Engineer Name:");
						    		String EnggName= sc.next();
						    		
						    		System.out.println("Enter Engineer UserName (should be unique):");
						    		String EnggUserName = sc.next();
						    		
						    		System.out.println("Enter Engineer password:");
						    		String EnggPassword= sc.next();
						    		
						    		System.out.println("Enter Engineer Category :");
						    		String EnggCategory= sc.next();
						    		
						    		HODDao daoh = new HODDaoImpl();
						    		
						    		try {
									  String messagehod=daoh.AppointAnEngineer(EnggName, EnggUserName, EnggPassword, EnggCategory);
									  System.out.println(messagehod);
									} catch (EngineerException e) {
										System.out.println(e.getMessage());
										break;
									}
						    		
						    		System.out.println("To appoint more engineers enter 'yes' or 'no' ");
						    		String e = sc.next();
						    		
						    		if(e.equalsIgnoreCase("no"))
						    		{
						    			break;
						    		}
							  }
							   
					    		
					    		
						   }
						   
						  default:{
					    	   System.out.println("Invalid input ");
					       }
					       break;
						   
						}
						
						
					} catch (HODException e) {
						System.out.println(e.getMessage());
						break;
					}
				    
			    	 
				    
				    
				    
				    
			       }
			       
			       
			       
			       
			       
			       
			       
			       
			       
			       break;
			       default:{
			    	   System.out.println("Invalid input ");
			       }
			       break;
			}
		

	}

}
