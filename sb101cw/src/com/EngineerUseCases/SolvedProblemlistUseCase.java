package com.EngineerUseCases;

import java.util.List;

import com.dao.Enggdao;
import com.dao.EnggdaoImpl;
import com.exception.ProblemException;
import com.model.Problem;

public class SolvedProblemlistUseCase {

	public static void main(int id) {
		
		Enggdao dao = new EnggdaoImpl();
		try {
			List<Problem>list=dao.ViewAttendProblem(id);
			list.forEach(el->System.out.println(el));
		} catch (ProblemException e) {
			System.out.println(e.getMessage());
		}

	}

}
