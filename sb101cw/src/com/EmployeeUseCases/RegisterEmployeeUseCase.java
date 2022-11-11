package com.EmployeeUseCases;

import java.util.Scanner;

import com.dao.Employeedao;
import com.dao.EmployeedaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;
import com.run.MainApp;

public class RegisterEmployeeUseCase {

	public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Employee Name:");
		String name=sc.next();
		sc.nextLine();
		System.out.println("Enter Username(you can enter email also):");
		String Empusername=sc.nextLine();
		
		System.out.println("Enter your Password(remember it for future login):");
		String Emppassword=sc.next();
		
		Employee emp = new Employee();
		emp.setEmpName(name);
		emp.setEmpUserName(Empusername);
		emp.setEmpPassword(Emppassword);
		
		Employeedao dao =new EmployeedaoImpl();
		
		try {
			String msg =dao.RegisterEmployee(emp);
			System.out.println(msg);
			
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("if you Want to login as Employee Enter Yes or No");
        String choice = sc.next();
        if(choice.equalsIgnoreCase("yes"))
        {
        	LoginEmployeeUseCase.main(null);
        }
        else
        {
        	MainApp.main(null);
        }
	}

}
