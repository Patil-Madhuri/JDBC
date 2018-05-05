package com.bridgelabz.jdbcStatement;

public class Employee 
{	
	private String empName,empAddress;
	private int empId;
	private double empSalary;
	private long empContactNo;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public long getEmpContactNo() {
		return empContactNo;
	}
	public void setEmpContactNo(long empContactNo) {
		this.empContactNo = empContactNo;
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empAddress=" + empAddress + ", empId=" + empId + ", empSalary="
				+ empSalary + ", empContactNo=" + empContactNo + "]";
	}
	
	
}
