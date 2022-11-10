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
import com.utility.DButil;

public class HODdaoImpl implements HODdao{

	@Override
	public String AppointAnEngineer(String EnggName, String EnggUserName, String EnggPassword, String EnggCategory)
			throws EngineerException {
		
		String message = "Not connected";
		
		try(Connection conn =DButil.provideConnection()) {
			PreparedStatement ps=conn.prepareStatement(" insert into engineers(EnggName,EnggUserName,EnggPassword,EnggCategory) "
					+ "values(?,?,?,?)");
			
			ps.setString(1,EnggName);
			ps.setString(2, EnggUserName);
			ps.setString(3, EnggPassword);
			ps.setString(4, EnggCategory);
			
           int x=ps.executeUpdate();
			
			if(x>0)
			{
				Engineer engg = new Engineer();
				
				engg.setEnggName(EnggName);
				engg.setEnggUserName(EnggUserName);
				engg.setEnggPassword(EnggPassword);
				engg.setEnggCategory(EnggCategory);
				
				message="New Engineer appointed Successfully......";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Engineer> GetAllEnggDetails() throws EngineerException {
		List<Engineer> list = new ArrayList<>();
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from engineers");	
			
			ResultSet rs =	ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("EnggId");
				String name =rs.getString("EnggName");
				String username =rs.getString("EnggUserName");
				String pass= rs.getString("EnggPassword");
				String category = rs.getString("EnggCategory");
				
				Engineer engg = new Engineer(id,name,username,pass,category);
				
				list.add(engg);
			}
			if(list.size()==0)
			{
				throw new EngineerException("No engineer were found....");
			}
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		return list;
	}

	@Override
	public String DeleteEnggById(int id) throws EngineerException {
		String message = "Not Connected check Network";
		
		try (Connection conn=DButil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("delete from engineers where EnggId = ?");
			
			ps.setInt(1, id);
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				message = "Engineer with ID : "+id+" is deleted..";
			}
			else
			{
				throw new EngineerException("Engineer with ID : "+id+" is Not found..");
			}
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		
		return message;
	}

	@Override
	public List<Problem> GetAllProbDetails() throws ProblemException {
         List<Problem> list = new ArrayList<>();
		
		try(Connection conn=DButil.provideConnection()) {
			
			PreparedStatement ps=conn.prepareStatement("select * from problems");	
			
			ResultSet rs =	ps.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt("pid");
				String name =rs.getString("pname");
				String category = rs.getString("pcategory");
				String status = rs.getString("status");
				
			Problem	prob =new Problem(id,name,category,status);
				
				list.add(prob);
			}
			if(list.size()==0)
			{
				throw new ProblemException("No problems were found....");
			}
			
		} catch (SQLException e) {
			throw new ProblemException(e.getMessage());
		}
		return list;
	}

	@Override
	public String AssignProblem(int engineerId, int problemId) throws EngineerException {
		String msg="Not Assigned";
		
		try (Connection conn=DButil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into engineer_problems values(?,?)");
			
			ps.setInt(1, problemId);
			ps.setInt(2, engineerId);
			
			int x =ps.executeUpdate();
			
			if(x>0) {
				msg = "Problem with problemId: "+problemId+" is Assigned to Engineer with engId->"+engineerId;
			}
			
		} catch (SQLException e) {
			throw new EngineerException(e.getMessage());
		}
		return msg;
	}
	
	
   
}
