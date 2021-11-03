package com.aptemui.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aptemui.base.ActionMethods;
import com.aptemui.extent.ExtentTestManager;
import com.aptemui.utils.ExecuteQuery;


public class CompilanceDocumentsPage extends ActionMethods{
	
	@FindBy(id="username-email")
	private WebElement username;
	
	
	@FindBy(id="enterLogin")
	private WebElement nextButton;
	
	
	@FindBy(xpath="//*[text()[normalize-space()='Available tenants']]/../div/span")
	private WebElement availableTenants;
	
	@FindBy(xpath="//li[text()='Default']")
	private WebElement defaulTenant;
	
	@FindBy(xpath="//li[text()='laxmi']")
	private WebElement laxmiTenant;
	
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
	
	@FindBy(xpath="//*[@id='ecompliance-documents-editor']/div[3]/div[@data-role='but-ok']")
	private WebElement confirmButtonForComplianceDocuments;
	
	
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
	
	
	
	@FindBy(xpath="//menu/..")
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
	
	public CompilanceDocumentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public CompilanceDocumentsPage enterUsername(String username)
	{
		Assert.assertEquals(true,typeText(this.username,username));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickNext()
	{
		Assert.assertEquals(true,click(nextButton));
		return new CompilanceDocumentsPage(driver);
	}

	public CompilanceDocumentsPage clickTenant()
	{
		Assert.assertEquals(true,click(availableTenants));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickDefaultTenant()
	{
		Assert.assertEquals(true,click(defaulTenant));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickLaxmiTenant()
	{
		Assert.assertEquals(true,click(laxmiTenant));
		return new CompilanceDocumentsPage(driver);
	}
	

	
	public CompilanceDocumentsPage clickNextAfterSelectedTenant()
	{
		Assert.assertEquals(true,click(tenantSelectedNextButton));
		return new CompilanceDocumentsPage(driver);
	}
	
	
	public CompilanceDocumentsPage enterPassword(String password)
	{
		Assert.assertEquals(true,typeText(this.password,password));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickSignInButton()
	{
		Assert.assertEquals(true,click(signInButton));
		return new CompilanceDocumentsPage(driver);
	}
	public CompilanceDocumentsPage searchTenant(String tenant)
	{
		Assert.assertEquals(true,typeText(searchTenant,tenant));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickTenantSearchButton()
	{
		Assert.assertEquals(true,click(searchButton));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage compilanceDocumentVerification(String disableORenable)
	{
		
		
		Assert.assertEquals(true,
				verifyNewTabWindowOfClickAndVerifyElement(
						disableORenable,
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
		return new CompilanceDocumentsPage(driver);
	}
	
	
	
	// for third scenarios
	public CompilanceDocumentsPage clickTenantURLLinkForLearnerProgramme(
			String disableORenable,
			//String url,
			String name
			)
	{
		
		
		System.out.println("request1"+ disableORenable);
		
		
		Assert.assertEquals(true,
				verifyNewTabWindowOfClickAndVerifyElementForLearnerProgramme(
						disableORenable,
					//	url,
						name,
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
		return new CompilanceDocumentsPage(driver);
	}
	
	
	public CompilanceDocumentsPage navigateToLearnersAccount(String url) throws InterruptedException
	{		
		
				Assert.assertEquals(true, navigate(url));
			
		
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage signInLearnerAccount(String username, String password)
	{
		Assert.assertEquals(true,typeText(learnerUsername, username));
		Assert.assertEquals(true,typeText(learnerPassword, password));
		Assert.assertEquals(true,click(learnerSignInButton));
		return new CompilanceDocumentsPage(driver);
	}
	
	
	public CompilanceDocumentsPage clickSideMenuAndLearningPlan()
	{
		waitFor("10");
		Assert.assertEquals(true, click(learningPlanLink));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickSideMenuAndDocuments()
	{
		waitFor("5");
		Assert.assertEquals(true, click(documentsMenuLink));
		return new CompilanceDocumentsPage(driver);
	}
		
	
	
	public CompilanceDocumentsPage clickActionsRequired()
	{
		waitFor("10");
		Assert.assertEquals(true,click(actionsRequired));
		return new CompilanceDocumentsPage(driver);
	}
	
	
	@FindBy(xpath="(//*[text()='Signatures Required']/../..)[1]")
	private WebElement signatureRequired;
	public CompilanceDocumentsPage clickSignaturesRequired()
	{
		waitFor("10");
		Assert.assertEquals(true,click(signatureRequired));
		return new CompilanceDocumentsPage(driver);
	}
	
	
	public CompilanceDocumentsPage verifyContent(String content)
	{
		
		boolean flag = waitForElementVisibleByXPath("(//*[text()[normalize-space()='"+content+"']])[2]");
		Assert.assertEquals(true, flag);
		
		if(flag==true) {
			Assert.assertEquals(true, flag);
			ExtentTestManager.screeshortForFinalVerification("pass", content,  " is displayed and verified successfully");
			
		}
		else {
			Assert.assertEquals(true, flag);
			ExtentTestManager.screeshortForFinalVerification("fail", content,  " is displayed and verified successfully");
			
			
		}
		
		
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage verifyContentNOTDisplayed(String content)
	{
		Assert.assertEquals(true, elementNOTVisibleByXPath("(//*[text()[normalize-space()='"+content+"']])[2]"));
		ExtentTestManager.screeshortForFinalVerification("pass", content,  " is NOT displayed and verified successfully");
		return new CompilanceDocumentsPage(driver);
	}
	
	
	public CompilanceDocumentsPage clickRefreshIconOfComplianceDocuments()
	{
		try {
			Thread.sleep(10000);
			Assert.assertEquals(true, click(complianceDocumentsRefresh));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickCreateForLearnersProgramme(String value)
	{
		WebElement create = waitAndReturnElementPresentByXPath("//td[contains(text(), '"+value+"')]/../td/a[text()='Create']");
		Assert.assertNotEquals(null, create);
		Assert.assertEquals(true, click(create));
		return new CompilanceDocumentsPage(driver);
	}
		
	public CompilanceDocumentsPage clickUpdateForLearnersProgramme(String value)
	{
		WebElement create = waitAndReturnElementPresentByXPath("//td[contains(text(), '"+value+"')]/../td/a[text()='Update']");
		Assert.assertNotEquals(null, create);
		Assert.assertEquals(true, click(create));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage updateSignatureOfLearningUsingSQLQuery()
	{
		try {
			Assert.assertEquals(true, ExecuteQuery.updateSignerUsingDBQuery());
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickYesOfCommitmentStatement()
	{
		Assert.assertEquals(true, click(yesOfCommitmentStatement));
		return new CompilanceDocumentsPage(driver);
	}
	
	
	
	public CompilanceDocumentsPage clickReviewSign()
	{
		Assert.assertEquals(true, click(reviewSign));
		return new CompilanceDocumentsPage(driver);
	}
	
	public CompilanceDocumentsPage clickSign(String value)
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
		return new CompilanceDocumentsPage(driver);
	}
	
	
	
	
	
	
	
	
	@FindBy(xpath="//iframe")
	private WebElement frameSignInWindow;
	public CompilanceDocumentsPage switchToSignWindowAndClickHereToSign()
	{
		try {
			Thread.sleep(10000);
			Assert.assertEquals(true, switchToSignFrameWindow(frameSignInWindow, sign));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new CompilanceDocumentsPage(driver);
	}
	
	
	public CompilanceDocumentsPage clickSaveForReviewSign()
	{
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, click(saveReviewSign));
		return new CompilanceDocumentsPage(driver);
	}
	
	
	public CompilanceDocumentsPage pageRefresh()
	{
		Assert.assertEquals(true, refresh());
		waitFor("5");
		return new CompilanceDocumentsPage(driver);
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
