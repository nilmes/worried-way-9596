package com.EngineerUseCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.Enggdao;
import com.dao.EnggdaoImpl;
import com.exception.EngineerException;
import com.model.Problem;
import com.run.MainApp;

public class Engineer_options {

	public static void select(int id ) {
       
		Enggdao dao = new EnggdaoImpl();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please Select an Option to continue:");
		
		System.out.println("1: To see all assigned problems"
		+"\n2: To update status of problems "
		+"\n3: To  see list of all attended/solved problems"
		+"\n4: To change password"
		+"\n5: Exit the app"
		);
      
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			AssignedProbUseCase.main(id);
			
			Engineer_options.select(id);
			break;
		case 2:
			updateProblemUseCase.main(null);
			
			Engineer_options.select(id);
			break;
		case 3:
			 SolvedProblemlistUseCase.main(id);
			 
			 Engineer_options.select(id);
			 break;
		case 4:
			UpdatePasswordUseCase.main(id);
			
			 Engineer_options.select(id);
			 break;
		case 5:
			 System.out.println("Thankyou for Using our Engineers service..");
			 MainApp.main(null);
			 return ;
			 
		default:
			System.out.println("Wrong Input...!");
			
			Engineer_options.select(id);
		    break;
			
		}
		
		
			

	}

}
