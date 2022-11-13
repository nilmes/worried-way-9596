package com.HODusecases;

import java.util.Scanner;


import com.dao.HODdao;
import com.dao.HODdaoImpl;
import com.exception.EngineerException;

public class AssignProblemUseCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("please enter EngineerId:");
		int enggid = sc.nextInt();
		
		System.out.println("please enter problemId:");
		
		int probid = sc.nextInt();
		
		HODdao dao = new HODdaoImpl();
		
		try {
		String msg	=dao.AssignProblem(enggid, probid);
		System.out.println(msg);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
