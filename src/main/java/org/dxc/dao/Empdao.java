package org.dxc.dao;

import java.util.List;

import org.dxc.model.Employee;
 interface Employeedao {
	int saveEmployee(String emp_Name, int emp_Age, double emp_Salary);
	List<Employee> getAllEmployees();
	void updateEmployee(int empId, int emp_Age);
	void updateEmployee(int empId, double emp_Salary);
	void deleteEmployee(int empId);
	Employee getEmployee(int empId);
}
