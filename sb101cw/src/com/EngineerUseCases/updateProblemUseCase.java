package com.EngineerUseCases;

import java.util.Scanner;

import com.dao.Enggdao;
import com.dao.EnggdaoImpl;
import com.exception.ProblemException;

public class updateProblemUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("please provide  your Enggid ");
		int enggid =sc.nextInt();
		System.out.println("Enter problem id to change its status");
		int pid = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the Update on ProblemID: "+pid+"(solved/Not Solved/Pending)");
		String update = sc.nextLine();
		
		Enggdao dao = new EnggdaoImpl();
		
		try {
		  String msg=dao.UpdateProblem(enggid, update,pid);
		  System.out.println(msg);
		} catch (ProblemException e) {
			System.out.println(e.getMessage());
		}

	}

}
