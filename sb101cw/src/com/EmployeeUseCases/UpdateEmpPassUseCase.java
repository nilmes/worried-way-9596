package com.EmployeeUseCases;

import java.util.Scanner;

import com.dao.Employeedao;
import com.dao.EmployeedaoImpl;
import com.exception.EmployeeException;

public class UpdateEmpPassUseCase {

	public static void main(int empid) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("please enter your New Pasword which you want to set");
		String pass = sc.nextLine();
		
		Employeedao dao = new EmployeedaoImpl();
		
		try {
		String msg 	=dao.UpdatePassword(empid, pass);
		System.out.println(msg);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
