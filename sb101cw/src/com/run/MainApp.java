package com.run;

import java.util.Scanner;

import com.EmployeeUseCases.LoginEmployeeUseCase;
import com.EmployeeUseCases.RegisterEmployeeUseCase;
import com.EngineerUseCases.EngineerloginUseCase;
import com.HODusecases.HOD_Options;



public class MainApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String hod_id="nitu";
		String hod_password ="admin";
		
        System.out.println("Welcome to The System..!");
		
		System.out.println("Choose Your Option");
		
		System.out.println("\n1: HOD Login.. \n2: Engineer Login.. \n3: Employee section.. \n");
		
		int choice=sc.nextInt();
		
		
		switch(choice) 
		{
		case 1 :
			System.out.println("Enter HOD username:");
			String id=sc.next();
			System.out.println("Enter HOD password:");
			String pass=sc.next();
			if(id.equals(hod_id) && pass.equals(hod_password)) {
				System.out.println("Welcome:");
				HOD_Options.HOD_Section();		
			}
			else {
				System.out.println("Invalid Username or Password:");
				
			}
			break;
			
		case 2 :
			EngineerloginUseCase.main(null);
			break;
			 
		case 3 :
			System.out.println("please make a choice");
			System.out.println("1:Register as new Employee \n2: Login as a registered Employee");
			
			int choice2 = sc.nextInt();
			if(choice2==1)
			{
				RegisterEmployeeUseCase.main(null);
			}
			else if(choice2==2)
			{
				LoginEmployeeUseCase.main(null);
			}
			else
			{
				System.out.println("Invalid Input..!");
			}
			break;
		default:
				System.out.println("Invalid input try again..");
				MainApp.main(null);
		}
		

	}

}
