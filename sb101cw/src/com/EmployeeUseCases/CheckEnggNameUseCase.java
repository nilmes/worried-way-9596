package com.EmployeeUseCases;

import java.util.Scanner;

import com.dao.Employeedao;
import com.dao.EmployeedaoImpl;
import com.exception.EmployeeException;

public class CheckEnggNameUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please provide your problem id:");
		int probid = sc.nextInt();
		
		Employeedao dao = new EmployeedaoImpl();
		
		try {
			String msg=dao.CheckEnggAsignToProb(probid);
			System.out.println(msg);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

}
