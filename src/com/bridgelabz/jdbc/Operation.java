package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Operation 
{
	int choice;
	String studName,studaddress,studDept;
	long studContactNo;
	boolean status=true,flag;
	Scanner scanner = new Scanner(System.in);
	Connection connection= null;
	PreparedStatement preparedStatement =null;
	Student student = new Student();
	public  boolean insertStudent(Student student)
	{
		connection = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("insert into student(Student_Name,Student_ContactNo,Student_Dept,Student_Address)values(?,?,?,?)");
			preparedStatement.setString(1, student.getStudName());
			preparedStatement.setLong(2, student.getStudContactNo());
			preparedStatement.setString(3, student.getStudDept());
			preparedStatement.setString(4,student.getStudAddress());
			  
			int x = preparedStatement.executeUpdate();
			if(x >0)
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
	
	public void updateStudentOperation(Student student)
	{
		do
		{
		System.out.println("1.Update Name \n2.Update Address \n3.Update Contact Number \n4.Update Department \n5.Stop Editing");
		System.out.println("Enter you choice to update: ");
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter the new name: ");
			studName = scanner.next();
			student.setStudName(studName);
			flag = updateStudentName(student);
			if(flag)
			{
				System.out.println("------Updated Sucessfully-----");
			}
			else
			{
				System.out.println("-----Failed to Update-----");
			}
			break;
		case 2:
			System.out.println("Enter the new address: ");
			studaddress = scanner.next();
			student.setStudAddress(studaddress);
			flag =updateStudentAddress(student);
			if(flag)
			{
				System.out.println("------Updated Sucessfully-----");
			}
			else
			{
				System.out.println("-----Failed to Update-----");
			}
			break;
		case 3:
			System.out.println("Enter the new contact number: ");
			studContactNo = scanner.nextLong();
			student.setStudContactNo(studContactNo);
			flag =updateStudentContact(student);
			if(flag)
			{
				System.out.println("------Updated Sucessfully-----");
			}
			else
			{
				System.out.println("-----Failed to Update-----");
			}
			break;
		case 4:
			System.out.println("Enter the new department: ");
			studDept = scanner.next();
			student.setStudDept(studDept);
			flag = updateStudentDept(student);
			if(flag)
			{
				System.out.println("------Updated Sucessfully-----");
			}
			else
			{
				System.out.println("-----Failed to Update-----");
			}
			break;
		case 5:
			status=false;
			break;           
		default:
				System.out.println("Invalid choice");
		}
		}while(status);
		
	}
	
	public  boolean updateStudentName(Student student)
	{
		connection  = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("update student set Student_Name=? where Student_Id=?");
			preparedStatement.setString(1, student.getStudName());
			preparedStatement.setInt(2, student.getStudId());
			int x = preparedStatement.executeUpdate();
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
	
	public  boolean updateStudentAddress(Student student)
	{
		connection  = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("update student set Student_Address=? where Student_Id=?");
			preparedStatement.setString(1, student.getStudAddress());
			preparedStatement.setInt(2, student.getStudId());
			int x = preparedStatement.executeUpdate();
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
	
	public  boolean updateStudentContact(Student student)
	{
		connection  = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("update student set Student_ContactNo=? where Student_Id=?");
			preparedStatement.setLong(1, student.getStudContactNo());
			preparedStatement.setInt(2, student.getStudId());
			int x = preparedStatement.executeUpdate();
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
	
	public  boolean updateStudentDept(Student student)
	{
		connection  = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("update student set Student_Dept=? where Student_Id=?");
			preparedStatement.setString(1, student.getStudDept());
			preparedStatement.setInt(2, student.getStudId());
			int x = preparedStatement.executeUpdate();
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
	public  boolean deleteStudent(int id)
	{
		connection = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("delete from student where Student_Id=?");
			preparedStatement.setInt(1,id);
			int x = preparedStatement.executeUpdate();
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
	
	public  List<Student> displayAllStudent()
	{
		List<Student> studentList = new LinkedList<>();
		connection = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("select * from student");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Student student = new Student();
				student.setStudId(resultSet.getInt("Student_Id"));
				student.setStudName(resultSet.getString("Student_Name"));
				student.setStudDept(resultSet.getString("Student_Dept"));
				student.setStudAddress(resultSet.getString("Student_Address"));
				student.setStudContactNo(resultSet.getLong("Student_ContactNo"));
				studentList.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}
	
	public Student searchStudentById(int id)
	{
		connection = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("select * from student where Student_Id=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				student.setStudId(resultSet.getInt("Student_Id"));
				student.setStudName(resultSet.getString("Student_Name"));
				student.setStudDept(resultSet.getString("Student_Dept"));
				student.setStudAddress(resultSet.getString("Student_Address"));
				student.setStudContactNo(resultSet.getLong("Student_ContactNo"));
			}
			System.out.println(student);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public Student searchStudentByName(String studName)
	{
		connection = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("select * from student where Student_Name=?");
			preparedStatement.setString(1, studName);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				student.setStudId(resultSet.getInt("Student_Id"));
				student.setStudName(resultSet.getString("Student_Name"));
				student.setStudDept(resultSet.getString("Student_Dept"));
				student.setStudAddress(resultSet.getString("Student_Address"));
				student.setStudContactNo(resultSet.getLong("Student_ContactNo"));
			}
			System.out.println(student);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public void searchStudentOperation(Student student)
	{
		do 
		{
			System.out.println("1.Search Student By Name \n2.Search Student By Id \n3.Stop Searching");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the student name to search details: ");
				String studName = scanner.next();
				student =searchStudentByName(studName);
				//System.out.println(student);
				break;
			case 2:
				System.out.println("Enter the student id to search details: ");
				int studId = scanner.nextInt();
				student =searchStudentById(studId);
				break;
			case 3:
				status = false;
				break;
				default:
					System.out.println("Invalid choice");
			}
		}while(status);
	}
}
