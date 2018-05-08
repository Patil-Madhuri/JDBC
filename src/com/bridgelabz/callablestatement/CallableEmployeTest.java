package com.bridgelabz.callablestatement;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.jdbcStatement.Employee;

public class CallableEmployeTest
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		Employee employee = new Employee();
		EmployeeOperation employeeOperation = new EmployeeOperation();
		int choice =0,empId;
		boolean flag;
		do
		{
			System.out.println("1.Insert Employee \n2.Update Employee \n3.Search Employee \n4.Delete Employee \n5.Display Employee \n6.Exit");
			System.out.println("Enter your choice: ");
			choice =  scanner.nextInt();
			switch(choice)
			{
			case 1:
				flag =employeeOperation.insertEmployee();
				if(flag)
				{
					System.out.println("-----Added Successfully-----");
				}
				else
				{
					System.out.println("-----Failed to Add-----");
				}
				break;
			case 2:
				System.out.println("Enter the employee id to update the details: ");
				 empId = scanner.nextInt();
				 employee.setEmpId(empId);
				 employeeOperation.updateEmployee(employee);
				break;
			case 3:
				System.out.println("Enter the employee id to search the details: ");
				 empId = scanner.nextInt();
				 employee = employeeOperation.searchEmployee(empId);
				 System.out.println(employee);
				break;
			case 4:
				System.out.println("Enter the employee id to delete the details: ");
				 empId = scanner.nextInt();
				flag = employeeOperation.deleteEmployee(empId);
				if(flag)
				{
					System.out.println("-----Deleted Sucessfully-----");
				}
				else
				{
					System.out.println("-----Failed to delete-----");
				}
				break;
			case 5:
				System.out.println("-----Employee List------");
				List<Employee> list = employeeOperation.displayAllEmployee();
				Iterator<Employee> iterator = list.iterator();
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
		}while(choice > 0);
		scanner.close();		
	}
}
