package com.bean;

public class Report3 {
	
	String EmpId;
	String totalRedemption;
	String month;
	
	public Report3() {
		super();
	}

	public Report3(String empId, String totalRedemption, String month) {
		super();
		EmpId = empId;
		this.totalRedemption = totalRedemption;
		this.month = month;
	}

	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getTotalRedemption() {
		return totalRedemption;
	}

	public void setTotalRedemption(String totalRedemption) {
		this.totalRedemption = totalRedemption;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	

}
