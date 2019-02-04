package com.bean;

public class Report2 {
	
	String empId;
	String statusMessage;
	
	public Report2() {
		super();
	}

	public Report2(String empId, String statusMessage) {
		super();
		this.empId = empId;
		this.statusMessage = statusMessage;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	
	

}
