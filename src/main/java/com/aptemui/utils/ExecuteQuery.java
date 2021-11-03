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
	protected static ResultSet executeQueryAndReturnData(String query) throws Exception {
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public static ResultSet updateSignerUsingDBQuery() throws Exception {
		Statement getResult;
		ResultSet rs = null;
		String query = "update s set SignerId=null, SignerPosition=null" + 
				"                from Orchard_Users_UserPartRecord" + 
				"                 join WA_Pdf_Signature s on u.id=s.EntityId" + 
				"                 where username='laxmiaptemautomation+1@gmail.com' and type in ('ApprenticeshipAgreement','Corndel-CommitmentStatement')"
				;
				try {
					rs=executeQueryAndReturnData(query);
					getResult = rs.getStatement();
					System.out.println("query execution status: "+ getResult);
			ExtentTestManager.logEventToReport("pass", query, " ==> Query is executing" + getResult +" ==>Query result");
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("fail", "Execution of query: ", e.getMessage());
		}
		return rs;

	}
	
	public static String getUserIdUsingDBQuery() throws Exception
	{
		String id="";
		ResultSet rs = null;
		
		 id = "select id from Orchard_Users_UserPartRecord where username='laxmiaptemautomation+1@gmail.com'";
				try {
			rs=executeQueryAndReturnData(id);
			while (rs.next()) {
				id = rs.getString("id");
			}
			
			System.out.println("query execution status: "+ rs);
			ExtentTestManager.logEventToReport("pass", id, " ==> Query is executing");
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("fail", "Execution of query: ", e.getMessage());
		}
		return id;

	}



}
