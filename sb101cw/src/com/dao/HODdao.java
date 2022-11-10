package com.dao;

import java.util.List;

import com.exception.EngineerException;
import com.exception.ProblemException;
import com.model.Engineer;
import com.model.Problem;

public interface HODdao {
	public String AppointAnEngineer(String EnggName,String EnggUserName,String EnggPassword,String EnggCategory) throws EngineerException ;
	
	public List<Engineer> GetAllEnggDetails()throws EngineerException;
	
	public String DeleteEnggById(int id)throws EngineerException ;
	
	public List<Problem>GetAllProbDetails() throws ProblemException  ;
	
	public String AssignProblem(int engineerId,int problemId) throws EngineerException ;
}
