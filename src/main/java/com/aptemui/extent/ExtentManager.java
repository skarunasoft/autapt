package com.aptemui.extent;


import com.aptemui.utils.FileProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




//import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.

public class ExtentManager {

	private static ExtentReports extent;
	//public static ExtentHtmlReporter htmlReporter;
	
	public static ExtentSparkReporter htmlReporter;

	public synchronized static ExtentReports getReporter() {
		if (extent == null) {
			/**
						 * Below code is used to Disable Freemarker logging
						 */
						try {
							freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE);
							
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
			
			// Set HTML reporting file location
//			htmlReporter = new ExtentHtmlReporter("./reports/AuthorPortal_TestReport.html");
						
						htmlReporter = new ExtentSparkReporter(FileProvider.extentReportFile);	
			//htmlReporter = new ExtentHtmlReporter(FileProvider.extentReportFilePath);
			htmlReporter.loadXMLConfig("./src/main/java/com/aptemui/extent/extent-config.xml", true);
			//htmlReporter.config()
                  
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

		}
		return extent;
	}
}