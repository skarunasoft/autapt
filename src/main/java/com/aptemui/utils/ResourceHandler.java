package com.aptemui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceHandler {

	

	

	public static String getPropValue(String Key) {
		InputStream input = null;
		String getValue = "";

		try {

			input = new FileInputStream(FileProvider.resourceFile);
			Properties prop = new Properties();

			prop.load(input);

			getValue = prop.getProperty(Key);
			if (getValue.length() != 0) {
				System.out.println("***The property key:" + "\"" + Key + "\"" + " and value:" + "\"" + getValue + "\"");

			} else {
				System.out.println("***The property value return as empty from the file");
			}
			input.close();

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			
			
		}

		return getValue;

	}
	
	
	
	public static boolean getHeadlessMode() throws IOException {
		
		if(getPropValue("chrome_headless").equalsIgnoreCase("true")) {
			return true;
		}
		
		return false;
		
	}
	

	 
}
