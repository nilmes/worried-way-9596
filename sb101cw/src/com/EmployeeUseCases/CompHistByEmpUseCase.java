package com.EmployeeUseCases;

import java.util.List;

import com.dao.Employeedao;
import com.dao.EmployeedaoImpl;
import com.exception.EmployeeException;
import com.model.Problem;

public class CompHistByEmpUseCase {

	public static void main(int id) {
		// TODO Auto-generated method stub
		
		Employeedao dao = new EmployeedaoImpl();
		
		try {
			List<Problem>list=dao.CheckProbHistory(id);
			list.forEach(el->System.out.println(el));
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}

	}

}
