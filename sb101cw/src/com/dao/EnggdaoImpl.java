package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.EngineerException;
import com.exception.ProblemException;
import com.model.Engineer;
import com.model.Problem;
import com.model.ProblemAssignTo;
import com.utility.DButil;

public class EnggdaoImpl implements Enggdao {

	@Override
	public Engineer loginToSystem(String username, String password) throws EngineerException {
		Engineer engg=null;
		
		try (Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from engineers where EnggUserName=? and EnggPassword=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				int id =rs.getInt("EnggId");
				String name = rs.getString("EnggName");
				String usern = rs.getString("EnggUserName");
				String pass = rs.getString("EnggPassword");
				String cat = rs.getString("EnggCategory");
				
				engg = new Engineer(id,name,usern,pass,cat);
			}
			else
			{
				throw new EngineerException("Invalid username or password");
			}
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		return engg;
	}

	@Override
	public List<ProblemAssignTo> ViewAssignedProblem(int id) throws EngineerException {
		List<ProblemAssignTo> prob=new ArrayList<>();
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select p.pid,p.pname,p.pcategory,p.status ,e.EnggName,ep.reid from"+
			" problems p INNER JOIN engineer_problems ep INNER JOIN engineers e ON ep.rpid=p.pid AND"+
					" ep.reid=e.EnggId where ep.reid=?");
			
			ps.setInt(1, id);
			
		   ResultSet rs	=ps.executeQuery();
		   
		   while(rs.next())   
		   {
			   int pid =rs.getInt("pid");
			   String pname = rs.getString("pname");
			   String pcat =rs.getString("pcategory");
			   String status =rs.getString("Status");
			   String enggname = rs.getString("EnggName");
			   int renggid = rs.getInt("reid");
			   
			   ProblemAssignTo probto = new ProblemAssignTo(pid,pname,pcat,renggid,enggname,status);
			   
			   prob.add(probto);
			   
			   
		   }
		   if(prob.size()==0)
		   {
			   throw new EngineerException("No Task is Assigned to You...");
		   }
		   
			
			
			
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		return prob;
	}

	@Override
	public String UpdateProblem(int id, String status,int pid) throws ProblemException {
		
		String msg = "Not connected";
		
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update problems inner join engineer_problems"+
			" ON problems.pid=engineer_problems.rpid"+
			" set problems.status=? where reid=?  and rpid=?");
			
			ps.setString(1, status);
			ps.setInt(2, id);
			ps.setInt(3, pid);
			
			
			int x =ps.executeUpdate();
			
			if(x>0)
			{
				msg = "Problem Status Changed Successfully.....";
			}
			else
			{
				throw new ProblemException("Problems related to your id:"+id+" Not found...");
			}
			
		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
		}
		
		return msg;
	}

	@Override
	public List<Problem> ViewAttendProblem(int id) throws ProblemException {
		List<Problem> prob=new ArrayList<>();
//		what does  attended problems is actually means ...........?solved/progress/Not solved
		try (Connection conn=DButil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("select p.pid,p.pname,p.pcategory,p.status from"+
		                          " problems p INNER JOIN engineer_problems ep ON p.pid=rpid where reid=? and p.status='solved'");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				int pid=rs.getInt("pid");
				String pname = rs.getString("pname");
				String pcat=rs.getString("pcategory");
				String status=rs.getString("status");
				
				Problem problem = new Problem(pid,pname,pcat,status);
				
				prob.add(problem);
				
			}
			if(prob.size()==0)
			{
				throw new ProblemException("Record Not found for your EnggId:"+id);
			}
			
			
			
		} catch (SQLException e) {
			
			throw new ProblemException(e.getMessage());
		}
		
		return prob;
	}

	@Override
	public String UpdatePassword(int id, String password) throws EngineerException {
		String msg = "password not updated check connection";
		
		try (Connection conn=DButil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement("update engineers set password=? where EggId=?");
			ps.setString(1, password);
			ps.setInt(2, id);
			
			int x =ps.executeUpdate();
			if(x>0)
			{
				msg = "Password Updated Successfully your EnggId is: "+id+"your New password :"+password;
			}
			else
			{
				msg = "Record Not found for EnggId:"+id;
			}
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		return msg;
	}

	
	

}
