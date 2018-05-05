package com.bridgelabz.jdbcStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.jdbcPreparedStatment.DatabaseConnection;
public class EmpOperations
{
	 String empName,empAddress,updateQuery,selectQuery;
	 int empId,choice=0;
	 double empSalary;
	 long empContactNo;
	 boolean status = true;
	Connection connection = null;
	Statement statement = null;
	Employee employee = new Employee();
	Scanner scanner = new Scanner(System.in);
	public boolean insertEmployee()
	{
		connection = DatabaseConnection.getconnection();
		try {
			statement = connection.createStatement();
			System.out.println("Enter the Employee Name: ");
			empName = scanner.next();
			System.out.println("Enter the Employee Address: ");
			empAddress =scanner.next();
			System.out.println("Enter the Employee Salary: ");
			empSalary = scanner.nextDouble();
			System.out.println("Enter the Employee Contact Number: ");
			empContactNo = scanner.nextLong();
			String insertQuery = "insert into employee(Emp_Name,Emp_Salary,Emp_Address,Emp_ContactNo) values ('"+empName+"',"+empSalary+",'"+empAddress+"',"+empContactNo+")";
			int x = statement.executeUpdate(insertQuery);
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
	
	public void updateEmpOperation(Employee employee)
	{
		System.out.println("Enter the Employee id to update details: ");
		empId = scanner.nextInt();
		employee.setEmpId(empId);
		do
		{
			System.out.println("1.Update Employee Name \n2.Update Employee Address \n3.Update Employee Salary \n4.Update Employee Contact Number \n5.Stop Editing");
			System.out.println("Enter your choice to update: ");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the new name: ");
				empName = scanner.next();
				employee.setEmpName(empName);
				updateEmpName(employee);
				break;
			case 2:
				System.out.println("Enter the new address: ");
				empAddress = scanner.next();
				employee.setEmpAddress(empAddress);
				updateEmpAddress(employee);
				break;
			case 3:
				System.out.println("Enter the new salary: ");
				empSalary = scanner.nextDouble();
				employee.setEmpSalary(empSalary);
				updateEmpSalary(employee);
				break;
			case 4:
				System.out.println("Enter the new contact number: ");
				empContactNo = scanner.nextLong();
				employee.setEmpContactNo(empContactNo);
				updateEmpContactNo(employee);
				break;
			case 5:
				status = false;
				break;
			default:
					System.out.println("Invalid choice");
			}
		}while(status);
	}
	
	public boolean updateEmpName(Employee employee)
	{
		connection = DatabaseConnection.getconnection();
		try {
			statement = connection.createStatement();
			updateQuery = "update employee set Emp_Name='"+empName+"' where Emp_id="+empId+" ";
			int x = statement.executeUpdate(updateQuery);
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
	
	public boolean updateEmpAddress(Employee employee)
	{
		connection = DatabaseConnection.getconnection();
		try {
			statement = connection.createStatement();
			updateQuery = "update employee set Emp_Address='"+empAddress+"' where Emp_id="+empId+" ";
			int x = statement.executeUpdate(updateQuery);
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
	
	public boolean updateEmpSalary(Employee employee)
	{
		connection = DatabaseConnection.getconnection();
		try {
			statement = connection.createStatement();
			 updateQuery = "update employee set Emp_Salary='"+empSalary+"' where Emp_id="+empId+" ";
			int x = statement.executeUpdate(updateQuery);
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
	
	public boolean updateEmpContactNo(Employee employee)
	{
		connection = DatabaseConnection.getconnection();
		try {
			statement = connection.createStatement();
			 updateQuery = "update employee set Emp_ContactNo='"+empContactNo+"' where Emp_id="+empId+" ";
			int x = statement.executeUpdate(updateQuery);
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
	
	public boolean deleteEmployee(int empid)
	{
		return false;
	}
	
	public void searchEmpOperation(Employee employee)
	{
		
	}
	
	public Employee searchEmployeeById(int id)
	{
		return null;
	}
	public Employee searchEmployeeByName(String empName)
	{
		return null;
	}
	public Employee searchEmployeeBySalary(double salary)
	{
		return null;
	}
	
	public  List<Employee> displayAllEmployee()
	{
		List<Employee> empList = new LinkedList<>();
		connection = DatabaseConnection.getconnection();
		try {
			statement = connection.createStatement();
			selectQuery = "select * from employee";
			ResultSet resultSet = statement.executeQuery(selectQuery);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}
}
