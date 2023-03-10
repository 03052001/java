package com.ds.layer4;

import java.util.List;

import com.ds.layer2.Employee;
import com.ds.layer3.exceptions.EmployeeNotFoundException;
//one service function may interact with multiple functions of a single DAO
//one service function may interact with mutlitple DAO's multiple functions
//one service function may interact with another service 
//SOA
public interface EmployeeService {
	public void addEmployeeService(Employee e); //1
	List<Employee> getEmployeesService();	//2
	Employee    getEmployeeService(int empno) throws  EmployeeNotFoundException;//3
	public void updateEmployeeService(Employee e); //4
	public void deleteEmployeeService(int empno) throws EmployeeNotFoundException; //5
	
}
