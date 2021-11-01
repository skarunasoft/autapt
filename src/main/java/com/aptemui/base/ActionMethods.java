package com.aptemui.base;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aptemui.extent.ExtentTestManager;
import com.aptemui.pages.SignInPageObject;




public class ActionMethods{
	
	protected WebDriver driver;
	protected WebDriverWait driverWait;
	private Actions action;
	public ActionMethods() {
		driver = WebDriverHandler.getInstance().getDriver();	
		System.out.println("action method"+driver);
		action = new Actions(driver);
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		if (WebDriverHandler.getInstance().getWebDriverWait() == null) {
			WebDriverHandler.getInstance().setWebDriverWait(driverWait);
		}
	}
	
	/**
	 * 
	 * @param url
	 * @return
	 */
	public boolean getUrl(String url)
	{
		boolean flag=false;
		try {
		//	urlConnectionVerification(url);
			driver.get(url);
			ExtentTestManager.logEventToReport("pass", url, " is opened successfully");
			flag=true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", url, e.getMessage());
			e.printStackTrace();
		}
		return flag;
		
	}
	
	
	
	public boolean urlConnectionVerification(String url)
	{
		boolean flag=false;
		try {
			HttpURLConnection c=(HttpURLConnection)new URL(url).openConnection();
				      // set the HEAD request with setRequestMethod
				      c.setRequestMethod("HEAD");
				      // connection started and get response code
				      c.connect();
				      int r = c.getResponseCode();
				      ExtentTestManager.logEventToReport("pass", url, " Http response code: "+r);
				      flag=true;
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (ProtocolException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return flag;
		
		
	}
	
	
	
	
	/**
	 * 
	 * @param inseconds
	 */
	public void waitFor(String inseconds) {
		try {
			Thread.sleep(Integer.parseInt(inseconds + "000"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean waitForElementVisible(WebElement element) {
		boolean elementPresent = false;
		try {
			driverWait.until(ExpectedConditions.visibilityOf(element));
			new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(InvalidElementStateException.class)
					.ignoring(NoSuchElementException.class);
			ExtentTestManager.logEventToReport("pass", element, "Element Visible and Stable");
			elementPresent = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		} 
		return elementPresent;
	}
	
	
	
	/**
	 * 
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public boolean waitForElementVisibleByXPath(String xpath) {
		boolean elementPresent = false;
		try {
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(InvalidElementStateException.class)
					.ignoring(NoSuchElementException.class);
			ExtentTestManager.logEventToReport("pass", xpath, " XPath Found And Returned");
			elementPresent = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", xpath, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		} 
		return elementPresent;
	}
	
	/**
	 * 
	 * @param xpath
	 * @return
	 * @throws Exception
	 */
	public boolean elementNOTVisibleByXPath(String xpath) {
		boolean elementPresent = false;
		try {
			driverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			new WebDriverWait(driver, Duration.ofSeconds(30)).ignoring(InvalidElementStateException.class)
					.ignoring(NoSuchElementException.class);
			ExtentTestManager.logEventToReport("pass", xpath, " XPath NOT Found");
			elementPresent = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", xpath, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		} 
		return elementPresent;
	}

	
	
	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean waitForAllElementsWithoutLog(List<WebElement> element) throws Exception {
		boolean elementPresent = false;
		try {
			
			if (driverWait
					.until(ExpectedConditions.visibilityOfAllElements(element)) != null) {
				elementPresent = true;
			}
			return elementPresent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementPresent;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean scrollInto(WebElement element) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			ExtentTestManager.logEventToReport("pass", element, " element scrolled successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();	
			}
		return flag;
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean scrollIntoDown() throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,550)");
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			ExtentTestManager.logEventToReport("pass", "", " element scrolled successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", "", e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();	
			}
		return flag;
	}
	
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean click(WebElement element) {
		
		boolean flag = false;
		try {
			if (waitForElementVisible(element)) {
				scrollInto(element);
				driverWait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				ExtentTestManager.logEventToReport("pass", element, "element clicked successfully");
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
		}
		return flag;  
	}
	
	
	/**
	 * 
	 * @param element
	 * @param text
	 * @return
	 */
	public boolean typeText(WebElement element, Object text){
		
		boolean flag = false;
		try {
			driverWait.until(ExpectedConditions.visibilityOf(element));
			action.moveToElement(element).build().perform();// Focus on element
			element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE) + text);
			ExtentTestManager.logEventToReport("pass", element, "typed text: "+text+" successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
			
			}
		return flag;
	}
	
	
	
	protected boolean clickOnElementJs(WebElement element) {
		boolean flag = false;
		try {
			if (waitForElementVisible(element)) {
				driverWait.until(ExpectedConditions.elementToBeClickable(element));
				JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("window.scrollTo(" + element.getLocation().x + "," + element.getLocation().y + ")");
				js.executeScript("arguments[0].click();", element);
				ExtentTestManager.logEventToReport("pass", element, "element clicked successfully by JavascriptExecutor");
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
		}
		return flag;
	}
	
	
	
	
	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public String getText(WebElement element) throws Exception{
		try {
			waitForElementVisible(element);
			return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element);
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
			throw new Exception("Unable to retreive value " + e);
		}
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public String getTextFromElement(WebElement element)  {
		String text = "";
		try {
			driverWait.until(ExpectedConditions.visibilityOf(element));
			text = element.getText();
			ExtentTestManager.logEventToReport("pass", element, " Found Text:"+text);
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();	
			}
		return text;
	}
	
	
	
	
	protected String getCSSValue(WebElement element, String propertyName) throws Exception {
		String cssValue = null;
		try {
			waitForElementVisible(element);
			scrollInto(element);
			cssValue=element.getCssValue(propertyName);
			ExtentTestManager.logEventToReport("pass", element, " css property: :"+propertyName+" css value: "+cssValue);
			
			
		} catch (Exception e)
		{
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();	
			}
			

	return cssValue;
	}
	
	protected boolean triggerKeyEvent(WebElement element, Keys key) throws Exception {
		boolean flag = true;
		try {
			action.moveToElement(element).sendKeys(key).build().perform();
			ExtentTestManager.logEventToReport("pass", element, key + " Event Triggered");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage());
		}
		return flag;
	}
	
	
	/**
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public boolean navigate(String url) {

		boolean flag = false;
		try {
			driver.navigate().to(url);
			ExtentTestManager.logEventToReport("pass", url, " navigated successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", url, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
			}
		return flag;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean refresh() {

		boolean flag = false;
		try {
			driver.navigate().refresh();
			ExtentTestManager.logEventToReport("pass", "Page refresh", " successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", "Page refresh not successfully", e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
			}
		return flag;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean navigateBack() {

		boolean flag = false;
		try {
			driver.navigate().back();;
			ExtentTestManager.logEventToReport("pass", "Page navigated back", " successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", "Page navigated back not successfully", e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
			}
		return flag;
	}
	
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean clickAndReturnToParent(WebElement element) {
		boolean flag = false;
		try {
			String parentwindow = driver.getWindowHandle();
			if (click(element)) {
				Set<String> windowhandles = driver.getWindowHandles();
				for (String windowHandle : windowhandles) {
					driver.switchTo().window(windowHandle);
				}
				driver.close();
				driver.switchTo().window(parentwindow);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 
	 * @param element
	 * @param verifyURL
	 * @return
	 */
	public boolean verifyNewTabWindowOfClickAndVerifyElement(
			String disableORenableComplianceDocuments,
			//WebElement url,
			WebElement testLearner,
			WebElement toggelTiles,
			WebElement programmes,
			WebElement editPencilIcon,
			WebElement complianceDocumentsIsDisplayed,
			WebElement complianceDocuments,
			WebElement enabledButton,
			WebElement confirmButtonForComplianceDocuments,
			WebElement confirmButton
			
			)
	{
		boolean flag = false;
		String newWindowURL=null;
		String currentUrl=null;
		try {
			//Assert.assertEquals(true, click(url));
			List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
			//currentUrl = driver.getCurrentUrl();
			//if (browserTabs.size() > 1) 
			//{
				//driver.switchTo().window(browserTabs.get(1));
				//newWindowURL = driver.getCurrentUrl();
				//ExtentTestManager.logEventToReport("pass", newWindowURL, " new url navigated successfully");
				
				
				Assert.assertEquals(true,click(testLearner));
				Assert.assertEquals(true,click(toggelTiles));
				Assert.assertEquals(true,click(programmes));
				Assert.assertEquals(true,click(editPencilIcon));
				
				
				if(disableORenableComplianceDocuments.equalsIgnoreCase("disable"))
				{
					
					ExtentTestManager.logEventToReport("pass", "requested Compliance Documents:",  "disable");
					if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==true)
					{
						Assert.assertEquals(true,click(complianceDocuments));
						Assert.assertEquals(true,click(enabledButton));
						Assert.assertEquals(true,click(confirmButtonForComplianceDocuments));
						Assert.assertEquals(true,click(confirmButton));
						ExtentTestManager.logEventToReport("pass", "Compliance document is disabled now",  ""+Thread.currentThread().getId());
					
						
					}
					else if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==false)
					{
						
						ExtentTestManager.logEventToReport("pass", "Compliance document is disabled already",  ""+Thread.currentThread().getId());
					
					}
				
				}
				if(disableORenableComplianceDocuments.equalsIgnoreCase("enable"))
				{
					ExtentTestManager.logEventToReport("pass", "requested Compliance Documents:",  "disable");
					if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==false)
					{
						Assert.assertEquals(true,click(complianceDocuments));
						Assert.assertEquals(true,click(enabledButton));
						Assert.assertEquals(true,click(confirmButtonForComplianceDocuments));
						Assert.assertEquals(true,click(confirmButton));
						ExtentTestManager.logEventToReport("pass", "Compliance document is enabled now",  ""+Thread.currentThread().getId());
					
						
					}
					else if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==true)
					{
						
						ExtentTestManager.logEventToReport("pass", "Compliance document is enabled already",  ""+Thread.currentThread().getId());
					
					}
				
				}
				
				
				
				
				
			//	driver.close();
			//	driver.switchTo().window(browserTabs.get(0));
				flag=true;
			//}
		} catch (Exception e) {
		//	ExtentTestManager.logEventToReport("error", url, e.getMessage() + Thread.currentThread().getId());
			ExtentTestManager.logEventToReport("error", newWindowURL, e.getMessage() + Thread.currentThread().getId());
			//e.printStackTrace();
		} finally {
			driver.switchTo().defaultContent();
		//	ExtentTestManager.logEventToReport("pass", currentUrl, "default url navigated successfully");
		}
		return flag;
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param element
	 * @param verifyURL
	 * @return
	 */
	
	// for third scenarios
	public boolean verifyNewTabWindowOfClickAndVerifyElementForLearnerProgramme(
			String disableORenableComplianceDocuments,
			String name,
			//WebElement url,
			WebElement testLearner,
			WebElement toggelTiles,
			WebElement programmes,
			WebElement editPencilIcon,
			WebElement editPencilIconForLearnerProgramme,
			WebElement complianceDocumentsIsDisplayed,
			WebElement complianceDocuments,
			WebElement enabledButton,
			WebElement confirmButtonForComplianceDocuments,
			WebElement confirmButton,
			WebElement add,
			WebElement text,
			WebElement templateSelectOne,
			WebElement CommitmentStatement,
			WebElement templateSelectTwo,
			WebElement corndelApprenticeshipAgreement,
			WebElement apply,
			WebElement warningYesButton,
			WebElement forDeleteComplianceDocument,
			List<WebElement> deleteDocuments,
			WebElement confirmYesDeleteDocuments
			)
	{
		
		System.out.println("request2"+ disableORenableComplianceDocuments);
		boolean flag = false;
		//String newWindowURL=null;
		//String currentUrl=null;
		try {
			//Assert.assertEquals(true, click(url));
		//	List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
		//	currentUrl = driver.getCurrentUrl();
		//	if (browserTabs.size() > 1) {
		//		driver.switchTo().window(browserTabs.get(1));
			//	newWindowURL = driver.getCurrentUrl();
			//	ExtentTestManager.logEventToReport("pass", newWindowURL, " new url navigated successfully");
				Assert.assertEquals(true,click(testLearner));
				Assert.assertEquals(true,click(toggelTiles));
				Assert.assertEquals(true,click(programmes));
				Assert.assertEquals(true,click(editPencilIcon));
				//System.out.println("request3"+ disableORenableComplianceDocuments);
				
			//	{
					ExtentTestManager.logEventToReport("pass", "requested Compliance Documents:",  "enable");
					if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==false)
					{
						ExtentTestManager.logEventToReport("pass", "Compliance document is disabled, Start to enable",  ""+Thread.currentThread().getId());
						Assert.assertEquals(true,click(complianceDocuments));
						Assert.assertEquals(true,click(enabledButton));
						Thread.sleep(3000);
						Assert.assertEquals(true,click(confirmButtonForComplianceDocuments));
						Thread.sleep(6000);
						Assert.assertEquals(true,click(confirmButton));
						ExtentTestManager.logEventToReport("pass", "Compliance document is enabled now",  ""+Thread.currentThread().getId());
					
						
					}
					else if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==true)
					{
						Assert.assertEquals(true, navigateBack());
						ExtentTestManager.logEventToReport("pass", "Compliance document is enabled already",  ""+Thread.currentThread().getId());
					
					}
				
			//	}
				
				Assert.assertEquals(true,click(editPencilIconForLearnerProgramme));
				
				if(disableORenableComplianceDocuments.equalsIgnoreCase("enable"))
				{
					ExtentTestManager.logEventToReport("pass", "requested Compliance Documents:",  "enable");
					if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==false)
					{
						ExtentTestManager.logEventToReport("pass", "Compliance document is disabled, Start to enable",  ""+Thread.currentThread().getId());
						Assert.assertEquals(true,click(complianceDocuments));
						Assert.assertEquals(true,click(enabledButton));
						Thread.sleep(3000);
						Assert.assertEquals(true,click(confirmButtonForComplianceDocuments));
						Thread.sleep(6000);
						Assert.assertEquals(true,click(confirmButton));
						
						
//						Assert.assertEquals(true,deleteAllComplianceDocuments(forDeleteComplianceDocument, deleteDocuments, confirmYesDeleteDocuments));
//						Assert.assertEquals(true,click(add));
//						 Assert.assertEquals(true,typeText(text, name));
//						 Assert.assertEquals(true, triggerKeyEvent(text, Keys.TAB));
//						 Assert.assertEquals(true,click(templateSelectOne));
//						 Assert.assertEquals(true,click(CommitmentStatement));
//						Assert.assertEquals(true,click(apply));
//						
//						
//						Thread.sleep(3000);
//						Assert.assertEquals(true,click(confirmButtonForComplianceDocuments));
//						Thread.sleep(6000);
//						Assert.assertEquals(true,click(confirmButton));
//						Assert.assertEquals(true,click(warningYesButton));
						ExtentTestManager.logEventToReport("pass", "Compliance document is enabled now",  ""+Thread.currentThread().getId());
					
						
					}
					else if(verifyElementIsDisplayedORNot(complianceDocumentsIsDisplayed)==true)
					{
						ExtentTestManager.logEventToReport("pass", "Compliance document is enabled already",  ""+Thread.currentThread().getId());
//						Assert.assertEquals(true,click(complianceDocuments));
//						Assert.assertEquals(true,deleteAllComplianceDocuments(forDeleteComplianceDocument, deleteDocuments, confirmYesDeleteDocuments));
//						Assert.assertEquals(true,click(add));
//						 Assert.assertEquals(true,typeText(text, name));
//						 Assert.assertEquals(true, triggerKeyEvent(text, Keys.TAB));
//						 Assert.assertEquals(true,click(templateSelectOne));
//						 Assert.assertEquals(true,click(CommitmentStatement));
//						Assert.assertEquals(true,click(apply));
//						Thread.sleep(3000);
//						Assert.assertEquals(true,click(confirmButtonForComplianceDocuments));
//						Thread.sleep(6000);
//						Assert.assertEquals(true,click(confirmButton));
//						Assert.assertEquals(true,click(warningYesButton));
						
					
					}
				
				}
				
				
				
				
				
				//driver.close();
			//	driver.switchTo().window(browserTabs.get(0));
				flag=true;
			//}
		} catch (Exception e) {
		//	ExtentTestManager.logEventToReport("error", url, e.getMessage() + Thread.currentThread().getId());
			ExtentTestManager.logEventToReport("error", "", e.getMessage() + Thread.currentThread().getId());
			//e.printStackTrace();
		}
		//finally {
		//driver.switchTo().defaultContent();
			//ExtentTestManager.logEventToReport("pass", currentUrl, "default url navigated successfully");
		//}
		return flag;
	}
	
	
	
	public boolean deleteAllComplianceDocuments(WebElement forDeleteComplianceDocument, List<WebElement> deleteDocuments, WebElement confirmYesDeleteDocuments)
	{
		boolean flag=false;
		try {
			if(verifyElementIsDisplayedORNot(forDeleteComplianceDocument)==true) 
			{
				ExtentTestManager.logEventToReport("pass", forDeleteComplianceDocument, " presented");
			for (WebElement deleteDoc : deleteDocuments) {
				
				Assert.assertEquals(true,click(deleteDoc));
				Assert.assertEquals(true,click(confirmYesDeleteDocuments));
			}
			flag=true;
			}
			else {
				flag=true;
				ExtentTestManager.logEventToReport("pass", forDeleteComplianceDocument, " not presented presented");
				
			}
		} catch (NoSuchElementException e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	
	
	public boolean switchToSignFrameWindow(WebElement frame, WebElement sign) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(3000);
			driver.switchTo().frame(frame);
			Assert.assertEquals(true, click(sign));
			driver.switchTo().defaultContent();
			ExtentTestManager.logEventToReport("pass", frame, "Switch To frame successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", frame, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 
	 * @param drpObject
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public boolean selectValueFromDropdown(List<WebElement> drpObject, String value) throws Exception {
		boolean result = false;
		try {
			driverWait.until(ExpectedConditions.visibilityOfAllElements(drpObject));
			for (WebElement webElement : drpObject) {
				if (webElement.getText().equalsIgnoreCase(value)) {
					result = click(webElement);
					Thread.sleep(5000);
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
/**
 * 
 * @param element
 * @param value
 * @return
 * @throws Exception
 */
	public boolean selectByVisibleText(WebElement element, String value)  {
		boolean flag = false;
		try {
			waitForElementVisible(element);
			Select select = new Select(element);
			waitForAllElementsWithoutLog(select.getOptions());
			select.selectByVisibleText(value);
			ExtentTestManager.logEventToReport("pass", element, value+" selected by visible text");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		}
		
		return flag;
	}
/**
 * 
 * @param element
 * @param index
 * @return
 * @throws Exception
 */
	public boolean selectByIndex(WebElement element, int index) throws Exception {
		boolean flag = false;
		try {
			waitForElementVisible(element);
			Select select = new Select(element);
			waitForAllElementsWithoutLog(select.getOptions());
			select.selectByIndex(index);
			ExtentTestManager.logEventToReport("pass", element, index+" selected by index");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		}
		return flag;
	}
/**
 * 
 * @param element
 * @param value
 * @return
 * @throws Exception
 */
	public boolean selectByValue(WebElement element, String value) throws Exception {
		boolean flag = false;
		try {
			waitForElementVisible(element);
			Select select = new Select(element);
			//waitForAllElementsWithoutLog(select.getOptions());
			select.selectByValue(value);
			waitFor("4");
			ExtentTestManager.logEventToReport("pass", element, value+" selected by value");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		} 
		return flag;
	}
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	
	protected boolean mouseOverandClick(WebElement element) {
		boolean flag = false;
		try {
			waitForElementVisible(element);
			action.moveToElement(element).build().perform();
			element.click();
			ExtentTestManager.logEventToReport("pass", element, " Element moved and clicked successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		}
		return flag;
	}
/**
 * 
 * @param element1
 * @param element2
 * @return
 * @throws Exception
 */
	public boolean mouseOverandClick(WebElement element1, WebElement element2) {
		boolean flag = false;
		try {
			waitForElementVisible(element1);
			action.moveToElement(element1).build().perform();
			ExtentTestManager.logEventToReport("pass", element1, "Element moved successfully");
			waitForElementVisible(element2);
			Thread.sleep(4000);
			element2.click();
			ExtentTestManager.logEventToReport("pass", element2, "Element clicked successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element1, e.getMessage() + Thread.currentThread().getId());
			ExtentTestManager.logEventToReport("error", element2, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @throws Exception
	 */
	public boolean mouseOver(WebElement element) throws Exception {
		boolean flag = false;
		try {
			waitForElementVisible(element);
			action.moveToElement(element).build().perform();	
			ExtentTestManager.logEventToReport("pass", element, "Element moved successfully");
			flag = true;
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
		}
		return flag;
	}
	
/**
 * 
 * @param element
 * @return
 * @throws Exception
 */
	public boolean isElementPresent(WebElement element) throws Exception {
		boolean flag = false;
		try {
			scrollIntoWithoutLog(element);
			waitForElementVisible(element);
			element.isDisplayed();
			ExtentTestManager.logEventToReport("pass", element, "Element is present and visible successfully");
			flag = true;

		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
			throw new Exception("Unable to determine if the element is present.", e);
		}
		return flag;
	}
/**
 * 
 * @param element
 * @return
 * @throws Exception
 */
	public boolean scrollIntoWithoutLog(WebElement element) throws Exception {
		boolean flag = false;
		try {
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 
	 * @param xpathExpression
	 * @return
	 * @throws Exception
	 */
	public WebElement waitAndReturnElementPresentByXPath(String xpathExpression){
		WebElement element = null;
		try {
			System.out.println("Before wait time :   "
					+ new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime()));
			element = driverWait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
			System.out.println("After success wait time :   "
					+ new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime()));
			ExtentTestManager.logEventToReport("pass", xpathExpression, " XPath found and visible with wait");
		} catch (StaleElementReferenceException ste) {
			waitAndReturnElementPresentByXPath(xpathExpression);
		} catch (Exception e) {
			ExtentTestManager.logEventToReport("error", element, e.getMessage() + Thread.currentThread().getId());
			e.printStackTrace();
			System.out.println(
					"After wait time :   " + new SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().getTime()));
		}
		return element;
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	protected boolean isFilePresent(String filePath, String fileExtn){
		boolean flag = false;
		File file = new File(filePath);
		try {
			waitingForFile(filePath, fileExtn);
			if (file.exists() && (filePath.length() > 1)) {
				ExtentTestManager.logEventToReport("pass", filePath, "Found");
				flag = true;
			} else {
				ExtentTestManager.logEventToReport("fail", filePath, "Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ExtentTestManager.logEventToReport("error", filePath, "Not Found"+e.getMessage());
		}
		return flag;
	}
	
	
protected void waitingForFile(String filePath, String fileExtn){
		
		File currentFile = new File(filePath);
		if(currentFile.getPath().endsWith(fileExtn)) {
			waitFor("10");
			ExtentTestManager.logEventToReport("pass", "Waiting for file", "File extenstion is "+fileExtn);
		
		}
		else {
			ExtentTestManager.logEventToReport("fail", "Waiting for file", "File extenstion is not "+fileExtn);
		}
	
	}	
	
	

protected boolean deleteDirectory(String filePath)
{
	boolean flag=false;
	try {
		FileUtils.deleteDirectory(new File(filePath));
		ExtentTestManager.logEventToReport("pass", filePath, "directory deleted successfully");
		flag=true;
	} catch (IOException e) {
		ExtentTestManager.logEventToReport("fail", filePath, "directory not deleted"+e.getMessage());
		e.printStackTrace();
	}
		return flag;

}




protected boolean alertHandling(WebElement element, String text){
	boolean flag = false;
	try {
		element.click();
		driverWait.ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		// Thread.sleep(3000);
		if (text.equalsIgnoreCase("accept")) {
			alert.accept();
			ExtentTestManager.logEventToReport("Pass", element, "Alert Accepted");
			flag = true;
		} else if (text.equalsIgnoreCase("dismiss")) {
			alert.dismiss();
			ExtentTestManager.logEventToReport("Pass", element, "Alert Dismissed");
			flag = true;
		}
	} catch (Exception e) {
		ExtentTestManager.logEventToReport("error", "Alert", e.getMessage());
	}
	return flag;
}





public  static String getSaltString() {
	String SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
	StringBuilder salt = new StringBuilder();
	Random rnd = new Random();
	while (salt.length() < 7) 
	{
		// length of the random string.
		int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		salt.append(SALTCHARS.charAt(index));
	}
	String saltStr = salt.toString();
	System.out.println("salt string: "+ saltStr);
	return saltStr;

}

public  static String getRandomNumbers() {
	String SALTCHARS = "1234567890";
	StringBuilder salt = new StringBuilder();
	Random rnd = new Random();
	while (salt.length() < 5) 
	{
		// length of the random string.
		int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		salt.append(SALTCHARS.charAt(index));
	}
	String saltStr = salt.toString();
	return saltStr;

}


protected boolean verifyElementIsDisplayedORNot(WebElement element) {
	boolean flag=false;
	try
	{
		 element.isDisplayed();
		 flag=true;
		 ExtentTestManager.logEventToReport("Pass", element, " is displayed");
	
	}
	catch(NoSuchElementException e) {
		flag=false;
		ExtentTestManager.logEventToReport("Pass", element, " is not displayed");
	}
		
	return flag;
	
}



/*
 * protected boolean verifyElementIsDisplayedORNot(List<WebElement> elements) {
 * boolean flag=false;
 * 
 * if(elements.size() >=1) { flag=true; }
 * 
 * else { flag=false;
 * 
 * } return flag; }
 */






	
}
