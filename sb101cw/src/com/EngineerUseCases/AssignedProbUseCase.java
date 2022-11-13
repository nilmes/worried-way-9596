package com.EngineerUseCases;

import java.util.List;

import com.dao.Enggdao;
import com.dao.EnggdaoImpl;
import com.exception.EngineerException;
import com.model.ProblemAssignTo;

public class AssignedProbUseCase {

	public static void main(int id) {
		Enggdao dao = new EnggdaoImpl();
		
		try {
			List<ProblemAssignTo> list=dao.ViewAssignedProblem(id);
			
			list.forEach(el->System.out.println(el));
			
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
