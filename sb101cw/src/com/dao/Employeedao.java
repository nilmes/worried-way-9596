package com.dao;

import java.util.List;

import com.exception.EmployeeException;
import com.model.Employee;
import com.model.Problem;

public interface Employeedao {
   public String RegisterEmployee(Employee emp) throws EmployeeException;
	
	public Employee EmployeeLogin(String username, String password) throws EmployeeException;
	
	public String RegisterProblem(Problem problem) throws EmployeeException;
	
	public String ViewStatus(int id)throws EmployeeException;
	
	public List<Problem> CheckHistory(int id) throws EmployeeException;
	
	public String UpdatePassword(String Username ,String password) throws EmployeeException;
}
