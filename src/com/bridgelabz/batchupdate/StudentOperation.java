package com.bridgelabz.batchupdate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.jdbcPreparedStatment.DatabaseConnection;
import com.bridgelabz.jdbcPreparedStatment.Student;

public class StudentOperation 
{
	Scanner scanner = new Scanner(System.in);
	Student student = new Student();
	Connection connection = null;
	PreparedStatement preparedStatement=null;
	public boolean insertStudent()
	{
		connection = DatabaseConnection.getconnection();
		try {
			System.out.println("Enter the number of student to insert details: ");
			int noOfStudents = scanner.nextInt();
			for(int i=1;i <=noOfStudents;i++)
			{
			preparedStatement = connection.prepareStatement("insert into student(Student_Name,Student_ContactNo,Student_Dept,Student_Address)values(?,?,?,?)");
			//connection.setAutoCommit(false);
			System.out.println("Enter Student Name: ");
			student.setStudName(scanner.next());
			System.out.println("Enter Student Address: ");
			student.setStudAddress(scanner.next());
			System.out.println("Enter Student department: ");
			student.setStudDept(scanner.next());
			System.out.println("Enter Student Contact Number: ");
			student.setStudContactNo(scanner.nextLong());
				preparedStatement.setString(1, student.getStudName());
				preparedStatement.setLong(2, student.getStudContactNo());
				preparedStatement.setString(3, student.getStudDept());
				preparedStatement.setString(4,student.getStudAddress());
				preparedStatement.addBatch();
				int count[] = preparedStatement.executeBatch();
				System.out.println("Query affected "+count.length);
				//connection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteStudent()
	{
		connection  =DatabaseConnection.getconnection();
		try {
			System.out.println("Enter the number of student to delete: ");
			int noOfStudents = scanner.nextInt();
			for(int i=1;i <=noOfStudents;i++)
			{
				System.out.println("Enter the Student id you want to delete details: ");
				int studId = scanner.nextInt();
				connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement("delete from student where Student_Id=?");
			preparedStatement.setInt(1, studId);
			preparedStatement.addBatch();
			int count[] = preparedStatement.executeBatch();
			System.out.println("Query affected "+count.length);
			connection.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public boolean updateStudent(Student student) 
	{
		connection=DatabaseConnection.getconnection();
		System.out.println("Enter the number of student to update details: ");
		int noOfStudents = scanner.nextInt();
		for(int i=1;i <=noOfStudents;i++)
		{
			try {
				System.out.println("Enter the student id to update details: ");
				student.setStudId(scanner.nextInt());
				System.out.println("Enter Student new Name: ");
				student.setStudName(scanner.next());
				System.out.println("Enter Student new Address: ");
				student.setStudAddress(scanner.next());
				System.out.println("Enter Student new department: ");
				student.setStudDept(scanner.next());
				System.out.println("Enter Student new Contact Number: ");
				student.setStudContactNo(scanner.nextLong());
				connection.setAutoCommit(false);
				preparedStatement = connection.prepareStatement("update student set Student_Name=?,Student_ContactNo=?,Student_Dept=?,Student_Address=? where Student_Id=?");
				preparedStatement.setString(1, student.getStudName());
				preparedStatement.setLong(2, student.getStudContactNo());
				preparedStatement.setString(3, student.getStudDept());
				preparedStatement.setString(4,student.getStudAddress());
				preparedStatement.setInt(5, student.getStudId());
				preparedStatement.addBatch();
				int count[] = preparedStatement.executeBatch();
				System.out.println("Query affected "+count.length);
				connection.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public void searchStudent(Student student)
	{
		connection  = DatabaseConnection.getconnection();
		try {
			System.out.println("Enter the number of student to update details: ");
			int noOfStudents = scanner.nextInt();
			for(int i=0;i<noOfStudents;i++)
			{
				System.out.println("Enter the Student id you want to search details: ");
				student.setStudId(scanner.nextInt());
				connection.setAutoCommit(false);
				preparedStatement = connection.prepareStatement("select * from student where Student_Id=?");
				preparedStatement.setInt(1, student.getStudId());
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next())
				{
					student.setStudId(resultSet.getInt(1));
					student.setStudName(resultSet.getString(2));
					student.setStudContactNo(resultSet.getLong(3));
					student.setStudDept(resultSet.getString(4));
					student.setStudAddress(resultSet.getString(5));
					System.out.println(student);
				}
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Student> displayAllStudent()
	{
		List<Student> students = new LinkedList<>();
		connection = DatabaseConnection.getconnection();
		try {
			preparedStatement = connection.prepareStatement("select * from student");
			ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next())
				{
					student.setStudId(resultSet.getInt(1));
					student.setStudName(resultSet.getString(2));
					student.setStudContactNo(resultSet.getLong(3));
					student.setStudDept(resultSet.getString(4));
					student.setStudAddress(resultSet.getString(5));
					students.add(student);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

}
//Student_Id | Student_Name   | Student_ContactNo | Student_Dept | Student_Address 
