package com.EmployeeUseCases;

import java.util.Scanner;

import com.EngineerUseCases.UpdatePasswordUseCase;
import com.run.MainApp;

public class Employee_Options {
    
	public static void Select(int id)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please select an Option to continue ");
		
		System.out.println(
		"1:Register Problems"+
		"\n2: To check who engineer is assigned to your Problem"+
		"\n3: To See problem History"+
		"\n4: change password"+
		"\n5: Exit this Service "
		); 
		
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			RegisterProblemUseCase.main(id);
			Employee_Options.Select(id);
			break;
		case 2:
			CheckEnggNameUseCase.main(null);			
			Employee_Options.Select(id);
			break;
		case 3:
			CompHistByEmpUseCase.main(id);			
			Employee_Options.Select(id);
			break;
		case 4:
			UpdateEmpPassUseCase.main(id);		
			Employee_Options.Select(id);
			break;
		case 5:
			System.out.println("Thankyou for using our Employee Services..");
			MainApp.main(null);
			break;
			
		default:
			System.out.println("Invalid Input..! try again..");
			Employee_Options.Select(id);
				
		}
	}
}
