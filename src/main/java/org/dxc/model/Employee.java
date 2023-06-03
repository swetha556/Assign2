package org.dxc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(name="emp_Name", nullable=false)
	private String emp_Name;
	
	@Column(name="emp_Age")
	private int emp_Age;
	
	@Column(name="emp_Salary", nullable=false)
	private double emp_Salary;

	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return emp_Name;
	}

	public void setEmpName(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public int getEmpAge() {
		return emp_Age;
	}

	public void setEmpAge(int emp_Age) {
		this.emp_Age = emp_Age;
	}

	public double getEmpSalary() {
		return emp_Salary;
	}

	public void setEmpSalary(double emp_Salary) {
		this.emp_Salary = emp_Salary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", emp_Name=" + emp_Name + ", emp_Age=" + emp_Age
				+ ", emp_Salary=" + emp_Salary + "]";
	}

}
