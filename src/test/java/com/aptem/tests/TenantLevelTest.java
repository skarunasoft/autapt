package com.aptem.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aptemui.base.BaseDriver;
import com.aptemui.extent.ExtentTestManager;
import com.aptemui.utils.ResourceHandler;

public class TenantLevelTest extends BaseDriver {
	
	
	
	/**
	 * @testcase id: 9156
	 */
	@Test
	public void disableComplianceDocumentsAtTenantLevel() {
		try {
		signInPageObject.enterUsername(ResourceHandler.getPropValue("app_username"))
		  .clickNext()
		  .clickTenant()
		  //.clickDefaultTenant()
		  .clickLaxmiTenant()
		  .clickNextAfterSelectedTenant()
		  .enterPassword(ResourceHandler.getPropValue("app_password"))
		  .clickSignInButton()
		  .searchTenant("laxmi")
		  .clickTenantSearchButton()
		  .clickTenantURLLink("laxmi", "disable") 
		  .navigateToLearnersAccount(ResourceHandler.getPropValue("learner_url"))
		  .signInLearnerAccount(
				  ResourceHandler.getPropValue("learner_username"),
				  ResourceHandler.getPropValue("learner_password")
				  )
		  .clickSideMenuAndLearningPlan()
		  .verifyContent("Learning Plan")
		  ;
		 
		} catch (Exception | AssertionError e)
		{
			ExtentTestManager.logEventToReport("error", e.getMessage(), " Test steps has not been completed");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * @testcase id: 9157
	 */
	
	@Test
	public void enableComplianceDocumentsAtTenantLevel()
	{
		try {		
		signInPageObject.enterUsername(ResourceHandler.getPropValue("app_username"))
		.clickNext()
		  .clickTenant()
		 // .clickDefaultTenant()
		  .clickLaxmiTenant()
		  .clickNextAfterSelectedTenant()
		  .enterPassword(ResourceHandler.getPropValue("app_password"))
		  .clickSignInButton()
		  .searchTenant("laxmi")
		  .clickTenantSearchButton()
		  .clickTenantURLLink("laxmi", "enable")
		  .navigateToLearnersAccount(ResourceHandler.getPropValue("learner_url"))
		  .signInLearnerAccount( ResourceHandler.getPropValue("learner_username"), ResourceHandler.getPropValue("learner_password"))
		  .clickSideMenuAndLearningPlan()
		  .verifyContent("Learning Plan") ;
	} 
		catch (Exception | AssertionError e)
		{
		ExtentTestManager.logEventToReport("error", e.getMessage(), " Test steps has not been completed");
		Assert.fail(e.getMessage());
		e.printStackTrace();
	}		
	}
	
	/**
	 * @testcase id: 9158
	 */
	
	@Test
	public void  addDocumentsToTheLearnersProgramme()
	{
		
		try {
			//String name = ActionMethods.getSaltString();
			// auto-test should be presented inside the comilance documents 
			String name="auto-test";
			signInPageObject 
			.enterUsername(ResourceHandler.getPropValue("app_username"))
							.clickNext()
							  .clickTenant() 
							//  .clickDefaultTenant()
							  .clickLaxmiTenant()
							  .clickNextAfterSelectedTenant()
							  .enterPassword(ResourceHandler.getPropValue("app_password"))
							  .clickSignInButton()
							 .searchTenant("laxmi")
							  .clickTenantSearchButton()
							  .clickTenantURLLinkForLearnerProgramme("laxmi", "enable", name)
							  .navigateToLearnersAccount(ResourceHandler.getPropValue("laxmi_profile_url"))
							  .clickRefreshIconOfComplianceDocuments()
							  .clickUpdateForLearnersProgramme(name)
							  .clickYesOfCommitmentStatement()
							  .updateSignatureOfLearningUsingSQLQuery()
			  .navigateToLearnersAccount(ResourceHandler.getPropValue("learner_url"))
			  .signInLearnerAccount(
					  ResourceHandler.getPropValue("learner_username"),
					  ResourceHandler.getPropValue("learner_password")
					  )
			  .clickSideMenuAndLearningPlan()
			  .verifyContentNOTDisplayed("Learning Plan")
			  .clickSideMenuAndDocuments()
			  .clickSignaturesRequired()
			  .clickSign(name)
			  .switchToSignWindowAndClickHereToSign()
			  .clickSaveForReviewSign()
			  .clickSideMenuAndLearningPlan()
			  .pageRefresh()
			  .verifyContent("Learning Plan")
			  ;
		} catch (Exception | AssertionError e)
		{
			ExtentTestManager.logEventToReport("error", e.getMessage(), " Test steps has not been completed");
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}
	
	
	}
	

}
