package com.bean;

public class User {
	
	String employeeId;
	String employeeName ;
	String userName ;
	String userPwd;
	String isAdmin;
	
	public User(){
		
	}
	
	public User(String employeeId, String userName, String userPwd, String isAdmin) {
		super();
		this.employeeId = employeeId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.isAdmin = isAdmin;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getAdmin() {
		return isAdmin;
	}
	public void setAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	

}
