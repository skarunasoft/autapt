package com.aptemui.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverHandler {

	private static WebDriverHandler instance = new WebDriverHandler();

	public static WebDriverHandler getInstance() {
		return instance;
	}

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<WebDriverWait>();


	public synchronized WebDriver getDriver() {
		return driver.get();
	}

	public static synchronized void setDriver(WebDriver driverInput) {
		driver.set(driverInput);
	}

	public synchronized WebDriverWait getWebDriverWait() {
		return webDriverWait.get();
	}

	public synchronized void setWebDriverWait(WebDriverWait driverWait) {
		webDriverWait.set(driverWait);
	}

	public synchronized void closeBrowser() {
		driver.get().close();
	}
	
	public synchronized void quitBrowser() {
		try {
			if(getDriver() != null) 
			{
				getDriver().quit();
				driver.remove();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("driver not quit: "+getDriver());
		}
		
	}

}
