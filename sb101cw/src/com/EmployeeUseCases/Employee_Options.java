package com.EmployeeUseCases;

import java.util.Scanner;

public class Employee_Options {
    
	public static void Select(int id)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select an Option to continue ");
		
		System.out.println(
		"1:Register Problems"+
		"\n2: See status of Problems"+
		"\n3: See problem History"+
		"\n4: change password"+
		"\n5: Exit this Service "
		); 
		
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			RegisterProblemUseCase.main(null);
			
			Employee_Options.Select(id);
			break;
		default:
			System.out.println("Invalid Input..!");
				
		}
	}
}
