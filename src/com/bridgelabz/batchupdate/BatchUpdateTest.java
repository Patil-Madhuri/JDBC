package com.bridgelabz.batchupdate;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.jdbcPreparedStatment.Student;

public class BatchUpdateTest 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		StudentOperation studentOperation = new StudentOperation();
		Student student = new Student();
		int choice=0;
		boolean flag;
		do
		{
			System.out.println("1.Insert Student \n2.Update Student \n3.Search Student"
					+ " \n4.Delete Student \n5.Display All Student \n6.Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				
				flag = studentOperation.insertStudent();
				if(flag)
				{
					System.out.println("-----Added Sucessfully-----");
				}
				else
				{
					System.out.println("-----Failed to Add-----");
				}
				break;
			case 2:
				flag = studentOperation.updateStudent(student);
				if(flag)
				{
					System.out.println("-----Updated Sucessfully-----");
				}
				else
				{
					System.out.println("-----Failed to Update-----");
				}
				break;
			case 3:
				studentOperation.searchStudent(student);
						
				break;
			case 4:
				flag  =studentOperation.deleteStudent();
				if(flag)
				{
					System.out.println("-----Deleted sucessfully-----");
				}
				else
				{
					System.out.println("-----Failed to delete");
				}
				break;
				
			case 5:
				List<Student> studList = studentOperation.displayAllStudent();
				Iterator<Student> iterator = studList.iterator();
				while(iterator.hasNext())
				{
					System.out.println(iterator.next());
				}
				break;
			case 6:
				System.out.println("*****Thanks*****");
				System.exit(0);
			default:
				System.out.println("Invalid choice");
			}
		}while(choice>0);
		scanner.close();
	}
}
