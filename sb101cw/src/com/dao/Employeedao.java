package com.dao;

import java.util.List;

import com.exception.EmployeeException;
import com.model.Employee;
import com.model.Problem;

public interface Employeedao {
   public String RegisterEmployee(Employee emp) throws EmployeeException;
	
	public Employee EmployeeLogin(String username, String password) throws EmployeeException;
	
	public String RegisterProblem(Problem problem,int id) throws EmployeeException;
	
	public String CheckEnggAsignToProb(int id)throws EmployeeException;
	
	public List<Problem> CheckProbHistory(int id) throws EmployeeException;
	
	public String UpdatePassword(int empid,String password) throws EmployeeException;
}
