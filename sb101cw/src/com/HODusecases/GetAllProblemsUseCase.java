package com.HODusecases;

import java.util.List;


import com.dao.HODdao;
import com.dao.HODdaoImpl;
import com.exception.ProblemException;
import com.model.Problem;

public class GetAllProblemsUseCase {

	public static void main(String[] args) {
		
		HODdao dao = new HODdaoImpl();
		
		try {
			List<Problem>list=dao.GetAllProbDetails();
			
			list.forEach(el->System.out.println(el));
		} catch (ProblemException e) {
			System.out.println(e.getMessage());
		}

	}

}
