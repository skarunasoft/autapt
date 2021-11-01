package com.aptemui.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.aptemui.extent.ExtentTestManager;



public class ExecuteQuery {
	
	
/**
 * 
 * @param query
 * @return
 * @throws Exception
 */
	protected static boolean executeQueryAndReturnData(String query) throws Exception {
		boolean flag = false;
		ResultSet rs = null;
		Connection connection = null;
		try {
			System.out.println("db username: " + ResourceHandler.getPropValue("dbusername"));
			System.out.println("db password: " + ResourceHandler.getPropValue("dbpassword"));
			System.out.println("db host: " + ResourceHandler.getPropValue("dbhost"));
			System.out.println("query: " + query);
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			connection = DriverManager.getConnection(ResourceHandler.getPropValue("dbhost").trim(),
					ResourceHandler.getPropValue("dbusername").trim(),
					ResourceHandler.getPropValue("dbpassword").trim());
			System.out.println("Connection Established: [" + connection + "]");
			Statement stmt = connection.createStatement();
			Thread.sleep(10000);
			rs = stmt.executeQuery(query);
			System.out.println("execution result: "+ rs);
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public static boolean runQuery() throws Exception {
		boolean status=false;
		String query = "update s set SignerId=null, SignerPosition=null" + 
				"                from Orchard_Users_UserPartRecord" + 
				"                 join WA_Pdf_Signature s on u.id=s.EntityId" + 
				"                 where username='laxmiaptemautomation+1@gmail.com' and type in ('ApprenticeshipAgreement','Corndel-CommitmentStatement')"
				;
				try {
			status=executeQueryAndReturnData(query);
			
			System.out.println("query execution status: "+ status);
			ExtentTestManager.logEventToReport("pass", query, " ==> Query is executing");
			ExtentTestManager.logEventToReport("pass", status, " ==> Execution of query status");
			status=true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("fail", "Execution of query: ", e.getMessage());
		}
		return status;

	}

//	public static void main(String[] args) throws Exception {		
//		runQuery();
//	}

}
