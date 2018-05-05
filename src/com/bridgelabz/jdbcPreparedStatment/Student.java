package com.bridgelabz.jdbcPreparedStatment;

public class Student
{
	private String studName;
	private String studAddress,studDept;
	private long studContactNo;
	private int studId;
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}
	public String getStudDept() {
		return studDept;
	}
	public void setStudDept(String studDept) {
		this.studDept = studDept;
	}
	public long getStudContactNo() {
		return studContactNo;
	}
	public void setStudContactNo(long studContactNo) {
		this.studContactNo = studContactNo;
	}
	@Override
	public String toString() {
		return "Student [studName=" + studName + ", studAddress=" + studAddress + ", studDept=" + studDept
				+ ", studContactNo=" + studContactNo + "]";
	}
	
	
	
	
}
