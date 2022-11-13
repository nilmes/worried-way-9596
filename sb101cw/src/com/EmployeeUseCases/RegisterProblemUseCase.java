package com.EmployeeUseCases;

import java.util.Scanner;

import com.dao.Employeedao;
import com.dao.EmployeedaoImpl;
import com.exception.EmployeeException;
import com.model.Problem;

public class RegisterProblemUseCase {

	public static void main(int id) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter problem Name:");
		String pname =sc.nextLine();
		
		
		System.out.println("Enter problem category:");
		String pcat = sc.nextLine();
		
		System.out.println("Enter problem Status:");
		String pstatus = sc.nextLine();
		
		Problem prob = new Problem();
		
		prob.setPname(pname);
		prob.setPcategory(pcat);
		prob.setPstatus(pstatus);
		
		Employeedao dao =new EmployeedaoImpl();
		
		try {
			String msg=dao.RegisterProblem(prob,id);
			System.out.println(msg);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
