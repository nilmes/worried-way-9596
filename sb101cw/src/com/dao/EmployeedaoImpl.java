package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public String RegisterProblem(Problem problem,int id) throws EmployeeException {
		String msg = null;
		
		try (Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("insert into problems(pname,pcategory,status)"+
			                                         " values(?,?,?)");
			ps.setString(1, problem.getPname());
			ps.setString(2, problem.getPcategory());
			ps.setString(3, problem.getPstatus());
			int x = ps.executeUpdate();
			
			
			PreparedStatement ps2=conn.prepareStatement("select pid from problems where pname=? and pcategory=? and status=?");
			String pnam = problem.getPname();
			String pcat = problem.getPcategory();
			String psat = problem.getPstatus();
			
			ps2.setString(1, pnam);
			ps2.setString(2, pcat);
			ps2.setString(3, psat);
			
			
			
		  ResultSet rs2=ps2.executeQuery();
		  
		  int main =0;
		  if(rs2.next())
		  {
			int ans =rs2.getInt("pid");
			  PreparedStatement ps3=conn.prepareStatement("insert into employee_problem values(?,?)");
				
			    ps3.setInt(1, id);
				ps3.setInt(2, ans);
				
			 main =	ps3.executeUpdate();
		  }
		
			
			if(main>0)
			{
				msg="Problem Registered Successfull......";
			}
			else
			{
				msg="Problem not registered....";
			}
			
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return msg;
	}

	@Override
	public String CheckEnggAsignToProb(int probid) throws EmployeeException {
        
		String msg =null;
		
		try (Connection conn=DButil.provideConnection()) {
			
			 PreparedStatement  ps=conn.prepareStatement("select e.EnggName from engineers e INNER JOIN "+
			             "engineer_problems ep ON e.EnggId=ep.reid where ep.rpid=?");
			 
			 ps.setInt(1, probid);
			 
			 ResultSet rs=ps.executeQuery();
			 
			 while(rs.next())
			 {
				 msg = rs.getString("EnggName");
			 }
			 if(msg!=null)
			 {
				 msg="Engineer Name :"+msg+" is assigned to your problem with probId; "+probid;
			 }
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}

		return msg;
	}

	@Override
	public List<Problem> CheckProbHistory(int id) throws EmployeeException {
		List<Problem> list = new ArrayList<>();
		
		
		try (Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from problems where pid IN (select Probpid from"+
			                                    " employee_problem where empProbId=?)");
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
			    int pid=rs.getInt("pid");
				String pnam =rs.getString("pname");
				String pcat =rs.getString("pcategory");
				String psat =rs.getString("status");
				
				Problem prob = new Problem(pid,pnam,pcat,psat);
				
				list.add(prob);	
				
			}
			if(list.size()==0)
			{
				throw new EmployeeException("problems not found for your empId: "+id+" in our list....");
			}
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return list;
	}

	@Override
	public String UpdatePassword(int empid, String password) throws EmployeeException {
		String msg = null;
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update  employee set empPassword=? where empid=?");
			
			ps.setString(1, password);
			ps.setInt(2, empid);
            
			int x =ps.executeUpdate();
			
			if(x>0)
			{
				msg = "your password is Updated successfully...";
			}
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		return msg;
	}

}
