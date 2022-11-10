package com.HODusecases;

import java.util.Scanner;


import com.dao.HODdao;
import com.dao.HODdaoImpl;
import com.exception.EngineerException;

public class DeleteEngineerUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter engineer id:");
		int id = sc.nextInt();
		
		HODdao dao = new HODdaoImpl();
		
		try {
			String msg =dao.DeleteEnggById(id);
			System.out.println(msg);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		

	}

}
