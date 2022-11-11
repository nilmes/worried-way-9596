package com.EngineerUseCases;

import java.util.Scanner;

import com.dao.Enggdao;
import com.dao.EnggdaoImpl;
import com.exception.EngineerException;
import com.model.Engineer;

public class EngineerloginUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer UserName:");
		String username=sc.next();
		System.out.println("Enter Engineer Password:");
		String password=sc.next();
		
		Enggdao dao = new EnggdaoImpl();
		
		try {
			Engineer engg=dao.loginToSystem(username, password);
			System.out.println("welcome Engineer.."+engg.getEnggName()+"  category-->"+engg.getEnggCategory());
			
			Engineer_options.select(engg.getEnggId());
			
			
		} catch (EngineerException e) {
			
			System.out.println(e.getMessage());
		}
		

	}

}
