package com.bridgelabz.jdbcStatement;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.jdbcPreparedStatment.Student;

public class EmpTest
{
	public static void main(String[] args) 
	{
		int choice=0,empId;
		boolean flag;
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		EmpOperations empOperations = new EmpOperations();
		do
		{
			System.out.println("1.Insert Employee \n2.Update Employee \n3.Delete Employee \n4.Search Employee "
					+ "\n5.Display All Employee \n6.Exit");
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				flag = empOperations.insertEmployee();
				if(flag)
				{
					System.out.println("-----Added Sucessfully-----");
				}
				else
				{
					System.out.println("-----Failed To Add-----");
				}
				break;
			case 2:
				empOperations.updateEmpOperation(employee);
				break;
			case 3:
				System.out.println("Enter the Employee id to delete the details: ");
				empId = scanner.nextInt();
				flag = empOperations.deleteEmployee(empId);
				if(flag)
				{
					System.out.println("-----Deleted Sucessfully-----");
				}
				else
				{
					System.out.println("-----Failed to delete-----");
				}
				break;
			case 4:
				empOperations.searchEmpOperation(employee);
				break;
			case 5:
				List<Employee> l = empOperations.displayAllEmployee();
				Iterator<Employee> itr = l.iterator();
				while(itr.hasNext())
				{
					System.out.println(itr.next());
				}
				break;
			case 6:
				System.out.println("*****Thanks*****");
				System.exit(0);
			}
		}while(choice > 0);
		scanner.close();
	}
}
