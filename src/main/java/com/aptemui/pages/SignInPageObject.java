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
import com.aptemui.utils.ExecuteQuery;


public class SignInPageObject extends ActionMethods{
	
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
	
	public SignInPageObject clickLaxmiTenant()
	{
		Assert.assertEquals(true,click(laxmiTenant));
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
	
	public CompilanceDocumentsPage clickSignInButton()
	{
		Assert.assertEquals(true,click(signInButton));
		return new CompilanceDocumentsPage(driver);
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
	
	
}
