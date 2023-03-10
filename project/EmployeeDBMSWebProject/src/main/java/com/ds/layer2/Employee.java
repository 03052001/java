package com.ds.layer2;//1 - must be in a package
//2 must be public
public class Employee { //bean class | component
	
	//3 - must have private data
	private int employeeNumber; //for empno
	private String employeeName; //ename
	private String employeeJob; //job
	private int employeeSalary; //sal
	
	public Employee(int employeeNumber, String employeeName, String employeeJob, int employeeSalary) {
		super();
		System.out.println("POJO Employee(1,2,3,4) is LOADED");
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.employeeJob = employeeJob;
		this.employeeSalary = employeeSalary;
	}
	//4 must have no-arg ctor.
	public Employee() {
		super();
		System.out.println("POJO Employee() is LOADED");

		// TODO Auto-generated constructor stub
	}

	//5 - getters/setters to introspect the data
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeJob() {
		return employeeJob;
	}
	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}
	public int getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", employeeName=" + employeeName + ", employeeJob="
				+ employeeJob + ", employeeSalary=" + employeeSalary + "]";
	}
	
	
	
	

}
