package com.ds.layer4;

import java.util.List;

import com.ds.layer2.Employee;
import com.ds.layer3.EmployeeDAOImpl;
import com.ds.layer3.exceptions.EmployeeNotFoundException;

//SERVICE CONTAINS THE BUSINESS LOGIC OF YOUR PROJECT

//LAYER 4
public class EmployeeServiceImpl implements EmployeeService {

	//WILL TALK TO LAYER 3
	EmployeeDAOImpl empDao = new EmployeeDAOImpl(); //DAO handle
	
	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("SERVICE is LOADED....");

	}

	@Override
	public void addEmployeeService(Employee e) {
		//some logic
		empDao.addEmployee(e);
		//some logic
	}

	@Override
	public List<Employee> getEmployeesService() {	
		//some logic here
		return empDao.getEmployees();//dao is invoked here
		//some logic here
	}

	@Override
	public Employee getEmployeeService(int empno) throws EmployeeNotFoundException
	{	
		//some logic here
		Employee e =  empDao.getEmployee(empno);//dao is invoked here
		if(e==null) {
			throw new EmployeeNotFoundException("Employee with this empno does not exists!!!");
		}
		//some logic here
		return e;
	}

	@Override
	public void updateEmployeeService(Employee e) {
		//some logic
		empDao.updateEmployee(e); //dao is invoked here
		//some logic
	}

	@Override
	public void deleteEmployeeService(int empno) throws EmployeeNotFoundException
	{
		//some logic
		Employee x = getEmployeeService(empno);
		if(x!=null) {
			empDao.deleteEmployee(empno); //dao is invoked here
		}
		else {
			throw new EmployeeNotFoundException("This employee does not exists");
		}
		
		//some logic
	}

}
