package com.HODusecases;

import java.util.Scanner;


import com.dao.HODdao;
import com.dao.HODdaoImpl;
import com.exception.EngineerException;



public class RegisterEnggUseCase {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Engineer Name:");
		String EnggName= sc.next();
		
		System.out.println("Enter Engineer UserName (should be unique):");
		String EnggUserName = sc.next();
		
		System.out.println("Enter Engineer password:");
		String EnggPassword= sc.next();
		
		System.out.println("Enter Engineer Category :");
		String EnggCategory= sc.next();
		
		HODdao dao = new HODdaoImpl();
		
		try {
		String	message=dao.AppointAnEngineer(EnggName, EnggUserName, EnggPassword, EnggCategory);
		System.out.println(message);
		} catch (EngineerException e) {
			
			System.out.println(e.getMessage());
		}
		
		

	}

}
