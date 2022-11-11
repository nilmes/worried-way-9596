package com.EngineerUseCases;

import java.util.Scanner;

import com.dao.Enggdao;
import com.dao.EnggdaoImpl;
import com.exception.EngineerException;

public class UpdatePasswordUseCase {

	public static void main(int id) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the new password:");
		String pass = sc.next();
		
		Enggdao dao = new EnggdaoImpl();
		
		try {
			String msg =dao.UpdatePassword(id, pass);
			System.out.println(msg);
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
