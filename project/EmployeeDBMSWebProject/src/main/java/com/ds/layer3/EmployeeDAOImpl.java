package com.ds.layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ds.layer2.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
	Connection conn ;
	public EmployeeDAOImpl() {
		try {
			System.out.println("DAO is LOADED....");
			System.out.println("Trying to load the driver...");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			System.out.println("1. driver...loaded");
			System.out.println("Trying to connect to the DB...");
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost/mysql", "root", "root123");
			System.out.println("2. Connected to the DB :" + conn);
		} catch (SQLException e) {e.printStackTrace();}
	}
	@Override
	public void addEmployee(Employee e) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into employee values (?,?,?,?)");
			System.out.println("3. PreparedStatement created....");
			pst.setInt(1, e.getEmployeeNumber());
			pst.setString(2, e.getEmployeeName());
			pst.setString(3, e.getEmployeeJob());
			pst.setInt(4, e.getEmployeeSalary());
			int rows = pst.executeUpdate(); //run the insert query	
			System.out.println("4. executed the insert query : "+rows+ " row(s) inserted");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> empList = new ArrayList<Employee>();//blank list
		
		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM EMPLOYEE"); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			while (result.next()) {
				Employee employee = new Employee(); //make a blank employee object
				employee.setEmployeeNumber(result.getInt(1)); //fill it up column wise
				employee.setEmployeeName(result.getString(2));
				employee.setEmployeeJob(result.getString(3));
				employee.setEmployeeSalary(result.getInt(4));
				empList.add(employee); //push this object in the list
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public Employee getEmployee(int empno) {
		
		Employee employee = null;
		
		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM EMPLOYEE where empno="+empno); //eid, ename, job, sal    cid,cname,city,pin
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			if (result.next()) {
				employee = new Employee(); //make a blank employee object
				employee.setEmployeeNumber(result.getInt(1)); //fill it up column wise
				employee.setEmployeeName(result.getString(2));
				employee.setEmployeeJob(result.getString(3));
				employee.setEmployeeSalary(result.getInt(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public void updateEmployee(Employee e) {
		
		try {
			PreparedStatement pst = conn.prepareStatement("update employee set ename=?, job=?, sal=? where empno=?");
			System.out.println("3. PreparedStatement created....");

			
			pst.setString(1, e.getEmployeeName());
			pst.setString(2, e.getEmployeeJob());
			pst.setInt(3, e.getEmployeeSalary());
			
			pst.setInt(4, e.getEmployeeNumber());

			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the update query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void deleteEmployee(int empno) {
		try {
			PreparedStatement pst = conn.prepareStatement("delete from employee where empno=?");
			System.out.println("3. PreparedStatement created....");

			
			
			pst.setInt(1, empno);

			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the delete query : "+rows+ " row(s) deleted");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
