package com.aptemui.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aptemui.base.ActionMethods;
import com.aptemui.extent.ExtentTestManager;


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
	
	
	@FindBy(xpath="//*[contains(text(), 'Learner')]/../../../td/div[text()='Delivery']/../../td/a[contains(@href, 'Edit')]")
	private WebElement editPencilIconForLearnerProgramme;
	
	
	@FindBy(xpath="//*[text()='Compliance documents']/../div[@class='indicator']")
	private WebElement complianceDocumentsIndicator;
	
	
	@FindBy(xpath="//div[text()='Compliance documents']/../input[@data-checked='true']")
	private WebElement complianceDocumentsIsDisplayed;
	
	@FindBy(xpath="//input[@id='ComplianceDocumentsProgramPart_Part_IsIncluded']/..")
	private WebElement complianceDocumentsClick;
	
		
	@FindBy(css="#ecompliance-documents-editor > div.header > div.toggle > label")
	private WebElement enabledButton;
	
	//ori-@FindBy(css="#ecompliance-documents-editor > div.bottom > div.confirmBtn.btn.clear-fix")
	@FindBy(xpath="//*[@id='ecompliance-documents-editor']/div[3]/div[@data-role='but-ok']")
	private WebElement confirmButtonForComplianceDocuments;
	
	
	//ori-@FindBy(css="#workspace > form > div.mainButtons > input.confirmBtn.btn")
	@FindBy(xpath="//input[@value='Confirm']")
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
	
	@FindBy(xpath="//*[text()='Documents']/../..")
	private WebElement documentsMenuLink;
	
	@FindBy(xpath="//span[text()='Actions Required']/../../..")
	private WebElement actionsRequired;
	
	
	
	/**
	 * 
	 * @Compliance Documents Add properties
	 */
	@FindBy(xpath="//button[text()='Add']")
	private WebElement add;
	
	@FindBy(xpath="//input[@name='text']")
	private WebElement text;
	
	@FindBy(xpath="(//div[text()='None']/../select)[1]/../div")
	private WebElement templateSelectOne;
	
	@FindBy(xpath="//li[text()='CommitmentStatement']")
	private WebElement CommitmentStatement;
	
	@FindBy(xpath="(//div[text()='ApprenticeshipAgreement'])[2]")
	private WebElement templateSelectTwo;
	
	@FindBy(xpath="//li[text()='Corndel-ApprenticeshipAgreement']")
	private WebElement corndelApprenticeshipAgreement;
	
	
	@FindBy(xpath="(//button[text()='Apply'])[2]")
	private WebElement apply;
	
	@FindBy(xpath="//input[@value='Yes']")
	private WebElement warningYesButton;
	
	@FindBy(css="#complianceDocumentsEpisodesPanel > a")
	private WebElement complianceDocumentsRefresh;
	
	@FindBy(css="#complianceDocumentsEpisodesPanel > a")
	private WebElement expandComplianceDocuments;
	
	@FindBy(xpath="//td[contains(text(), 'Learner')]/preceding-sibling::td")
	private WebElement expandLearnersProgramme;
	
	@FindBy(xpath="//a[text()='Save']")
	private WebElement yesOfCommitmentStatement;

	
	
	
	
	@FindBy(xpath="(//div[@class='controls']/div[@class='tab-compliance-documents tab-user-compliance-documents']//div/a[@title='Delete'])[1]")
	private WebElement forDeleteComplianceDocument;
	
	@FindBy(xpath="//div[@class='controls']/div[@class='tab-compliance-documents tab-user-compliance-documents']//div/a[@title='Delete']")
	private List<WebElement> deleteDocuments;
	
	@FindBy(xpath="//input[@value='Yes']")
	private WebElement confirmYesDeleteDocuments;
	
			
	
	
	@FindBy(xpath="//span[text()='Review & Sign']/..")
	private WebElement reviewSign;
	
	@FindBy(xpath="//div[text()='Click here to sign']")
	private WebElement sign;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveReviewSign;
	
	
	
	
	
	
	
	/**
	 * 
	 * @param driver
	 */
	
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
	
	public SignInPageObject clickTenantURLLink(String tenantName, String disableORenable)
	{
		
		WebElement url =waitAndReturnElementPresentByXPath("//a[contains(text(), '"+tenantName+".test.aptem.co.uk')]");
		
		Assert.assertEquals(true,
				verifyNewTabWindowOfClickAndVerifyElement(
						disableORenable,
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
	
	
	public SignInPageObject clickTenantURLLinkForLearnerProgramme(String tenantName, String disableORenable, String name)
	{
		
		
		System.out.println("request1"+ disableORenable);
		
		WebElement url =waitAndReturnElementPresentByXPath("//a[contains(text(), '"+tenantName+".test.aptem.co.uk')]");
		
		Assert.assertEquals(true,
				verifyNewTabWindowOfClickAndVerifyElementForLearnerProgramme(
						disableORenable,
						name,
						url,
						testLearner1Link,
						toggelTiles,
						programmes,
						editPencilIcon,
						editPencilIconForLearnerProgramme,
						complianceDocumentsIsDisplayed,
						complianceDocumentsClick,
						enabledButton,
						confirmButtonForComplianceDocuments,
						confirmButton,
						add,
						text,
						templateSelectOne,
						CommitmentStatement,
						templateSelectTwo,
						corndelApprenticeshipAgreement,
						apply,
						warningYesButton,
						forDeleteComplianceDocument,
						deleteDocuments,
						confirmYesDeleteDocuments
						
						)
				);
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject navigateToLearnersAccount(String url)
	{
		Assert.assertEquals(true, navigate(url));
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		waitFor("5");
		Assert.assertEquals(true, mouseOverandClick(sideMenu, learningPlanLink));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickSideMenuAndDocuments()
	{
		waitFor("5");
		Assert.assertEquals(true, mouseOverandClick(sideMenu, documentsMenuLink));
		return new SignInPageObject(driver);
	}
		
	
	
	public SignInPageObject clickActionsRequired()
	{
		waitFor("10");
		Assert.assertEquals(true,click(actionsRequired));
		return new SignInPageObject(driver);
	}
	
	
	
	
	public SignInPageObject verifyContent(String content)
	{
		Assert.assertEquals(true, waitForElementVisibleByXPath("(//*[text()[normalize-space()='"+content+"']])[2]"));
		ExtentTestManager.screeshortForFinalVerification("pass", content,  " is displayed and verified successfully");
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject verifyContentNOTDisplayed(String content)
	{
		Assert.assertEquals(true, elementNOTVisibleByXPath("(//*[text()[normalize-space()='"+content+"']])[2]"));
		ExtentTestManager.screeshortForFinalVerification("pass", content,  " is NOT displayed and verified successfully");
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject clickRefreshIconOfComplianceDocuments()
	{
		try {
			Thread.sleep(10000);
			Assert.assertEquals(true, click(complianceDocumentsRefresh));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickCreateForLearnersProgramme(String value)
	{
		WebElement create = waitAndReturnElementPresentByXPath("//td[contains(text(), '"+value+"')]/../td/a[text()='Create']");
		Assert.assertNotEquals(null, create);
		Assert.assertEquals(true, click(create));
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject clickUpdateForLearnersProgramme(String value)
	{
		WebElement create = waitAndReturnElementPresentByXPath("//td[contains(text(), '"+value+"')]/../td/a[text()='Update']");
		Assert.assertNotEquals(null, create);
		Assert.assertEquals(true, click(create));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickYesOfCommitmentStatement()
	{
		Assert.assertEquals(true, click(yesOfCommitmentStatement));
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject clickReviewSign()
	{
		Assert.assertEquals(true, click(reviewSign));
		return new SignInPageObject(driver);
	}
	
	public SignInPageObject clickSign(String value)
	{
		try {
			Thread.sleep(10000);
			WebElement create = waitAndReturnElementPresentByXPath("//p[text()='"+value+"']/following-sibling::div");
			Assert.assertNotEquals(null, create);
			
			Assert.assertEquals(true, click(create));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new SignInPageObject(driver);
	}
	
	
	
	
	
	
	
	
	@FindBy(xpath="//iframe")
	private WebElement frameSignInWindow;
	public SignInPageObject switchToSignWindowAndClickHereToSign()
	{
		try {
			Thread.sleep(10000);
			Assert.assertEquals(true, switchToSignFrameWindow(frameSignInWindow, sign));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject clickSaveForReviewSign()
	{
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, click(saveReviewSign));
		return new SignInPageObject(driver);
	}
	
	
	public SignInPageObject pageRefresh()
	{
		Assert.assertEquals(true, refresh());
		waitFor("5");
		return new SignInPageObject(driver);
	}
	
	/*
	 * public SignInPageObject clickAdd() { Assert.assertEquals(true,click(add));
	 * return new SignInPageObject(driver); }
	 * 
	 * public SignInPageObject enterName(String name) {
	 * Assert.assertEquals(true,typeText(text, name)); return new
	 * SignInPageObject(driver); }
	 * 
	 * public SignInPageObject selectTemplateFirst(String template) {
	 * Assert.assertEquals(true, selectByVisibleText(templateSelectOne, template));
	 * return new SignInPageObject(driver); }
	 * 
	 * 
	 * public SignInPageObject selectTemplateSecond(String template) {
	 * Assert.assertEquals(true, selectByVisibleText(templateSelectTwo, template));
	 * return new SignInPageObject(driver); }
	 * 
	 * public SignInPageObject clickApply() {
	 * Assert.assertEquals(true,click(apply)); return new SignInPageObject(driver);
	 * }
	 */
	
	
	
	
	
}
