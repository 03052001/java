package com.ds.layer3;

import java.util.List;

import com.ds.layer2.Employee;

public interface EmployeeDAO { //POJI
	void 		   addEmployee(Employee e);   //1 C-create
	List<Employee> getEmployees();			  //2 R-read/all
	Employee       getEmployee(int empno);    //3 R-read/single
	void 		   updateEmployee(Employee e);//U-update
	void 		   deleteEmployee(int empno); //D-delete
}
