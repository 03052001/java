package com.ds;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ds.pojo.Employee;


@WebServlet("/modifyEmployee")
public class ModifyEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession(true);
		ArrayList<Employee> theList  = (ArrayList<Employee>) session.getAttribute("allEmps");
		response.setContentType("text/html"); // MIME

		try
		{
		
		
		int empno = Integer.parseInt(request.getParameter("empno"));
		String empname =request.getParameter("empname");
		String empjob = request.getParameter("empjob");
		
		int empsal = Integer.parseInt(request.getParameter("empsal"));
		
		Employee modifiedEmp = new Employee(empno,empname,empjob,empsal);
		System.out.println("MODIFIED : "+modifiedEmp);
		
		System.out.println("emp number to modify is :  "+modifiedEmp);
		Iterator<Employee> empIterator = theList.iterator();
		while(empIterator.hasNext()) {
			Employee foundEmp = empIterator.next();
			System.out.println("found tempEmp : "+foundEmp);
			if(foundEmp.getEmployeeNumber() == modifiedEmp.getEmployeeNumber()) {
				System.out.println("comparing tempEmp : "+foundEmp.getEmployeeNumber()+ " with "+modifiedEmp.getEmployeeNumber());
				empIterator.remove();
				break;
			}
		}
		theList.add(modifiedEmp);

		pw.println("<h2> employee modified successfully....</h2>");
		pw.println("<a href='emp'>Back to Home</a>");
		System.out.println("employee modified to the list....");
		}
		catch(Exception e) {
			System.out.println("Invalid value...."+e);
			pw.println("<h3>Some exception : "+e.getMessage()+"</h3>");
			pw.println("<a href='emp'>Back to Home</a>");

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
