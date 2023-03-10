package com.ds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ds.pojo.Employee;

// http://ip:port/EmployeeManagementProject/emp

@WebServlet("/emp")
public class EmployeeManagementServlet extends HttpServlet {
	
	ArrayList<Employee> empStaff = new ArrayList<Employee>();
	
    public EmployeeManagementServlet() {
        super();
		System.out.println("EmployeeManagementServlet() invoked...");

    }

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() invoked...");
		Employee emp1 = new Employee(101,"Sarvesh Mukhil","Analyst",80000);
		Employee emp2 = new Employee(102,"Shreeharsha K","Analyst",80000);
		Employee emp3 = new Employee(103,"Sidhharth Bhusnur","Analyst",80000);
		Employee emp4 = new Employee(104,"Suvomoy Maitra","Analyst",80000);
		Employee emp5 = new Employee(105,"Pawan AV","Analyst",80000);
		Employee emp6 = new Employee(106,"Nagrathna","Analyst",80000);
		Employee emp7 = new Employee(107,"Subrahmanya Bhat","Analyst",80000);
		Employee emp8 = new Employee(108,"Rashmi Kiragi","Analyst",80000);
		Employee emp9 = new Employee(109,"Darshan S","Analyst",80000);
		Employee emp10 = new Employee(110,"Subramanya KN","Analyst",80000);
		Employee emp11 = new Employee(111,"Ambika Suryavanshi","Analyst",80000);
		Employee emp12 = new Employee(112,"Ajaya Krishna M","Analyst",80000);
		Employee emp13 = new Employee(113,"Varun MD","Analyst",80000);

		Employee emp14 = new Employee(114,"Rashinkar Mahadev","Analyst",80000);
		Employee emp15 = new Employee(115,"Prem Gumathanavar","Analyst",80000);
		Employee emp16 = new Employee(116,"Allauddin Jamkhamewale","Analyst",80000);
		Employee emp17 = new Employee(117,"Garima Singh","Analyst",80000);
		Employee emp18 = new Employee(118,"Ridham Sawhney","Analyst",80000);
		Employee emp19 = new Employee(119,"Rashmi Baviskar","Analyst",80000);
		Employee emp20 = new Employee(120,"Nitish Supe","Analyst",80000);
		Employee emp21 = new Employee(121,"Param Jangale","Analyst",80000);
		Employee emp22 = new Employee(122,"Shreyas Bhambore","Analyst",80000);
		Employee emp23 = new Employee(123,"Pratiksha Kathar","Analyst",80000);
		Employee emp24 = new Employee(124,"Yash Zore","Analyst",80000);
		
		empStaff.add(emp1);
		empStaff.add(emp2);
		empStaff.add(emp3);
		empStaff.add(emp4);
		empStaff.add(emp5);
		empStaff.add(emp6);
		empStaff.add(emp7);
		empStaff.add(emp8);
		empStaff.add(emp9);
		empStaff.add(emp10);
		empStaff.add(emp11);
		empStaff.add(emp12);
		empStaff.add(emp13);
		empStaff.add(emp14);
		empStaff.add(emp15);
		empStaff.add(emp16);
		empStaff.add(emp17);
		empStaff.add(emp18);
		empStaff.add(emp19);
		empStaff.add(emp20);
		empStaff.add(emp21);
		empStaff.add(emp22);
		empStaff.add(emp23);
		empStaff.add(emp24);
		
		
	}

	
	public void destroy() {
		System.out.println("destroy() invoked...");

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet(req,resp) invoked...");

		HttpSession session = request.getSession(true);
		session.setAttribute("allEmps", empStaff);
		
		PrintWriter pw = response.getWriter();
		pw.println("<table border=5>"); //HTML is in the custody of JAVA code 
			
			Iterator<Employee> empIterator = empStaff.iterator();
			
			
			pw.println("<form action='addEmployee'>");

			pw.println("<tr>");

			pw.println("<td>");
			pw.println("<input type=text value='Enter emp no' name='empno'>");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("<input type=text value='Enter emp name' name='empname'>");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("<input type=text value='Enter emp job' name='empjob'>");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("<input type=text value='Enter emp sal' name='empsal'>");
			pw.println("</td>");

			
			pw.println("<td>");
				pw.println("<button>Add</button>");
			pw.println("</td>");
	
			pw.println("</tr>");
			
			pw.println("</form>");


		
			while(empIterator.hasNext()) {
				Employee emp = empIterator.next();

				pw.println("<form action='modifyEmployee'>");


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
			
				pw.println("</form>");

			
			//	System.out.println("deleteEmployee?empno="+emp.getEmployeeNumber());
				
			
				
				pw.println("<form action='deleteEmployee'>");
					
					pw.println("<input type=hidden name='empno' value='"+emp.getEmployeeNumber()+"'>");
					pw.println("<td>");
						pw.println("<input type=submit name=submit value='Delete'>");
					pw.println("</td>");
					
				pw.println("</form>");

				
				pw.println("</tr>");

			}
			
			
		pw.println("</table>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost(req,resp) invoked...");
		doGet(request, response);
	}

}
