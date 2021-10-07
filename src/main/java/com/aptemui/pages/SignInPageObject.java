package com.aptemui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aptemui.base.ActionMethods;


public class SignInPageObject extends ActionMethods{
	
	@FindBy(id="username-email")
	private WebElement username;
	
	
	@FindBy(id="enterLogin")
	private WebElement nextButton;
	
	
	@FindBy(xpath="//*[text()[normalize-space()='Available tenants']]/../div/span")
	private WebElement availableTenants;
	
	@FindBy(xpath="//li[text()='Default']")
	private WebElement defaulTenant;
	
	@FindBy(id="tenantSelected")
	private WebElement tenantSelectedNextButton;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="btnSignIn")
	private WebElement signInButton;
	
	@FindBy(xpath="//input[@name='Name']")
	private WebElement searchTenant;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement searchButton;
	
	
	/**
	 * 
	 * new windows object
	 */
	
	@FindBy(xpath="//*[contains(text(), 'laxmi')]/..//td/a[text()='Test Learner1']")
	private WebElement testLearner1Link;

	@FindBy(xpath="//i[@class='toggleTilesBtn-inner']")
	private WebElement toggelTiles;
	
	@FindBy(xpath="//span[text()='Programmes']/..")
	private WebElement programmes;
	
	@FindBy(xpath="//*[contains(text(), 'Account programme for Laxmi Test Tenant')]/../../../td/a")
	private WebElement editPencilIcon;
	
	
	@FindBy(xpath="//*[text()='Compliance documents']/../div[@class='indicator']")
	private WebElement complianceDocumentsIndicator;
	
	
	@FindBy(xpath="//div[text()='Compliance documents']/../input[@data-checked='true']")
	private WebElement complianceDocumentsIsDisplayed;
	
	@FindBy(xpath="//div[text()='Compliance documents']/../input[@data-checked='true']/..")
	private WebElement complianceDocumentsClick;
	
	@FindBy(css="#ecompliance-documents-editor > div.header > div.toggle > label")
	private WebElement enabledButton;
	
	@FindBy(css="#ecompliance-documents-editor > div.bottom > div.confirmBtn.btn.clear-fix")
	private WebElement confirmButtonForComplianceDocuments;
	
	
	@FindBy(css="#workspace > form > div.mainButtons > input.confirmBtn.btn")
	private WebElement confirmButton;
	
	
	
	/**
	 * @learner account properties
	 * 
	 */
	
	@FindBy(id="userName")
	private WebElement learnerUsername;
	
	@FindBy(id="password")
	private WebElement learnerPassword;
	
	@FindBy(id="btn-login")
	private WebElement learnerSignInButton;
	
	
	
	@FindBy(css="#menu-learner>nav")
	private WebElement sideMenu;
	
	@FindBy(xpath="//*[text()='Learning Plan']/../..")
	private WebElement learningPlanLink;
	
	
	
	
	
	
	public SignInPageObject(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public SignInPageObject enterUsername(String username)
	{
		Assert.assertEquals(true,typeText(this.username,username));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickNext()
	{
		Assert.assertEquals(true,click(nextButton));
		return new SignInPageObject(driver);
	}

	public SignInPageObject clickTenant()
	{
		Assert.assertEquals(true,click(availableTenants));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickDefaultTenant()
	{
		Assert.assertEquals(true,click(defaulTenant));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickNextAfterSelectedTenant()
	{
		Assert.assertEquals(true,click(tenantSelectedNextButton));
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject enterPassword(String password)
	{
		Assert.assertEquals(true,typeText(this.password,password));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickSignInButton()
	{
		Assert.assertEquals(true,click(signInButton));
		return new SignInPageObject(driver);
	}
	public SignInPageObject searchTenant(String tenant)
	{
		Assert.assertEquals(true,typeText(searchTenant,tenant));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickTenantSearchButton()
	{
		Assert.assertEquals(true,click(searchButton));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickTenantURLLink(String tenantName)
	{
		
		WebElement url =waitAndReturnElementPresentByXPath("//a[contains(text(), '"+tenantName+".test.aptem.co.uk')]");
		
		Assert.assertEquals(true,
				verifyNewTabWindowOfClickAndVerifyElement(
						"disable",
						url,
						testLearner1Link,
						toggelTiles,
						programmes,
						editPencilIcon,
						complianceDocumentsIsDisplayed,
						complianceDocumentsClick,
						enabledButton,
						confirmButtonForComplianceDocuments,
						confirmButton
						)
				);
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject navigateToLearnersAccount(String url)
	{
		Assert.assertEquals(true, navigate(url));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject signInLearnerAccount(String username, String password)
	{
		Assert.assertEquals(true,typeText(learnerUsername, username));
		Assert.assertEquals(true,typeText(learnerPassword, password));
		Assert.assertEquals(true,click(learnerSignInButton));
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject clickSideMenuAndLearningPlan()
	{
		Assert.assertEquals(true, mouseOverandClick(sideMenu, learningPlanLink));
		return new SignInPageObject(driver);
	}
		
	public SignInPageObject verifyContent(String content)
	{
		Assert.assertEquals(true, waitForElementVisibleByXPath("(//*[text()[normalize-space()='"+content+"']])[2]"));
		return new SignInPageObject(driver);
	}
	
	
}
