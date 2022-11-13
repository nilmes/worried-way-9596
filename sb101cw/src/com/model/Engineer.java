package com.model;

public class Engineer {

	private int EnggId; 
	private String EnggName; 
	private String EnggUserName;
	private String EnggPassword ;
	private String EnggCategory ;
	
	
	public Engineer() {
		
	}


	public Engineer(int enggId, String enggName, String enggUserName, String enggPassword, String enggCategory) {
		super();
		EnggId = enggId;
		EnggName = enggName;
		EnggUserName = enggUserName;
		EnggPassword = enggPassword;
		EnggCategory = enggCategory;
	}


	public int getEnggId() {
		return EnggId;
	}


	public void setEnggId(int enggId) {
		EnggId = enggId;
	}


	public String getEnggName() {
		return EnggName;
	}


	public void setEnggName(String enggName) {
		EnggName = enggName;
	}


	public String getEnggUserName() {
		return EnggUserName;
	}


	public void setEnggUserName(String enggUserName) {
		EnggUserName = enggUserName;
	}


	public String getEnggPassword() {
		return EnggPassword;
	}


	public void setEnggPassword(String enggPassword) {
		EnggPassword = enggPassword;
	}


	public String getEnggCategory() {
		return EnggCategory;
	}


	public void setEnggCategory(String enggCategory) {
		EnggCategory = enggCategory;
	}


	@Override
	public String toString() {
		return "Engineer [EnggId=" + EnggId + ", EnggName=" + EnggName + ", EnggUserName=" + EnggUserName
				+ ", EnggPassword=" + EnggPassword + ", EnggCategory=" + EnggCategory + "]";
	}
	
	
	
	
	
	
	
}
