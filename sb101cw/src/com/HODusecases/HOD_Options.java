package com.HODusecases;

import java.util.Scanner;



public class HOD_Options {

	public static void HOD_Section() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Select an Option to continue:");
		System.out.println("1: Register a new Engineer \n2: See List of All Engineers "
				+ "\n3: Delete Engineer From System \n4: See All the Raised Problems"
				+ " \n5: Assign Problem To Engineers \n6: Exit The App");
		
		int choice=sc.nextInt();
		
		switch (choice)
		{
		case 1:
			  RegisterEnggUseCase.main(null);
			  HOD_Options.HOD_Section();
			  break;
			  
		case 2:
			  ListAllEngineerUseCase.main(null);
			  HOD_Options.HOD_Section();
			  break;
			  
		case 3:
			 DeleteEngineerUseCase.main(null);
			 HOD_Options.HOD_Section();
			 break;
			 
		case 4:
			GetAllProblemsUseCase.main(null);
			HOD_Options.HOD_Section();
			 break;
		 
		case 5 :
			AssignProblemUseCase.main(null);
			HOD_Options.HOD_Section();
			 break;
		}

	}

}
