package org.dxc.dao;

import java.util.List;

import org.dxc.model.Employee;
import org.dxc.util.HibernateUtil;
import org.hibernate.Session;

public class EmpdaoImp {
public int saveEmployee(String emp_Name, int emp_Age, double emp_Salary) {
		
		Employee employee = new Employee();
		employee.setEmpName(emp_Name);
		employee.setEmpAge(emp_Age);
		employee.setEmpSalary(emp_Salary);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		int id = (Integer) session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		
		return id;
	}

	public List<Employee> getAllEmployees() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) session.createQuery("FROM Employee emp ORDER BY emp_Name ASC").list();

		session.getTransaction().commit();
		session.close();

		return empList;
	}

	public void updateEmployee(int empId, int emp_Age) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class,empId);
		employee.setEmpAge(emp_Age);
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployee(int empId, double emp_salary) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empId);
		employee.setEmpSalary(emp_salary);

		session.getTransaction().commit();
		session.close();
		
	}

	public void deleteEmployee(int empId) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empId);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

	public Employee getEmployee(int empId) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, empId);

		
		session.getTransaction().commit();
		session.close();
		
		return employee;
	}
}
