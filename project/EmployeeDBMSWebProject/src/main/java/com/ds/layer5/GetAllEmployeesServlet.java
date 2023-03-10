package com.ds.layer5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ds.layer2.Employee;
import com.ds.layer3.EmployeeDAOImpl;
import com.ds.layer3.exceptions.EmployeeNotFoundException;
import com.ds.layer4.EmployeeServiceImpl;

//LAYER 5 

@WebServlet("/emps")
public class GetAllEmployeesServlet extends HttpServlet {
	//WILL TALK TO LAYER 4
	EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("CONTROLLER is LOADED....");

		List<Employee> allEmps = employeeService.getEmployeesService();

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String value = request.getParameter("submit");
		
		if(value.equals("Show All Employees"))
		{
				pw.println("<table border=5>"); //HTML is in the custody of JAVA code 
				
				Iterator<Employee> empIterator = allEmps.iterator();
	
				while(empIterator.hasNext()) {
					Employee emp = empIterator.next();
					pw.println("<tr>");
	
					pw.println("<td>");
						pw.println(emp.getEmployeeNumber());
						pw.println("<input type=hidden name='empno' value='"+emp.getEmployeeNumber()+"'>");
	
					pw.println("</td>");
				
					pw.println("<td>");
						pw.println("<input type=text name='empname' value='"+emp.getEmployeeName()+"'>");
					pw.println("</td>");
					
					pw.println("<td>");
						pw.println("<input type=text name='empjob' value='"+emp.getEmployeeJob()+"'>");
					pw.println("</td>");
					
					pw.println("<td>");
						pw.println("<input type=text name='empsal' value='"+emp.getEmployeeSalary()+"'>");
					pw.println("</td>");
											
					pw.println("<td>");
						pw.println("<input type=submit name=submit value='Edit'>");
					pw.println("</td>");
				
					pw.println("</tr>");
				}	
			pw.println("</table>");
		}
		else if(value.equals("Show Single Employee")) {
			System.out.println("-----------------");
			int empToFind = Integer.parseInt(request.getParameter("empToSearch"));
			System.out.println("In the Else "+empToFind);
			try
			{
				Employee emp = employeeService.getEmployeeService(empToFind);
					pw.println("<table border=5>"); //HTML is in the custody of JAVA code 
				
						pw.println("<tr>");
	
						pw.println("<td>");
							pw.println(emp.getEmployeeNumber());	
						pw.println("</td>");
					
						pw.println("<td>");
							pw.println(emp.getEmployeeName());
						pw.println("</td>");
						
						pw.println("<td>");
							pw.println(emp.getEmployeeJob());
						pw.println("</td>");
						
						pw.println("<td>");
							pw.println(emp.getEmployeeSalary());
						pw.println("</td>");
												
						pw.println("</tr>");
					pw.println("</table>");
				}
				catch (EmployeeNotFoundException e) {
					pw.println("<td>");
						pw.println("<h3 style='color:red'>Error : "+e.getMessage()+"</h3>");
					pw.println("</td>");
				
				}
			}
		else if(value.equals("Add Employee")) {
			int empno = Integer.parseInt(request.getParameter("empToAdd"));
			String ename =request.getParameter("empname");
			String ejob = request.getParameter("empjob");
			int esal = Integer.parseInt(request.getParameter("empsal"));
			

			Employee emp = new Employee(empno,ename,ejob,esal);
			employeeService.addEmployeeService(emp);
			pw.println("<td>");
				pw.println("Employee added...");
				pw.println("<a href='http://localhost:8080/EmployeeDBMSWebProject'>Back</a>");
			pw.println("</td>");
		}
		else if(value.equals("Modify Employee")) {
			int empno = Integer.parseInt(request.getParameter("empToModify"));
			String ename =request.getParameter("empname");
			String ejob = request.getParameter("empjob");
			int esal = Integer.parseInt(request.getParameter("empsal"));
			

			Employee emp = new Employee(empno,ename,ejob,esal);
			employeeService.updateEmployeeService(emp);
			pw.println("<td>");
				pw.println("Employee updated...");
				pw.println("<a href='http://localhost:8080/EmployeeDBMSWebProject'>Back</a>");
			pw.println("</td>");
		}
		else if(value.equals("Delete Employee")) {
			try
			{
				int empno = Integer.parseInt(request.getParameter("empToDelete"));
				employeeService.deleteEmployeeService(empno);
				pw.println("<td>");
					pw.println("Employee deleted...");
					pw.println("<a href='http://localhost:8080/EmployeeDBMSWebProject'>Back</a>");
				pw.println("</td>");
	
			}
			catch(EmployeeNotFoundException e) {
				pw.println("<td>");
					pw.println("<h3 style='color:red'>Error : "+e.getMessage()+"</h3>");
				pw.println("</td>");
			}
			
		}
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public GetAllEmployeesServlet() {
        super();

    }

	
	public void init(ServletConfig config) throws ServletException {

	}

	
	public void destroy() {

	}
}
