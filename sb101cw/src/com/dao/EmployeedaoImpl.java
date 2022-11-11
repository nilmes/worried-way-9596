package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.exception.EmployeeException;
import com.model.Employee;
import com.model.Problem;
import com.utility.DButil;

public class EmployeedaoImpl implements Employeedao{

	@Override
	public String RegisterEmployee(Employee emp) throws EmployeeException {
		String msg="Not Registered";
		
		try (Connection conn=DButil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("insert into employee(empName,empUsername,empPassword)"
					+ " values(?,?,?)");	
			ps.setString(1, emp.getEmpName());
			ps.setString(2, emp.getEmpUserName());
			ps.setString(3, emp.getEmpPassword());
			
			int x =ps.executeUpdate();
			if(x>0)
			{
				msg="Employee got added to our system";
			}
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public Employee EmployeeLogin(String username, String password) throws EmployeeException {
		Employee emp=null;
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from employee where empUsername=? and empPassword=?");
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("empid");
				String n = rs.getString("empName");
				String un =rs.getString("empUsername");
				String p =rs.getString("empPassword");
				
				emp = new Employee(id,n,un,p);
			}
			if(emp==null)
			{
				throw new EmployeeException("Username Not registered with into our system");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return emp;
	}

	@Override
	public String RegisterProblem(Problem problem) throws EmployeeException {
		String msg = null;
		
		try (Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("insert into problems(pname,pcategory,status)"+
			                                         " values(?,?,?)");
			ps.setString(1, problem.getPname());
			ps.setString(2, problem.getPcategory());
			ps.setString(3, problem.getPstatus());
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				msg="Problem Registered Successfull......";
			}
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return msg;
	}

	@Override
	public String ViewStatus(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Problem> CheckHistory(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String UpdatePassword(String Username, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

}
