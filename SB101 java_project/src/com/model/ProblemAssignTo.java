package com.model;

public class ProblemAssignTo {
    
	
	private int pid;
	private String pname;
	private String pcategory;
	private int enggid;
	private String enggname;
	private String pstatus;
	
	
	public ProblemAssignTo() {
		
	}


	public ProblemAssignTo(int pid, String pname, String pcategory, int enggid, String enggname, String pstatus) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pcategory = pcategory;
		this.enggid = enggid;
		this.enggname = enggname;
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


	public int getEnggid() {
		return enggid;
	}


	public void setEnggid(int enggid) {
		this.enggid = enggid;
	}


	public String getEnggname() {
		return enggname;
	}


	public void setEnggname(String enggname) {
		this.enggname = enggname;
	}


	public String getPstatus() {
		return pstatus;
	}


	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}


	@Override
	public String toString() {
		return "ProblemAssignTo [pid=" + pid + ", pname=" + pname + ", pcategory=" + pcategory + ", enggid=" + enggid
				+ ", enggname=" + enggname + ", pstatus=" + pstatus + "]";
	}
	
	
	
	
}
