package com.bridgelabz.jdbc;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class JdbcTest 
{
	public static void main(String[] args)
	{
		String studName,studAddress,studDept;
		long studContactNo;
		int choice=0,studId;
		boolean flag;
		Student student = new Student();
		Operation operation = new Operation();
		Scanner scanner = new Scanner(System.in);
		do
		{
		System.out.println("1.Insert Student \n2.Update Student \n3.Delete Student\n4.Search Student"
				+ " \n5.Display Student \n6.Exit");
		System.out.println("Enter your choice: ");
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter Student Name: ");
			student.setStudName(scanner.next());
			System.out.println("Enter Student Address: ");
			student.setStudAddress(scanner.next());
			System.out.println("Enter Student department: ");
			student.setStudDept(scanner.next());
			System.out.println("Enter Student Contact Number: ");
			student.setStudContactNo(scanner.nextLong());
			flag =operation.insertStudent(student);
			System.out.println(student);
			if(flag)
			{
				System.out.println("Added Successfully");
			}
			else
			{
				System.out.println("Failed to add");
			}
			break;
		case 2:
			System.out.println("Enter the student id to update details: ");
			studId = scanner.nextInt();
			student.setStudId(studId);
			if(studId == student.getStudId())
			{
				operation.updateStudentOperation(student);

			}
			else
			{
				System.out.println("Id  not Found");
			}
			break;
		case 3:
			System.out.println("Enter the student id to delete details: ");
			studId = scanner.nextInt();
			flag = operation.deleteStudent(studId);
			if(flag)
			{
				System.out.println("------Deleted Successfully------");
			}
			else
			{
				System.out.println("Id  not Found");
			}
			break;
		case 4:
			operation.searchStudentOperation(student);
			break;
		case 5:
			List<Student> l = operation.displayAllStudent();
			Iterator<Student> itr = l.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
			break;
		case 6:
			System.out.println("***Thanks***");
			System.exit(0);
		default:
				System.out.println("Invalid choice");
		}
		}while(choice > 0);
		scanner.close();
	}
}
