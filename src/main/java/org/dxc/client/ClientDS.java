package org.dxc.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dxc.dao.EmpdaoImp;
import org.dxc.model.Employee;

public class ClientDS {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmpdaoImp dao = new EmpdaoImp();
		
		List<Integer> arr= new ArrayList<Integer>();

		
		while(true) {
			
			System.out.println("Press 1. Save an Employee to DataBase");
			System.out.println("Press 2. Get the list of all Employees");
			System.out.println("Press 3. Update Employee details");
			System.out.println("Press 4. Delete an Employee");
			System.out.println("Press 5. Exit");
			
			System.out.println();
			
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			
				case 1:
				{	
						System.out.println("Enter Employee details ");
						
						System.out.println();
						
						System.out.print("Enter EmployeeName: ");
						String emp_Name = scanner.nextLine();
      					//System.out.println();
						
						System.out.print("Enter EmployeeAge: ");
						int emp_Age = scanner.nextInt();
//						System.out.println();
						
						
						System.out.print("Enter EmployeeSalary: ");
						double emp_Salary = scanner.nextDouble();
//						System.out.println();
						
						
						int empId = dao.saveEmployee(emp_Name, emp_Age, emp_Salary);
						
						arr.add(empId);
						
						System.out.println();
						System.out.println("Employee saved successfully with id  " + empId);
						System.out.println();
						break;
				}		
				case 2:
				{		
						
						List<Employee> empList = dao.getAllEmployees();
						
						System.out.println();
						System.out.println("List of all Employees : ");
						System.out.println();
						
						for(Employee emp: empList) {
							System.out.println(emp);
						}
						
						System.out.println();
						System.out.println();
						break;
						
				}		
				case 3:
				{
						System.out.println("Choose an Id from the list:");
			
						System.out.println(arr);
						
						System.out.print("Enter the id :");
						int empId = scanner.nextInt();
						
						System.out.print("Do you want to update Age / Salary (1 / 2) ?: ");
						int ch = scanner.nextInt();
						scanner.nextLine();
						
						switch(ch) {
						
							case 1:
							{
								System.out.print("Enter new age: ");
								int emp_Age = scanner.nextInt();
								
								dao.updateEmployee(empId, emp_Age);
								Employee emp = dao.getEmployee(empId);
								
								System.out.println();
								System.out.println("Updated Successfully!");
								System.out.println("Updated Employee Info: "+ emp);
								System.out.println();
								break;
							}
							
							case 2:
							{
								System.out.print("Enter new salary: ");
								double salary = scanner.nextDouble();
								
								dao.updateEmployee(empId, salary);
								Employee emp = dao.getEmployee(empId);
								
								System.out.println();
								System.out.println("Updated Successfully!");
								System.out.println("Updated Employee Info: "+ emp);
								System.out.println();
								break;
							}
						}
						
						
						break;
				}		
				case 4:
				{
					
						System.out.println(arr);
						
						System.out.print("Choose emp_Id to delete: ");
						int empId = scanner.nextInt();
						
						Employee emp = dao.getEmployee(empId);
						
						System.out.println();
						System.out.println("Emp details : "+ emp);
						System.out.print("Do you want to delete ( Y / N) ? : ");
						
						scanner.nextLine();
						
						String input = scanner.nextLine();
						
						System.out.println(input);
						
						if(input.equalsIgnoreCase("Y") == true) {
							dao.deleteEmployee(empId);
							System.out.println("Object Deleted Successfully!");
							System.out.println();
						} else {
							System.out.println("Operation Cancelled!");
							System.out.println();
						}
						
						break;
				}		
				case 5:	
						scanner.close();
						System.out.println("Program Exited!");
						System.exit(0);
						
				default:
						System.out.println("Wrong choice , Please try Again!");
						System.out.println();
						break;
			}
		}
	}
	
}



