package com.aptemui.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class ExecuteQuery {
	
	

	protected static ResultSet executeQueryAndReturnData(String query) throws Exception {
		ResultSet rs = null;
		Connection connection = null;
		try {
			System.out.println("-----" + ResourceHandler.getPropValue("dbusername"));
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			connection = DriverManager.getConnection(ResourceHandler.getPropValue("dbhost").trim(),
					ResourceHandler.getPropValue("dbusername").trim(),
					ResourceHandler.getPropValue("dbpassword").trim());
			System.out.println("Connection Established: [" + connection + "]");
			Statement stmt = connection.createStatement();
			Thread.sleep(10000);
			rs = stmt.executeQuery(query);
			//Helper.INSTANCE.logEventInfoToReport(driver, query, "Executed");
		} catch (Exception e) {
			//Helper.INSTANCE.logEventToReport(driver, "error", "Execute query", e.getMessage());
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public static void getBooksNonPodTransactions() throws Exception {
		ResultSet rs = null;
		
		rs = executeQueryAndReturnData("update s set SignerId=null, SignerPosition=null" + 
				"                from Orchard_Users_UserPartRecord" + 
				"                 join WA_Pdf_Signature s on u.id=s.EntityId" + 
				"                 where username='laxmiaptemautomation+1@gmail.com' and type in ('ApprenticeshipAgreement','Corndel-CommitmentStatement')");
		while (rs.next()) {
			
		}


	}

	public static void main(String[] args) throws Exception {
		getBooksNonPodTransactions();
		
	}

}
