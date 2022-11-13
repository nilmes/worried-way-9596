package com.model;

public class Problem {
   
	private int pid;
	private String pname;
	private String pcategory;
	private String pstatus;
	
	
	public Problem() {
	
	}


	public Problem(int pid, String pname, String pcategory, String pstatus) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcategory = pcategory;
		this.pstatus = pstatus;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPcategory() {
		return pcategory;
	}


	public void setPcategory(String pcategory) {
		this.pcategory = pcategory;
	}


	public String getPstatus() {
		return pstatus;
	}


	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}


	@Override
	public String toString() {
		return "Problem [pid=" + pid + ", pname=" + pname + ", pcategory=" + pcategory + ", pstatus=" + pstatus + "]";
	}
	
	
	
	
}
