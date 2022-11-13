package com.model;

public class EngineerDto {
     
	private int enggid;
	private String enggName;
	private String category;
	private String pname;
	public EngineerDto() {
		
	}
	public EngineerDto(int enggid, String enggName, String category, String pname) {
		super();
		this.enggid = enggid;
		this.enggName = enggName;
		this.category = category;
		this.pname = pname;
	}
	public int getEnggid() {
		return enggid;
	}
	public void setEnggid(int enggid) {
		this.enggid = enggid;
	}
	public String getEnggName() {
		return enggName;
	}
	public void setEnggName(String enggName) {
		this.enggName = enggName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "EngineerDto [enggid=" + enggid + ", enggName=" + enggName + ", category=" + category + ", pname="
				+ pname + "]";
	}
	
	
	
	
}
