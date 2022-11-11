package com.dao;

import java.util.List;

import com.exception.EngineerException;
import com.exception.ProblemException;
import com.model.Engineer;
import com.model.Problem;
import com.model.ProblemAssignTo;

public interface Enggdao  {
	public Engineer loginToSystem(String username,String password) throws EngineerException;
	
	public List<ProblemAssignTo> ViewAssignedProblem(int id) throws EngineerException;
	
	public String UpdateProblem(int id,String status,int pid) throws ProblemException;
	
	public List<Problem> ViewAttendProblem(int id) throws ProblemException;
	
	public String UpdatePassword(int id, String password) throws EngineerException;
}
