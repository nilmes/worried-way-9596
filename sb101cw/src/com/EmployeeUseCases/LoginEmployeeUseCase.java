package com.EmployeeUseCases;

import java.util.Scanner;

import com.dao.Employeedao;
import com.dao.EmployeedaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;

public class LoginEmployeeUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Employee UserName:");
		String username = sc.nextLine();
		
		System.out.println("Enter Employee Password:");
		String pass = sc.next();
		
		Employeedao dao = new EmployeedaoImpl();
		
		try {
			Employee emp =dao.EmployeeLogin(username, pass);
			System.out.println(emp.getEmpName()+"Your Login is Successfull......");
			System.out.println("welcome.. "+emp.getEmpName());
			Employee_Options.Select(emp.getEmpID());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
