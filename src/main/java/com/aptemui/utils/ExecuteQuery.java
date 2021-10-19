package com.aptemui.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ExecuteQuery {
	
	

	public static void runquery() {
		String host = "jdbc:sqlserver://uks-asql-mws-server-test.database.windows.net";
		String u = "laxmimaddali";
		String p = "kelNEBUxebr1";
		
		try {
			Connection connection = DriverManager.getConnection(host, u, p);
			Statement statement = connection.createStatement();
			System.out.println("db test: "+statement.getConnection());
			//statement.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
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
	
	public static void read() throws Exception {
		ResultSet rs = null;
		
		rs = executeQueryAndReturnData("update s set SignerId=null, SignerPosition=null" + 
				"                from Orchard_Users_UserPartRecord" + 
				"                 join WA_Pdf_Signature s on u.id=s.EntityId" + 
				"                 where username='laxmiaptemautomation+1@gmail.com' and type in ('ApprenticeshipAgreement','Corndel-CommitmentStatement')");
		


	}

	public static void main(String[] args) throws Exception {
		//read();
		runquery();
	}

}
