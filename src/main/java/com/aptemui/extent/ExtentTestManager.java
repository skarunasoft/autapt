package com.aptemui.extent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aptemui.base.WebDriverHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


 
public class ExtentTestManager{
	  public static Map<Integer,ExtentTest> extentTestMap = new HashMap<Integer,ExtentTest>();
	  public static Map<Integer,ExtentTest> extentParentTestMap = new HashMap<Integer,ExtentTest>();
	  public static Map<Integer,ExtentTest> extentChildMapTestMap = new HashMap<Integer,ExtentTest>();
	  public static Map<Integer,ExtentTest> extentInnerChildMapTestMap = new HashMap<Integer,ExtentTest>();
	  
	    public static ExtentReports extent = ExtentManager.getReporter();
	    public static Map<String, Integer> reportStatus = new HashMap<String, Integer>();
	    
	    /**
	     * 
	     * @return
	     */
	    public static synchronized ExtentTest getTest(){
	    	ExtentTest test = null;
	    	try {
				 test=(ExtentTest)extentTestMap.get((int) (long) (Thread.currentThread().getId()));
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return test;
	    }

	    /**
	     * 
	     * @return
	     */
		public static synchronized ExtentTest getParentTest() {
			ExtentTest test = null;
			try {
				test = (ExtentTest) extentParentTestMap.get((int) (long) Thread.currentThread().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return test;
		}
	    /**
	     * 
	     * @return
	     */
	    public static synchronized ExtentTest getChildTest() {
	    	ExtentTest test = null;
	    	try {
				return (ExtentTest)extentChildMapTestMap.get((int)(long)Thread.currentThread().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return test;
	    }
	    
	    /**
	     * 
	     * @return
	     */
	    public static synchronized ExtentTest getInnerChildTest() {
	    	ExtentTest test = null;
	    	try {
				test= (ExtentTest)extentInnerChildMapTestMap.get((int)(long)Thread.currentThread().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	return test;
	    }
	 
	    /**
	     * 
	     */
	    public static synchronized void endTest() {
	        try {
				extent.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	    }
	 
	    /**
	     * 
	     * @param testName
	     * @return
	     */
	    public static synchronized ExtentTest startTest(String testName) {
	        ExtentTest test = null;
			try {
				test = extent.createTest(testName);
				extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
				extentParentTestMap.put((int) (long)Thread.currentThread().getId(), test);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	        return test;
	    }
	    /**
	     * 
	     * @param testName
	     * @return
	     */
	    public static synchronized ExtentTest startChildTest(String testName) {
	    	ExtentTest childTest=null;
	    	try {
			 childTest=getParentTest().createNode("<b>"+testName+"</b>");
			   extentTestMap.put((int) (long) (Thread.currentThread().getId()), childTest);
			   extentChildMapTestMap.put((int) (long) (Thread.currentThread().getId()), childTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return childTest;
	    }
	    
	    /**
	     * 
	     * @param testName
	     * @return
	     */
	    public static synchronized ExtentTest startInnerChildTest(String testName) {
	    	ExtentTest innerChildTest=null;
	    	try {
	    		innerChildTest=getChildTest().createNode("<b>"+testName+"</b>");
			   extentTestMap.put((int) (long) (Thread.currentThread().getId()), innerChildTest);
			   extentInnerChildMapTestMap.put((int) (long) (Thread.currentThread().getId()), innerChildTest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return innerChildTest;
	    }
	    /**
	     * 
	     */
	    public static synchronized void endChildTest() {
		       try {
				extentTestMap.put((int) (long) (Thread.currentThread().getId()), getParentTest());
				endTest();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    }
	    
	    /**
	     * 
	     */
	    public static synchronized void endInnerChildTest() {
		       try {
				extentTestMap.put((int) (long) (Thread.currentThread().getId()), getChildTest());
				endTest();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    }
	    
	    
	    /**
	     * flush test
	     */
	    public static synchronized void flushTest() {
	    	try {
	       reportStatus.put("TOTAL", ExtentManager.htmlReporter.getTestList().size());
	       reportStatus.put("PASS", ExtentManager.htmlReporter.getReportStatusStats().getParentCountPass());
	       reportStatus.put("ERROR", ExtentManager.htmlReporter.getReportStatusStats().getParentCountError());
	       int untestedCases=ExtentManager.htmlReporter.getReportStatusStats().getParentCountFatal();
	       int totalFailedCases=ExtentManager.htmlReporter.getReportStatusStats().getParentCountError()+ExtentManager.htmlReporter.getReportStatusStats().getParentCountFail();
	       reportStatus.put("FAIL", totalFailedCases);
	       reportStatus.put("UNTESTED", untestedCases);      
	       
	        System.out.println("[INFO] ---"+"Total TESTS count: " +  ExtentManager. htmlReporter.getTestList().size());
	       	System.out.println("[INFO] ---"+"Total PASS count: " +  ExtentManager.htmlReporter.getReportStatusStats().getParentCountPass());
	  	 	System.out.println("[INFO] ---"+"Total FAIL count: " +  ExtentManager.htmlReporter.getReportStatusStats().getParentCountFail());	 
	  	 	System.out.println("[INFO] ---"+"Total ERROR count: " +  ExtentManager.htmlReporter.getReportStatusStats().getParentCountError());
	  	 	System.out.println("[INFO] ---"+"Total WARNING count: " +  ExtentManager.htmlReporter.getReportStatusStats().getParentCountWarning());
	  	 	System.out.println("[INFO] ---"+"Total FATAL count: " +  ExtentManager.htmlReporter.getReportStatusStats().getParentCountFatal());
	  	 	
	    	} catch (Exception e) {		
				e.printStackTrace();
			}
	    	
	    	
	    }
	    
	    public static String captureScreen(WebDriver driver, String imagePath) {
			 try {
		/*	TakesScreenshot oScn = ((TakesScreenshot) driver);
		    File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		    File oDest = new File(imagePath);*/
				 //Full page screen shot
		    Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		     ImageIO.write(fpScreenshot.getImage(),"PNG",new File(imagePath));
		 
		//    	FileUtils.copyFile(oScnShot, oDest);
		    } 
		    catch (IOException e) {
		    	System.out.println(e.getMessage());
		    }
		    	return imagePath;
		}
	    
	    public static String addScreenShot(WebDriver d, String imgpath) throws Exception {
			String image = "";
			FileInputStream imageFile;
			try {
				File imgfile = new File(captureScreen(d, imgpath));
				imageFile = new FileInputStream(imgpath);
	            byte imageData[] = new byte[(int) imgfile.length()];
	            imageFile.read(imageData);
	            byte[] base64EncodedByteArray = org.apache.commons.codec.binary.Base64.encodeBase64(imageData);
	            image = new String(base64EncodedByteArray);
		    }
			catch(Exception e) {
				e.printStackTrace();
			}
				return "data:image/png;base64,"+image;
		}
	    
	    
	    
	    public static String getBase64Screenshot() 
	    {
	    	return ((TakesScreenshot)WebDriverHandler.getInstance().getDriver()).getScreenshotAs(OutputType.BASE64);
	    }
	    
	    
	    /**
	     * 
	     * @param status
	     * @param element
	     * @param description
	     */
	    public static synchronized void logEventToReport(String status, Object element, String description){
			try {
				if(status.equalsIgnoreCase("pass")) {
					ExtentTestManager.getTest().log(Status.PASS, "["+element+"] - <span style='color:green'>"+StringUtils.capitalize(description)+"</span>"+" [browser thread-id: "+Thread.currentThread().getId()+"]");
				}
				else if(status.equalsIgnoreCase("fail")) {
					ExtentTestManager.getTest().log(Status.FAIL, "["+element+"] - <span style='color:red'>"+StringUtils.capitalize(description)+"</span>"+" [browser thread-id: "+Thread.currentThread().getId()+"]");
					ExtentTestManager.getTest().fail("screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
					//ExtentTestManager.getTest().log(Status.INFO, ExtentTestManager.getTest().addScreenCaptureFromBase64String(description).toString());
				}
				else if(status.equalsIgnoreCase("error")) {
					ExtentTestManager.getTest().log(Status.ERROR, description);
					ExtentTestManager.getTest().error("screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
					//ExtentTestManager.getTest().log(Status.INFO, ExtentTestManager.getTest().addScreenCaptureFromBase64String(description).toString());
					
				}
			} catch (Exception e) {
				System.out.println("error block report");
				if(status.equalsIgnoreCase("fail")||status.equalsIgnoreCase("error")) {
				ExtentTestManager.getTest().log(Status.FAIL, "Log expection block : "+ "Object Name :" +element +"Description : "+description);
				//ExtentTestManager.getTest().addScreenCaptureFromBase64String(addScreenShot(WebDriverManager.getDriver(), "./image"+Thread.currentThread().getId()+".png"), description);
				}else {
					ExtentTestManager.getTest().log(Status.INFO, "Log expection block : "+ "Object Name :" +element +"Description : "+description);
					ExtentTestManager.getTest().log(Status.INFO, element.toString());
				}
				e.printStackTrace();
			}
		}	
	    
	    
	    
	    
	    /**
	     * 
	     * @param status
	     * @param element
	     * @param description
	     */
	    public static synchronized void screeshortForFinalVerification(String status, Object element, String description){
			try {
				if(status.equalsIgnoreCase("pass")) {
					ExtentTestManager.getTest().log(Status.PASS, "["+element+"] - <span style='color:green'>"+StringUtils.capitalize(description)+"</span>"+" [browser thread-id: "+Thread.currentThread().getId()+"]");
					ExtentTestManager.getTest().pass("screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());
					
				}
				
			} catch (Exception e) {
					ExtentTestManager.getTest().log(Status.INFO, "verification is not done successfully: "+ "Object Name :" +element +"Description : "+description);
			}
		}	
	    
	    
	    
	    
	    
	    
	    
	    
}
