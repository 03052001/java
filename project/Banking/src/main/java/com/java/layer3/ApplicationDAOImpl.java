package com.java.layer3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.layer2.Application;



public class ApplicationDAOImpl implements ApplicationDAO {

	Connection conn;

	public ApplicationDAOImpl() {
			try {
				System.out.println("Trying to load the driver...");
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				System.out.println("1. driver...loaded");
				System.out.println("Trying to connect to the DB...");
				this.conn = DriverManager.getConnection("jdbc:mysql://localhost/BankingApplicationDatabase", "root", "root123");
				System.out.println("2. Connected to the DB :" + conn);
			} catch (SQLException e) {e.printStackTrace();}
	}

	@Override
	public Application selectApplication(int applicationId) {
		// TODO Auto-generated method stub
		Application application = null; //make a blank currency object

		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM AccountApplication where applicantID="+applicationId); 
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			if (result.next()) {
				application = new Application();
				application.setApplicationId(result.getInt(1)); //fill it up column wise
				application.setApplicantName(result.getString(2));
				application.setFathername(result.getString(3));
				application.setGender(result.getString(4));
				application.setMobileNumber(result.getString(5));
				application.setEmailID(result.getString(6));
				application.setAdhaarNumber(result.getString(7));
				application.setDateOFBirth(result.getString(8));
				application.setApplicantStatus(result.getString(9));
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return application;
	}

	@Override
	public List<Application> selectAllApplication() {
		List<Application> applicationList = new ArrayList<Application>();
		
		try {
			Statement statement = conn.createStatement();
			System.out.println("3. Statement created....");
			ResultSet result = statement.executeQuery("SELECT * FROM AccountApplication"); 
			System.out.println("4. execute the query");

			System.out.println("5. acquire the result and process it");

			while (result.next()) {
				Application application = new Application(); 
				application.setApplicationId(result.getInt(1)); //fill it up column wise
				application.setApplicantName(result.getString(2));
				application.setFathername(result.getString(3));
				application.setGender(result.getString(4));
				application.setMobileNumber(result.getString(5));
				application.setEmailID(result.getString(6));
				application.setAdhaarNumber(result.getString(7));
				application.setDateOFBirth(result.getString(8));
				application.setApplicantStatus(result.getString(9)) ;
				
				applicationList.add(application); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return applicationList;
	}

	@Override
	public void insertApplication(Application application) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into AccountApplication(ApplicantName,Fathername,Gender,MobileNumber,EmailID,AdhaarNumber,DateOFBirth,ApplicantStatus) values(?,?,?,?,?,?,?,?)");
			System.out.println("3. PreparedStatement created....");

			
			
			
			pst.setString(1, application.getApplicantName());
			pst.setString(2, application.getFathername());
			pst.setString(3, application.getGender());
			pst.setString(4, application.getMobileNumber());
			pst.setString(5, application.getEmailID());
			pst.setString(6, application.getAdhaarNumber());
			pst.setString(7, application.getDateOFBirth());
			pst.setString(8, application.getApplicantStatus());
			
			
			

			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the insert query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	

	@Override
	public void deleteApplication(int applicationId) {
		try {
			PreparedStatement pst = conn.prepareStatement("DELETE FROM AccountApplication list  where applicantID=?");
			System.out.println("3. PreparedStatement created....");

			pst.setInt(1, applicationId);
			
			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the delete query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void updateApplication(Application application) {
		try {
			PreparedStatement pst = conn.prepareStatement("UPDATE AccountApplication set ApplicantName=?, Fathername=?, Gender=?,MobileNumber=?,EmailID=?,AdhaarNumber=?,DateOFBirth=?,ApplicantStatus=? where applicantID=?");
			System.out.println("3. PreparedStatement created....");

			pst.setInt(9, application.getApplicationId());
			pst.setString(1, application.getApplicantName());
			pst.setString(2, application.getFathername());
			pst.setString(3, application.getGender());
			pst.setString(4, application.getMobileNumber());
			pst.setString(5, application.getEmailID());
			pst.setString(6, application.getAdhaarNumber());
			pst.setString(7, application.getDateOFBirth());
			pst.setString(8, application.getApplicantStatus());

			int rows = pst.executeUpdate(); //run the insert query
			
			System.out.println("4. executed the update query : "+rows+ " row(s) updated");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	

}
