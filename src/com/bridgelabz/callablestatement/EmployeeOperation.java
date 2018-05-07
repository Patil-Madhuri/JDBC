package com.bridgelabz.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.jdbcPreparedStatment.DatabaseConnection;
import com.bridgelabz.jdbcStatement.Employee;

public class EmployeeOperation 
{
	Scanner scanner = new Scanner(System.in);
	Connection connection = null;
	CallableStatement callableStatement=null;
	Employee employee = new Employee();
	String empName,empAddress;
	double empSalary;
	long empContactNo;
	boolean status=true;
	int choice;
	public boolean insertEmployee()
	{
		connection = DatabaseConnection.getconnection();
		try {
			System.out.println("Enter the employee name: ");
			empName = scanner.next();
			System.out.println("Enter the employee salary: ");
			empSalary = scanner.nextDouble();
			System.out.println("Enter the employee address: ");
			empAddress = scanner.next();
			System.out.println("Enter the employee contact number: ");
			empContactNo = scanner.nextLong();
			callableStatement = connection.prepareCall("{call insertEmp(?,?,?,?)}");
			callableStatement.setString(1, empName);
			callableStatement.setDouble(2,empSalary);
			callableStatement.setString(3, empAddress);
			callableStatement.setLong(4,empContactNo);
			int x = callableStatement.executeUpdate();
			if(x > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteEmployee(int empId)
	{
		connection = DatabaseConnection.getconnection();
		try {
			callableStatement = connection.prepareCall("{call deleteEmp(?)}");
			callableStatement.setInt(1, empId);
			int x = callableStatement.executeUpdate();
			if(x > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public List<Employee> displayAllEmployee()
	{
		List<Employee> empList = new LinkedList<>();
		connection = DatabaseConnection.getconnection();
		try {
			callableStatement = connection.prepareCall("{call selectEmployee()}");
			boolean result = callableStatement.execute();
			while(result)
			{
				ResultSet resultSet = callableStatement.getResultSet();
				while(resultSet.next())
				{
					Employee employee = new Employee();
					employee.setEmpId(resultSet.getInt("Emp_id"));
					employee.setEmpName(resultSet.getString("Emp_Name"));
					employee.setEmpSalary(resultSet.getDouble("Emp_Salary"));
					employee.setEmpAddress(resultSet.getString("Emp_Address"));
					employee.setEmpContactNo(resultSet.getLong("Emp_ContactNo"));
				
					empList.add(employee);
				}
				result = callableStatement.getMoreResults();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}
	public boolean updateEmployee(Employee employee)
	{
		connection = DatabaseConnection.getconnection();
		try {
			System.out.println("Enter the employee new name: ");
			empName = scanner.next();
			System.out.println("Enter the employee new salary: ");
			empSalary = scanner.nextDouble();
			System.out.println("Enter the employee new address: ");
			empAddress = scanner.next();
			System.out.println("Enter the employee new contact number: ");
			empContactNo = scanner.nextLong();
			callableStatement  =connection.prepareCall("call updateEmp(?,?,?,?,?)");
			callableStatement.setInt(1, employee.getEmpId());
			callableStatement.setString(2,empName );
			callableStatement.setDouble(3, empSalary);
			callableStatement.setLong(5, empContactNo);
			callableStatement.setString(4, empAddress);
			int x = callableStatement.executeUpdate();
			if(x > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Employee searchEmployee(int id)
	{
		connection = DatabaseConnection.getconnection();
		try {
			callableStatement = connection.prepareCall("call searchEmp(?)");
			callableStatement.setInt(1, id);
			ResultSet resultSet = callableStatement.executeQuery();
			while(resultSet.next())
			{
				employee.setEmpId(resultSet.getInt("Emp_id"));
				employee.setEmpName(resultSet.getString("Emp_Name"));
				employee.setEmpSalary(resultSet.getDouble("Emp_Salary"));
				employee.setEmpAddress(resultSet.getString("Emp_Address"));
				employee.setEmpContactNo(resultSet.getLong("Emp_ContactNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}
}
