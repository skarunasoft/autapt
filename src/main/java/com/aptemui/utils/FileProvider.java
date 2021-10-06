package com.aptemui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileProvider {
	
	
	public static String resourceFile = System.getProperty("user.dir")+"/src/main/resources/data/config.properties";
	public static String DOWNLOADPATH=System.getProperty("user.dir")+"/src/test/resources/download-file";
	public static String extentReportFile=System.getProperty("user.dir")+"/reports/"+ResourceHandler.getPropValue("app_name")+"-test-automation-report-"+new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(new Date())+".html";
	public static String extentReportFilePath = System.getProperty("user.dir")+"/"+ResourceHandler.getPropValue("app_name")+"-log.html";
	
	

}
