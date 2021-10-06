package com.aptemui.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlSuite;

import com.aptemui.extent.ExtentManager;
import com.aptemui.extent.ExtentTestManager;
import com.aptemui.pages.SignInPageObject;
import com.aptemui.utils.FileProvider;
import com.aptemui.utils.ResourceHandler;
import com.aventstack.extentreports.Status;


import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseDriver {

	public static WebDriver driver;
	private ImmutableCapabilities capabilities = null;
	public SignInPageObject signInPageObject;
	public static XmlSuite suite;
	/**
	 * 
	 * @param runMode
	 * @param browser
	 * @return
	 * @throws IOException
	 */
	public WebDriver createBrowserInstance(String runMode, String browser) throws IOException {
		try {
			if(runMode.equalsIgnoreCase("local")) 
			{
				 ExtentTestManager.logEventToReport("pass", "Test suite running mode in - ", runMode);
	
				if (browser.equalsIgnoreCase("Chrome"))
				{				
					ExtentTestManager.logEventToReport("pass", "Test suite running browser on - ", browser);
				
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeoptions = new ChromeOptions();
				if(ResourceHandler.getHeadlessMode()==true) {
					chromeoptions.setHeadless(ResourceHandler.getHeadlessMode());
					chromeoptions.addArguments("--window-size=1920,1080");
				}
				chromeoptions.addArguments("--start-maximized");				
				chromeoptions.addArguments("--disable-extensions");
				chromeoptions.addArguments("--disable-infobars");
				chromeoptions.addArguments("--disable-dev-shm-usage");
				chromeoptions.addArguments("--no-sandbox");
				chromeoptions.addArguments("--disable-features=VizDisplayCompositor");
				chromeoptions.addArguments("--dns-prefetch-disable");
				chromeoptions.addArguments("--disable-gpu");
				chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("hardware_acceleration_mode.enabled", false);
				chromePrefs.put("download.prompt_for_download", false);
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
				chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
				chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
				chromePrefs.put("profile.block_third_party_cookies", true);
				chromePrefs.put("download.default_directory", new File(FileProvider.DOWNLOADPATH).getAbsolutePath());
				chromeoptions.setExperimentalOption("prefs", chromePrefs);
				driver = new ChromeDriver(chromeoptions);
				//System.setProperty("org.freemarker.loggerLibrary", "auto");
			} else if (browser.equalsIgnoreCase("Firefox")) {
				ExtentTestManager.logEventToReport("pass", "Test suite ruuning browser on - ", browser);
				WebDriverManager.firefoxdriver().setup();
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("security.insecure_field_warning.contextual.enabled", false);
				profile.setPreference("signon.autofillForms.http", false);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				FirefoxOptions firefoxOptions = new FirefoxOptions(capabilities);
				firefoxOptions.addArguments("-headless");
				firefoxOptions.setProfile(profile);
				firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
				firefoxOptions.addPreference("browser.link.open_newwindow", 3);
				firefoxOptions.addPreference("browser.link.open_newwindow.restriction", 0);
				driver = new FirefoxDriver(firefoxOptions);
			}
				
			
				
			}
		
		
			  else if(runMode.equalsIgnoreCase("remote")) 
			  {
				  ExtentTestManager.logEventToReport("pass", "Test suite ruuning mode in - ", runMode);
			  
				
				  if (browser.equalsIgnoreCase("Chrome")) {
					  capabilities = new ImmutableCapabilities("browserName", "chrome");
							  
					} else if (browser.equalsIgnoreCase("Firefox")) {
						  capabilities = new ImmutableCapabilities("browserName", "firefox");
					} else if (browser.equalsIgnoreCase("ie")) {
						  capabilities = new ImmutableCapabilities("browserName", "ie");
						
					}
				  ExtentTestManager.logEventToReport("pass", "Test suite remote server - ", ResourceHandler.getPropValue("remote_server_ip"));
				  driver = new RemoteWebDriver(new URL(ResourceHandler.getPropValue("remote_server_ip")), capabilities);
				  
			  }
			 

			else {
				System.out.println("Invalid browser selection");
			}
		} catch (Exception e) {
			System.out.println("Browser launching error..." + e.getMessage());
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.FATAL, "Browser Close unexpectedly :"+e.getMessage());
		}

		return driver;

	}
	
	@BeforeMethod
	@Parameters({"testcaseid"})
	public synchronized void setUpBrowser(String testcaseid) throws IOException {
		ExtentTestManager.startTest("Aptem automation testcase id "+testcaseid+"is running");
		WebDriverHandler.getInstance();
		WebDriverHandler.setDriver(createBrowserInstance(ResourceHandler.getPropValue("run_mode"), ResourceHandler.getPropValue("browser")));
		driver = WebDriverHandler.getInstance().getDriver();
		System.out.println("driverrrrrrrr"+ driver);
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(ResourceHandler.getPropValue("app_url"));
		signInPageObject = new SignInPageObject(driver);
	}
	@AfterMethod
	public void closeApplication(ITestResult result) throws Exception {
		try {
			ExtentTestManager.getTest().log(Status.INFO, "<b>Browser is going to close</b>");
			System.out.println("After quit  :" + WebDriverHandler.getInstance().getDriver().toString());
			if (WebDriverHandler.getInstance().getDriver().toString().contains("null")) {
				System.out.println("check browser ");
				ExtentTestManager.getTest().log(Status.INFO, "<b>Browser is closed</b>");
			}
			//loginFlag = true;
			WebDriverHandler.getInstance().closeBrowser();
			ExtentTestManager.getTest().log(Status.INFO, "<b>After method is completed</b>");
			ExtentManager.getReporter().flush();
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
	}

	
	
	@AfterSuite
	public void closeDriver() throws Exception {
		try {
			
			WebDriverHandler.getInstance().quitBrowser();
			ExtentManager.getReporter().flush();
			System.out.println("After suite");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
